package shopping;

public class Shoe implements Colored, Sized{
	
	private String color;
	private int size;
	
	public Shoe(String color, int size) {
		super();
		this.color = color;
		this.size = size;
	}

	@Override
	public String getColor() {
		return color;
	}
	@Override
	public int getSize() {
		return size;
	}
	
	@Override
	  public String toString() {
	    return "Shoe{" +
	        "color='" + color + '\'' +
	        ", size=" + size +
	        '}';
	  }
}
