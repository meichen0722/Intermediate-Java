package hello;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionApi {

	public static void main(String[] args) {
		/*list*/
		List<String> words = new ArrayList<>(List.of("hello", "goodbye", "short", "reallyverylong"));
		words.forEach(s -> System.out.println(s));
		System.out.println("==========");
		words.replaceAll(s -> s.toUpperCase());
		words.forEach(s -> System.out.println(s));
		System.out.println("==========");
		words.removeIf(s -> s.length() > 6);
		words.forEach(s -> System.out.println(s));
		System.out.println("==========");
		
		/*map*/
		LocalDate today = LocalDate.now();
		LocalDate tomorrow = today.plusDays(1);
		LocalDate yesterday = today.minusDays(1);
		Map<LocalDate, String> workCal = new HashMap<>(Map.of(
		        today, "Clear desk",
		        tomorrow, "Leave early"
		));

		Map<LocalDate, String> homeCal = Map.of(
		        yesterday, "Buy party food",
		        tomorrow, "Party all night long!"
		);
		homeCal.forEach((k,v) -> System.out.printf("On %1$tm/%0$te %1s\n", k, v));
		System.out.println("==========");
		
		workCal.compute(today, (k,v) -> v + " to make boss happy!");
		workCal.forEach((k,v) -> System.out.printf("On %1$tm/%0$te %1s\n", k, v));
		System.out.println("==========");
		
		//merge 2 maps
		Map<LocalDate, String> combineCal = workCal;
		homeCal.forEach((k,v) -> combineCal.merge(k, v, (oldVal, newVal) -> oldVal + " and " + newVal));
		combineCal.forEach((k,v) -> System.out.printf("On %1$tm/%0$te %1s\n", k, v));
	}

}
