package collections;

import java.util.List;

import students.Student;

import java.util.stream.Collectors;

public class StudentCollections {
	
	public static String gradeLetter(Student s) {
		float gpa = s.getGpa();
		if(gpa > 3.6) return "A";
		else if(gpa > 3.4) return "B";
		else if(gpa > 3.0) return "C";
		else if(gpa > 2.6) return "D";
		else return "E";
	}

	  public static void main(String[] args) {
	    List<Student> school = List.of(
//	        Student.ofNameGpaCourses("Fred", 2.2F, "Math", "Physics", "Politics", "History of Art"),
//	        Student.ofNameGpaCourses("Jim", 2.7F, "Math"),
//	        Student.ofNameGpaCourses("Tony", 2.3F, "Math", "Art", "Engineering"),
//	        Student.ofNameGpaCourses("Alice", 3.5F, "Math"),
//	        Student.ofNameGpaCourses("Sarah", 3.7F, "Math", "Philosophy", "German Literature"),
//	        Student.ofNameGpaCourses("Sheila", 3.8F, "Math", "Physics", "Astrophysics", "Quantum Mechanics")
	        Student.ofNameGpaCourses("Fred", 2.2F, "Math", "Physics", "Politics", "History of Art"),
	        Student.ofNameGpaCourses("Jim", 3.9F, "Math"),
	        Student.ofNameGpaCourses("Tony", 3.9F, "Math", "Art", "Engineering"),
	        Student.ofNameGpaCourses("Alice", 2.2F, "Math"),
	        Student.ofNameGpaCourses("Sarah", 3.9F, "Math", "Philosophy", "German Literature"),
	        Student.ofNameGpaCourses("Sheila", 2.2F, "Math", "Physics", "Astrophysics", "Quantum Mechanics")
	    );
	    
	    school.stream()
	    //R collect(Collector<? super T,A,R> collector):Performs a mutable reduction operation on the elements of this stream using a Collector
	    .collect(Collectors.groupingBy(s -> gradeLetter(s)))
	    //groupingBy(Function<? super T,? extends K> classifier): group elements by classifier. return a Map.
	    //classifier - a classifier function mapping input elements (students) to keys (grades)
	    
	    .forEach((k,v) -> System.out.println(k + " got by " + v));
	    
	    school.stream()
//	    //Collector<T,?,Map<K,D>> groupingBy(Function<? super T,? extends K> classifier, Collector<? super T,A,D> downstream)
//	    //Returns a Collector implementing a cascaded "group by" operation on input elements of type T, grouping elements according to a classification function,
//	    //and then performing a reduction operation on the values associated with a given key using the specified downstream Collector.
//	    //downstream - a Collector implementing the downstream reduction
	    .collect(Collectors.groupingBy(s -> StudentCollections.gradeLetter(s), Collectors.counting()))
	    .forEach((k,v) -> System.out.println("Grade " + k + " achieved by " + v + " students."));
	  }
	    
}


