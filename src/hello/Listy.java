package hello;

import java.util.Arrays;
import java.util.List;

public final class Listy {
  public static void main(String[] args) {
//	 List.of() make a copy, Arrays.asList() pass by reference
    String[] dat = {"Fred", "Jim", "Sheila"};
    List<String> ls = List.of(dat);
    List<String> ls2 = Arrays.asList(dat);
    ls.forEach(System.out::println);
    System.out.println("--");
    ls2.forEach(System.out::println);
    System.out.println("------");
    dat[0] = "Broken";
//    ls not affected, ls2 change
    ls.forEach(System.out::println);
    System.out.println("--");
    ls2.forEach(System.out::println);
  }
}
