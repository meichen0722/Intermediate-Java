package collections;

import java.util.OptionalDouble;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.DoubleStream;

final class Average{
	
	private double sum;
	private int count;
	
	void include(double d) {
		sum += d;
		count++;
	}
	
	void merge(Average b) {
		sum += b.sum;
		count += b.count;
	}
	
	OptionalDouble get() { //get avg
		return count == 0 ? OptionalDouble.empty() : OptionalDouble.of(sum/count);
	}
}

public class Averager {

	public static void main(String[] args) {
		long start = System.nanoTime();
		
		//collect​(Supplier<R> supplier, BiConsumer<R,? super T> accumulator, BiConsumer<R,R> combiner): 
		//Performs a mutable reduction operation on the elements of this stream.
		
		DoubleStream s = DoubleStream.generate(() -> ThreadLocalRandom.current().nextDouble(-Math.PI, Math.PI));
		s
		.parallel() //Returns an equivalent stream that is parallel
		.limit(500_000_000L) //Returns a stream consisting of the elements of this stream, truncated to be no longer than maxSize in length.
		.collect(() -> new Average(), (b,d) -> b.include(d), (bFinal,b) -> bFinal.merge(b))
		.get()
		.ifPresentOrElse((avg) -> System.out.println("Average is " + avg), () -> System.out.println("Not a steam!"));
		
		long time = System.nanoTime() - start;
	    System.out.printf("Total time %9.6f seconds\n", (time / 1_000_000_000.0));
	}

}
