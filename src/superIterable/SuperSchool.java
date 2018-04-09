package superIterable;

import java.util.List;

import students.Student;

public class SuperSchool {

	public static void main(String[] args) {
		List<Student> schoolList = List.of(
		        Student.ofNameGpaCourses("Fred", 2.2F, "Math", "Physics", "Politics", "History of Art"),
		        Student.ofNameGpaCourses("Jim", 2.7F, "Math"),
		        Student.ofNameGpaCourses("Tony", 2.3F, "Math", "Art", "Engineering"),
		        Student.ofNameGpaCourses("Alice", 3.5F, "Math"),
		        Student.ofNameGpaCourses("Sarah", 3.7F, "Math", "Philosophy", "German Literature"),
		        Student.ofNameGpaCourses("Sheila", 3.8F, "Math", "Physics", "Astrophysics", "Quantum Mechanics")
		    );

		//all students
		schoolList.stream().forEach(s -> System.out.println(s.getName()));
		System.out.println("========");
		//all smart students
		schoolList.stream().filter(s -> s.getGpa() > 3).forEach(s -> System.out.println(s.getName()));
		System.out.println("========");
		//all smart students: name and grade
		schoolList.stream().filter(s -> s.getGpa() > 3).forEach(s -> System.out.println(s.getName() + " got " + s.getGpa()));
		System.out.println("========");
		//all courses
		schoolList.stream().flatMap(s -> s.getCourses().stream()).distinct().sorted().forEach(s -> System.out.println(s));
		System.out.println("========");
		//all student-course combinations
//		schoolList.stream().forEach(s -> s.getCourses().forEach(c -> System.out.println(s.getName() + " takes " + c)));
		System.out.println("========");
		schoolList.stream().flatMap(s -> s.getCourses().stream().map(c -> s.getName() + " takes " + c)).forEach(str -> System.out.println(str));
	}
}
