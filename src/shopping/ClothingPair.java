package shopping;

public class ClothingPair<E extends Colored & Sized> extends Pair<E>{

	public ClothingPair(E left, E right) {
		super(left, right);
	}
	
	public boolean isMatch() {
		return left.getColor().equals(right.getColor()) && left.getSize() == right.getSize();
	}
}
