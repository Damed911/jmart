package DaffaJmartRK;

import java.util.Vector;
import java.util.function.*;

public class ObjectPoolThread<T> extends Thread{
	private boolean exitSignal;
	private Vector<T> objectPool;
	private Function<T, Boolean> routine;
	
	public ObjectPoolThread(String name, Function<T, Boolean> routine) {
		super(name);
		
	}
	public ObjectPoolThread(Function<T, Boolean> routine) {
		
	}
	public synchronized void add (T object) {
		objectPool.add(object);
	}
	public synchronized void exit () {
		exitSignal = true;
	}
	@Override
	public void run() {
		
	}
	public int size() {
		return objectPool.size();
	}
}
