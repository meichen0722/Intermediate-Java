package students;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Student {
	
	private String name;
	private float gpa;
	private List<String> courses;
	
	private Student(String name, float gpa, List<String> courses) {
		if(name == null || gpa < 0 || gpa > 4) {
			throw new IllegalArgumentException("Bad values!");
		}
		this.name = name;
		this.gpa = gpa;
		this.courses = courses;
	}
	
	public static Student ofNameGpaCourses(String name, float gpa, String ... courses) {
		return new Student(name, gpa, Arrays.asList(courses));
	}

	public String getName() {
		return name;
	}

	public float getGpa() {
		return gpa;
	}

	//getter: make non-primitive mutable variable unmodifiable
	public List<String> getCourses() {
		return Collections.unmodifiableList(courses);
	}
	
	@Override
	  public String toString() {
	    return "Student{" +
	        "name='" + name + '\'' +
	        ", gpa=" + gpa +
	        ", courses=" + courses +
	        '}';
	  }
	
	//implement generic interface Criterion<E>
	public static Criterion<Student> getSmartnessCriterion(float threshold){
		return s -> s.getGpa() > threshold;
	}
	
	private static Criterion<Student> ethusiasmCrierion = s -> s.getCourses().size() > 3;
	
	public static Criterion<Student> getEthusiamCriterion(){
		return ethusiasmCrierion;
	}
	
}
