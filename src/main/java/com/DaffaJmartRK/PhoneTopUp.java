package com.DaffaJmartRK;
/**
 * Class untuk membuat dilakukannya topUp menggunakan ponsel
 * @author M. Daffa Ajiputra
 * @version Final
 */
public class PhoneTopUp extends Invoice{
	/**
	 * Instance Variable class PhoneTopUp
	 */
	public String phoneNumber;
	public Status status;
	/**
	 * Constructor method class PhoneTopUp
	 * @param buyerId
	 * @param productId
	 * @param phoneNumber
	 */
	public PhoneTopUp(int buyerId, int productId, String phoneNumber){
		super(buyerId, productId);
		this.phoneNumber = phoneNumber;
	}
	/**
     * Override method getTotalPay untuk mendapatkan harga total
     * @return totalPay
     */
	@Override
	public double getTotalPay(Product product) {
		return Treasury.getAdjustedPrice(product.price, product.discount);
	}
}
