package students;

//generic interface
//s -> test(s)
interface Criterion<E> {
	boolean test(E s);
	
	default Criterion<E> negate(){
		return s -> !this.test(s);
	}
	
	default Criterion<E> and(Criterion<E> c2){
		return s -> this.test(s) && c2.test(s);
	}
}
