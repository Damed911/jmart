package com.DaffaJmartRK;
/**
 * Class untuk mengatur kualitas dari produk
 * @author M. Daffa Ajiputra
 * @version Final
 */
public class ProductRating
{
	/**
	 * Instance Variable class ProductRating
	 */
    private long total;
    private long count;
    /**
     * Constructor Method untuk objek class ProductRating
     */
    public ProductRating(){
        this.total =  0;
        this.count = 0;
    }
    /**
     * Method untuk menambahkan rating
     * @param rating product rating
     */
    public void insert(int rating){
        this.total = total + rating;
        this.count++;
    }
    /**
     * Method untuk menghitung rating rata-rata product
     * @return rating
     */
    public double getAverage(){
        double average = total/count;
        if(count < 1){
            return 0.0;
        }
        return average;
    }
    /**
     * Accessor method untuk mendapatkan nilai count
     * @return count
     */
    public long getCount(){
        return count;
    }
    /**
     * Accessor method untuk mendapatkan nilai total
     * @return total
     */
    public long getTotal(){
        return total;
    }
}
