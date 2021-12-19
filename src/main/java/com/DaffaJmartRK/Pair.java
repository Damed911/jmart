package com.DaffaJmartRK;
/**
 * Class untuk mendefinisikan pair pada Jmart
 * @author M. Daffa ajiputra
 * @version Final
 * @param <T>
 * @param <U>
 */
public class Pair<T, U> {
	/**
	 * Instance Variable class pair
	 */
	public T first;
	public U second;
	/**
     * Constructor method untuk class pair
     */
	public Pair() {}
	/**
     * Constructor method untuk class pair
     * @param first		nilai pertama
     * @param second	nilai kedua
     */
	public Pair(T first, U second) {
		this.first = first;
		this.second = second;
	}
}
