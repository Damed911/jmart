package com.DaffaJmartRK;

import java.util.Vector;
import java.util.function.*;
/**
 * Class ObjectPoolThread untuk mengaplikasikan thread pada program Jmart
 * @author M. Daffa Ajiputra
 * @version Final
 * @param <T>
 */
public class ObjectPoolThread<T> extends Thread{
	/**
    * Instance variable untuk ObjectPoolThread Class
    */
	private boolean exitSignal = false;
	private Vector<T> objectPool = new Vector<>();
	private Function<T, Boolean> routine;
	/**
     * Constructor method untuk class Object PoolThread
     * @param name	name
     * @param routine	function
     */
	public ObjectPoolThread(String name, Function<T, Boolean> routine) {
		super(name);
		this.routine = routine;
	}
	/**
     * Constructor method untuk class Object PoolThread
     * @param routine	function
     */
	public ObjectPoolThread(Function<T, Boolean> routine) {
		this.routine = routine;
	}
	/**
     * Method untuk menambahkan object pada thread
     * @param object	Object
     */
	public synchronized void add (T object) {
		objectPool.add(object);
		super.notify();
	}
	/**
     * Method untuk keluar dari thread
     */
	public synchronized void exit () {
		exitSignal = true;
		super.notify();
	}
	/**
     *Method untuk menjalankan thread
     */
	@Override
	public void run() {
		while(true){
			synchronized(this) {
				while(objectPool.isEmpty() && !exitSignal) {
					try {super.wait();}
					catch(InterruptedException e) {e.printStackTrace();}
				}
				if(exitSignal) break;
			}
			for(int i = 0;i < objectPool.size();++i) {
				if(routine.apply(objectPool.get(i)))
					objectPool.set(i, null);
			}
			objectPool.removeIf(obj -> obj == null);
		}
	}
	public int size() {
		return objectPool.size();
	}
}
