package shopping;

public class TryPair {

	public static void main(String[] args) {
		ClothingPair<Shoe> shoes = new ClothingPair<>(new Shoe("red", 40), new Shoe("red", 42));
		System.out.println(shoes.isMatch());
	}
}
