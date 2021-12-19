package com.DaffaJmartRK;

import com.DaffaJmartRK.dbjson.Serializable;
/**
 * Class untuk mendefinisikan setiap kupan pada Jmart
 * @author M. Daffa Ajiputra
 * @version Final
 */
public class Coupon extends Serializable
{
	/**
	 * Instance Variable class coupon
	 */
    public String name;
    public int code;
    public double cut;
    public Type type;
    public double minimum;
    private boolean used;
    /**
     * Enum Class tipe diskon
     * @author M. Daffa Ajiputra
     * @version Final
     */
    public enum Type{
        DISCOUNT, REBATE;
    }
    /**
     * Constructor method class coupon
     * @param name
     * @param code
     * @param type
     * @param cut
     * @param minimum
     */
    public Coupon(String name, int code, Type type, double cut, double minimum)
    {
        this.name = name;
        this.code = code;
        this.cut = cut;
        this.type = type;
        this.minimum = minimum;
        this.used = false;
    }
    /**
     * Method untuk mengubah kondisi coupon
     * @return used
     */
    public boolean isUsed(){
        return this.used;
    }
    /**
     * Method untuk memeriksa apakah coupon dapat digunaakn
     * @param price		Product price
     * @param discount	discount price
     * @return condition
     */
    public boolean canApply(double price, double discount){
    	if(Treasury.getAdjustedPrice(price, discount) >= minimum && !used){
            return true;
        }else{
            return false;
        }
    }
    /**
     * Method apply untuk memakai coupon
     * @param price		product price
     * @param discount	discount percentage
     * @return adjustedPrice
     */
    public double apply(double price, double discount){
        this.used = true;
        if(type == Type.DISCOUNT){
            if(cut >= 100){
                return (Treasury.getAdjustedPrice(price, discount) - Treasury.getAdjustedPrice(price, discount) * (100 / 100)); //cut max 100%
            }else if(cut <= 0){
                return (Treasury.getAdjustedPrice(price, discount) - Treasury.getAdjustedPrice(price, discount) * (0 / 100)); //cut min 0%
            }else{
                return (Treasury.getAdjustedPrice(price, discount) - Treasury.getAdjustedPrice(price, discount) * (cut / 100));
            }
        }
        return (Treasury.getAdjustedPrice(price, cut) - cut);
    }
}
