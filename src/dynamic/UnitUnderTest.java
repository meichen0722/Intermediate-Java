package dynamic;

public class UnitUnderTest {
	@SetMe("red")
	private String text;
	@SetMe
	private String otherValue;
	@SetMe("blue")
	private String moreText;
	
	@RunMe(value="Mei", num=3)
	public void doStuff() {
		System.out.println("doStuff");
	}
	
	@Override
	  public String toString() {
	    return "UnitUnderTest{" +
	        "text='" + text + '\'' +
	        ", otherValue='" + otherValue + '\'' +
	        ", moreText='" + moreText + '\'' +
	        '}';
	  }

}
