package DaffaJmartRK;
import java.util.*;

public class Algorithm {
	private Algorithm(){}
	public static <T> int count(T[] Array, T value){
		int count = 0;
		for(T arrayValue : Array) {
			if(arrayValue.equals(value)) {
				count++;
			}
		}
		return count;
	}
	public static <T> int count(Iterable<T>iterable, T value) {
		int count = 0;
		for(T t : iterable) {
			if(t.equals(value)) {
				count++;
			}
		}
		return count;
	}
	
	public static <T> int count(Iterator<T>iterator, T value) {
		int count = 0;
		while(iterator.hasNext()) {
			if(iterator.next().equals(value)) {
				count++;
			}
		}
		return count;
	}
	public static <T> int count(T[] Array, Predicate<T>pred) {
		return 0;
	}
	public static <T> int count(Iterable<T>iterable, Predicate<T>pred) {
		return 0;
	}
	public static <T> int count(Iterator<T>iterator, Predicate<T>pred) {
		return 0;
	}
	public static <T> boolean exists(T[] Array, T value) {
		return true;
	}
	public static <T> boolean exists(Iterable<T> iterable, T value) {
		return true;
	}
	public static <T> boolean exists(Iterator<T> iterator, T value) {
		return true;
	}
	public static <T> boolean exists(T[] Array, Predicate<T>pred) {
		return true;
	}
	public static <T> boolean exists(Iterable<T> iterable, Predicate<T>pred) {
		return true;
	}
	public static <T> boolean exists(Iterator<T> iterator, Predicate<T>pred) {
		return true;
	}
	public static <T> T find(T[] Array, T value) {
		return null;
	}
	public static <T> T find(Iterable<T> iterable, T value) {
		return null;
	}
	public static <T> T find(Iterator<T> Array, T value) {
		return null;
	}
	public static <T> T find(T[] Array, Predicate<T>pred) {
		return null;
	}
	public static <T> T find(Iterable<T> iterable, Predicate<T>pred) {
		return null;
	}
	public static <T> T find(Iterator<T> Array, Predicate<T>pred) {
		return null;
	}
	public static <T extends Comparable<? super T>> T max(T first, T second){
		if(first.compareTo(second) > 0) {
			return first;
		}
		return second;
	}
	public static <T extends Comparable<? super T>> T min(T first, T second) {
		if(first.compareTo(second) < 0) {
			return first;
		}
		return second;
	}
} 