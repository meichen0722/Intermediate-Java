package superIterable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public final class SuperIterable<E> implements Iterable<E>{
	
	private Iterable<E> self;
	
	//constructor
	public SuperIterable(Iterable<E> self) {
		this.self = self;
	}
	
	@Override
	public Iterator<E> iterator(){
		return self.iterator();
	}
	
	//new methods
	//make a copy. DON'T modify the orginal data
	public <F> SuperIterable<F> map(Function<E, F> op){
		List<F> result = new ArrayList<>();
		self.forEach(s -> result.add(op.apply(s)));
		return new SuperIterable<>(result);
	}
	//each element maps to a list
	//return a list contains all the elements in the lists
	//op(A) = {1,2}, op(B) = {3,4} -> return {1,2,3,4}
	public<F> SuperIterable<F> flatmap(Function<E, SuperIterable<F>> op){
		List<F> result = new ArrayList<>();
		self.forEach(s -> op.apply(s).forEach(t -> result.add(t)));
		return new SuperIterable<>(result);
	}
	
	public SuperIterable<E> filter(Predicate<E> test){
		List<E> result = new ArrayList<>();
		self.forEach(s -> {
			if(test.test(s)) {
				result.add(s);
			}
		});
		return new SuperIterable<>(result);
	}

	public static void main(String[] args) {
		SuperIterable<String> sis = new SuperIterable<>(Arrays.asList("Fred", "Jim", "Sheila"));

	    sis
	        .filter(s -> s.length() > 3)
	        .filter(s -> s.length() < 6)
	        .forEach(s -> System.out.println("> " + s));

	    System.out.println("--------------------------------");
	    sis
	        // turn all the names, into upper case...
	        .map(s -> s.toUpperCase())
	        .forEach(s -> System.out.println("> " + s));

	    System.out.println("--------------------------------");
	    sis
	        // turn all the names into their lengths...
	        .map(s -> s.length())
	        .forEach(s -> System.out.println("> " + s));
	    System.out.println("DONE");

	}
	
}

