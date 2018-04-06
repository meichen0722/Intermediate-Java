package students;

import java.util.ArrayList;
import java.util.List;

public class School {
	
	public static <E> void showAll(List<E> ls) {
		for(E s : ls) {
			System.out.println(s);
		}
	}
	
	public static <E> List<E> getByCriterion(Iterable<E> ls, Criterion<E> crit){
		List<E> result = new ArrayList<>();
		for(E s : ls) {
			if(crit.test(s)) {
				result.add(s);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		List<Student> school = List.of(
				Student.ofNameGpaCourses("Fred", 2.2F, "Math", "Physics", "Politics", "History of Art"),
		        Student.ofNameGpaCourses("Jim", 2.7F, "Math"),
		        Student.ofNameGpaCourses("Tony", 2.3F, "Math", "Art", "Engineering"),
		        Student.ofNameGpaCourses("Alice", 3.5F, "Math"),
		        Student.ofNameGpaCourses("Sarah", 3.7F, "Math", "Philosophy", "German Literature"),
		        Student.ofNameGpaCourses("Sheila", 3.8F, "Math", "Physics", "Astrophysics", "Quantum Mechanics")
		);
		showAll(school);
		System.out.println("============================");
		Criterion<Student> smartCriterion = Student.getSmartnessCriterion(3F);
		showAll(getByCriterion(school, smartCriterion));
		System.out.println("============================");
		Criterion<Student> ethusiasmCriterion = Student.getEthusiamCriterion();
		showAll(getByCriterion(school, ethusiasmCriterion));
		System.out.println("============================");
		Criterion<Student> notSmartCriterion = smartCriterion.negate();
		showAll(getByCriterion(school, notSmartCriterion));
		System.out.println("============================");
		Criterion<Student> SmartAndEthusiasmCriterion = smartCriterion.and(ethusiasmCriterion);
		showAll(getByCriterion(school, SmartAndEthusiasmCriterion));
	}

}
