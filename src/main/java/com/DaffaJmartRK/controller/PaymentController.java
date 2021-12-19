package com.DaffaJmartRK.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.DaffaJmartRK.Account;
import com.DaffaJmartRK.Algorithm;
import com.DaffaJmartRK.Invoice;
import com.DaffaJmartRK.ObjectPoolThread;
import com.DaffaJmartRK.Payment;
import com.DaffaJmartRK.Product;
import com.DaffaJmartRK.Shipment;
import com.DaffaJmartRK.dbjson.JsonAutowired;
import com.DaffaJmartRK.dbjson.JsonTable;

/**
 * Class untuk mengatur pembayaran yang terjadi pada jmart
 * @author M. Daffa Ajiputra
 * @version Final
 */
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment>{
	/**
	 * Instance Variable Payment Controller
	 */
	public static final long DELIVERED_LIMIT_MS = 3000;
	public static final long ON_DELIVERY_LIMIT_MS = 3000;
	public static final long ON_PROGRESS_LIMIT_MS = 3000;
	public static final long WAITING_CONF_LIMIT_MS = 3000;
	
	@JsonAutowired(filepath = "C:\\Users\\ASUS\\Documents\\jmart\\json\\randomPaymentList.json", value = Payment.class)
	public static JsonTable<Payment> paymentTable;
	public static ObjectPoolThread<Payment> poolThread = new ObjectPoolThread<Payment>("Thread", PaymentController::timekeeper);
	/**
	 * Method untuk mengambil paymentTable
	 */
	@Override
	public JsonTable<Payment> getJsonTable() {
		return paymentTable;
	}
	
	/**
	 * Method untuk mendapatkan invoice dari product milik seller
	 * @param id		product Id
	 * @param page		page number
	 * @param pageSize	ukuran page
	 * @return pageInvoice
	 */
	@GetMapping("/{id}/page")
    @ResponseBody List<Payment> getInvoices(@PathVariable int id, @RequestParam(defaultValue="0") int page, @RequestParam(defaultValue="1000") int pageSize){
        List<Payment> paymentList = new ArrayList<>();
        Account accountTarget = Algorithm.<Account>find(AccountController.accountTable,  a -> a.id == id);
        if(accountTarget != null){
            for(Payment payment : paymentTable){
                for(Product product : ProductController.productTable){
                    if(payment.productId == product.id && product.accountId == accountTarget.id){
                        paymentList.add(payment);
                    }
                }
            }
        }
        return Algorithm.paginate(paymentList, page, pageSize, e->true);
    }
	
	/**
	 * Method untuk mendapatkan invoice dari pembelian penjual
	 * @param id		account id
	 * @param page		page number
	 * @param pageSize	ukuran page
	 * @return paginate
	 */
    @GetMapping("/{id}/purchases/page")
    @ResponseBody List<Payment> getMyInvoices(@PathVariable int id, @RequestParam(defaultValue="0") int page, @RequestParam(defaultValue="1000") int pageSize){
        return Algorithm.<Payment>paginate(getJsonTable(), page, pageSize, p -> p.buyerId == id);
    }
    
    /**
     * Method untuk membuat invoice dari pembelian
     * @param buyerId			id pembeli
     * @param productId			id produk
     * @param productCount		jumlah produk
     * @param shipmentAddress	alamat produk
     * @param shipmentPlan		tipe pengiriman
     * @return newPayment
     */
	@PostMapping("/create")
    public Payment create(@RequestParam int buyerId, @RequestParam int productId, @RequestParam int productCount, @RequestParam String shipmentAddress, @RequestParam byte shipmentPlan) {
    	Account account = new AccountController().getById(buyerId);
    	Product product = new ProductController().getById(productId);
    	Shipment shipment = new Shipment(shipmentAddress, 0, shipmentPlan, null);
    	Payment payment = new Payment(buyerId, productId, productCount, shipment);
    	double totalPay = payment.getTotalPay(product);
    	if(account.balance > totalPay) {
    		account.balance -= totalPay;
    		Payment.Record record = new Payment.Record(Invoice.Status.WAITING_CONFIRMATION, "Pesan");
    		payment.history.add(record);
    		paymentTable.add(payment);
    		poolThread.add(payment);
    		return payment;
    	}
    	return null;
    }
	
	/**
	 * Method untuk menerima pesanan dari customer
	 * @param id
	 * @return condition
	 */
	@PostMapping("/{id}/accept")
	public boolean accept(@RequestParam int id) {
		Payment payment = new PaymentController().getById(id);
		if(payment.history.get(payment.history.size() - 1).status == Invoice.Status.WAITING_CONFIRMATION) {
			Payment.Record record = new Payment.Record(Invoice.Status.ON_PROGRESS, "Pesan");
			payment.history.add(record);
			return true;
		}
		return false;
	}
	/**
	 * Method untuk menggagalkan transaksi yang sedang berlangsung
	 * @param id
	 * @return condition
	 */
	@PostMapping("/{id}/cancel")
	public boolean cancel(@RequestParam int id) {
		Payment payment = new PaymentController().getById(id);
		if(payment.history.get(payment.history.size() - 1).status == Invoice.Status.WAITING_CONFIRMATION) {
			Payment.Record record = new Payment.Record(Invoice.Status.CANCELLED, "Pesan");
			payment.history.add(record);
			return true;
		}
		return false;
	}
	
	/**
	 * Method untuk menyelesaikan pembayaran 
	 * @param id
	 * @param receipt
	 * @return condition
	 */
	@PostMapping("/{id}/submit")
	public boolean submit(@RequestParam int id, @RequestParam String receipt) {
		Payment payment = new PaymentController().getById(id);
		if(payment.history.get(payment.history.size() - 1).status == Invoice.Status.ON_PROGRESS && payment.shipment.receipt.isBlank() == false) {
			payment.shipment.receipt = receipt;
			Payment.Record record = new Payment.Record(Invoice.Status.ON_DELIVERY, "Pesan");
			payment.history.add(record);
			return true;
		}
		return false;
	}
	/**
     * Method untuk membatasi waktu pembayaran
     * @param payment	object payment
     * @return condition
     */
	private static boolean timekeeper(Payment payment) {
		if (payment.history.isEmpty()) {
            return false;
        } else {
            Payment.Record record = payment.history.get(payment.history.size() - 1);
            long elapsed = System.currentTimeMillis() - record.date.getTime();
            if (record.status.equals(Invoice.Status.WAITING_CONFIRMATION) && (elapsed > WAITING_CONF_LIMIT_MS)) {
                record.status = Invoice.Status.FAILED;
                return true;
            } else if (record.status.equals(Invoice.Status.ON_PROGRESS) && (elapsed > ON_PROGRESS_LIMIT_MS)) {
                record.status = Invoice.Status.FAILED;
                return true;
            } else if (record.status.equals(Invoice.Status.ON_DELIVERY) && (elapsed > ON_PROGRESS_LIMIT_MS)) {
                record.status = Invoice.Status.DELIVERED;
                return true;
            } else if (record.status.equals(Invoice.Status.DELIVERED) && (elapsed > DELIVERED_LIMIT_MS)) {
                record.status = Invoice.Status.FINISHED;
                return true;
            } else {
                return false;
            }
        }
	}
}
