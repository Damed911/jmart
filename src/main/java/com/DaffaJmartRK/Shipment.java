package com.DaffaJmartRK;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * Class untuk mengatur semua hal yang berkaitan dengan pengiriman produk
 * @author M. Daffa Ajiputra
 * @version Final
 */
public class Shipment
{
	/**
	 * Instance Variable class Shipment
	 */
    public static final SimpleDateFormat ESTIMATION_FORMAT = new SimpleDateFormat();
    public static final Plan INSTANT = new Plan((byte) (1 << 0));
    public static final Plan KARGO = new Plan((byte) (1 << 1));
    public static final Plan NEXT_DAY = new Plan((byte) (1 << 2));
    public static final Plan REGULER = new Plan((byte) (1 << 3));
    public static final Plan SAME_DAY = new Plan((byte) (1 << 4));
    public String address;
    public int cost;
    public byte plan;
    public String receipt;
    /**
     * Inner Class plan pada class Shipment
     * @author M. Daffa Ajiputra
     * @version Final
     */
    public static class Plan{
    	public final byte bit;
    	private Plan(byte bit) {
    		this.bit = bit;
    	}
    }
    /**
     * Method untuk mendapatkan perkiraan produk tiba
     * @param reference	tanggal acuan untuk pengiriman
     * @return Format produk tiba
     */
    public String getEstimatedArrival(Date reference){
    	Calendar cal = Calendar.getInstance();
        cal.setTime(reference);
        if (plan == INSTANT.bit || plan == SAME_DAY.bit){
            cal.add(Calendar.DATE, 0);
        }
        else if (plan == NEXT_DAY.bit){
            cal.add(Calendar.DATE, 1);
        }
        else if (plan == REGULER.bit){
            cal.add(Calendar.DATE, 2);
        }
        else if (plan == KARGO.bit){
            cal.add(Calendar.DATE, 5);
        }
        return ESTIMATION_FORMAT.format(cal.getTime());
    }
    /**
     * Method untuk mendapatkan durasi pengiriman
     * @param reference	Acuan untuk mendapatkan waktu
     * @return duration
     */
    public boolean isDuration(Plan reference){
    	return (this.plan & reference.bit) != 0;
    }
    /**
     * @param object	object yang diukur
     * @param reference Date reference untuk mendapatkan duration
     * @return duration
     */
    public boolean isDuration(byte object, Plan reference) {
    	if((object & reference.bit) == 0) {
            return false;
        }
        return true;
    }
    /**
     * Constructor method untuk class shipment
     * @param address		Alamat tujuan
     * @param shipmentCost	Biaya pengiriman
     * @param plan			Plan pengiriman
     * @param receipt		Receipt pengiriman
     */
    public Shipment(String address, int cost, byte plan, String receipt){
        this.address = address;
        this.cost = cost;
        this.plan = plan;
        this.receipt = receipt;
    }
}
