package DaffaJmartRK;
import java.util.*;

public class Algorithm {
	private Algorithm(){}
	public static <T> List<T> collect(T[] Array, T value){
		List<T> tempList = new ArrayList<T>();
		for(T tempArray : Array) {
			if(tempArray.equals(value)) {
				tempList.add(tempArray);
			}
			else {
				continue;
			}
		}
		return tempList;
	}
	public static <T> List<T> collect(Iterable<T> iterable, T value){
		List<T> tempList = new ArrayList<T>();
		for(T t : iterable) {
			if(t.equals(value)) {
				tempList.add(t);
			}
			else {
				continue;
			}
		}
		return tempList;
	}
	public static <T> List<T> collect(Iterator<T> iterator, T value){
		List<T> tempList = new ArrayList<T>();
		while(iterator.hasNext()) {
			if(iterator.next().equals(value)) {
				tempList.add(iterator.next());
			}
		}
		return tempList;
	}
	public static <T> List<T> collect(T[] Array, Predicate<T> pred){
		List<T> tempList = new ArrayList<T>();
		for(T tempArray : Array){
			if(pred.predicate(tempArray)) {
				tempList.add(tempArray);
			}
		}
		return tempList;
	}
	public static <T> List<T> collect(Iterable<T> iterable, Predicate<T> pred){
		List<T> tempList = new ArrayList<T>();
		for(T tempArray : iterable){
			if(pred.predicate(tempArray) == true) {
				tempList.add(tempArray);
			}
		}
		return tempList;
	}
	public static <T> List<T> collect(Iterator<T> iterator, Predicate<T> pred){
		List<T> tempList = new ArrayList<T>();
		while(iterator.hasNext()) {
			if(pred.predicate(iterator.next()) == true) {
				tempList.add(iterator.next());
			}
		}
		return tempList;
	}
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
		final Iterator<T> a = Arrays.stream(Array).iterator();
		return find(a, value);
	}
	public static <T> T find(Iterable<T> iterable, T value) {
		final Iterator <T> a = iterable.iterator();
		return find(a, value);
	}
	public static <T> T find(Iterator<T> iterator, T value) {
		final Predicate <T> pred = value::equals;
		return find(iterator, pred);
	}
	public static <T> T find(T[] Array, Predicate<T>pred) {
		return null;
	}
	public static <T> T find(Iterable<T> iterable, Predicate<T>pred) {
		return null;
	}
	public static <T> T find(Iterator<T> iterator, Predicate<T>pred) {
		return null;
	}
	public static <T extends Comparable<? super T>> T max(T first, T second){
		if(first.compareTo(second) > 0) {
			return first;
		}
		return second;
	}
	public static <T extends Comparable<? super T>> T max(T[] Array) {
		List<T> List = Arrays.asList(Array);
		return Collections.max(List);
	}
	public static <T extends Comparable<? super T>> T max(Iterable<T> iterable) {
		List<T> List = new ArrayList<T>();
		iterable.forEach(List::add);
		return Collections.max(List);
	}
	public static <T extends Comparable<? super T>> T max(Iterator<T> iterator) {
		List<T> List = new ArrayList<T>();
		iterator.forEachRemaining(List::add);
		return Collections.max(List);
	}
	public static <T extends Comparator<? super T>> T max(T first, T second, Comparator<? super T> comparator) {
		List<T> List = new ArrayList<T>();
		List.add(first);
		List.add(second);
		return Collections.max(List, comparator);
	}
	public static <T extends Comparator<? super T>> T max(T[] Array, Comparator<? super T> comparator) {
		List<T> List = Arrays.asList(Array);
		return Collections.max(List, comparator);
	}
	public static <T extends Comparator<? super T>> T max(Iterable<T> iterable, Comparator<? super T> comparator) {
		List<T> List = new ArrayList<T>();
		iterable.forEach(List::add);
		return Collections.max(List, comparator);
	}
	public static <T extends Comparator<? super T>> T max(Iterator<T> iterator, Comparator<? super T> comparator) {
		List<T> List = new ArrayList<T>();
		iterator.forEachRemaining(List::add);
		return Collections.max(List, comparator);
	}
	public static <T extends Comparable<? super T>> T min(T first, T second) {
		if(first.compareTo(second) < 0) {
			return first;
		}
		return second;
	}
	public static <T extends Comparable<? super T>> T min(T[] Array) {
		List<T> List = Arrays.asList(Array);
		return Collections.min(List);
	}
	public static <T extends Comparable<? super T>> T min(Iterable<T> iterable) {
		List<T> List = new ArrayList<T>();
		iterable.forEach(List::add);
		return Collections.min(List);
	}
	public static <T extends Comparable<? super T>> T min(Iterator<T> iterator) {
		List<T> List = new ArrayList<T>();
		iterator.forEachRemaining(List::add);
		return Collections.min(List);
	}
	public static <T extends Comparator<? super T>> T min(T first, T second, Comparator<? super T> comparator) {
		List<T> List = new ArrayList<T>();
		List.add(first);
		List.add(second);
		return Collections.min(List, comparator);
	}
	public static <T extends Comparator<? super T>> T min(T[] Array, Comparator<? super T> comparator) {
		List<T> List = Arrays.asList(Array);
		return Collections.min(List, comparator);
	}
	public static <T extends Comparator<? super T>> T min(Iterable<T> iterable, Comparator<? super T> comparator) {
		List<T> List = new ArrayList<T>();
		iterable.forEach(List::add);
		return Collections.min(List, comparator);
	}
	public static <T extends Comparator<? super T>> T min(Iterator<T> iterator, Comparator<? super T> comparator) {
		List<T> List = new ArrayList<T>();
		iterator.forEachRemaining(List::add);
		return Collections.min(List, comparator);
	}
} 