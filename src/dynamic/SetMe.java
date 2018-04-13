package dynamic;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

//https://docs.oracle.com/javase/tutorial/java/annotations/predefined.html

@Retention(RetentionPolicy.RUNTIME) //specifies how the marked annotation is stored
@Target(ElementType.FIELD) //marks another annotation to restrict what kind of Java elements the annotation can be applied to
public @interface SetMe {
	String value() default "Unset";
}
