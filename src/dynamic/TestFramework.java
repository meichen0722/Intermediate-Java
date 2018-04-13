package dynamic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class TestFramework {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Properties prop = new Properties();
		prop.load(new FileReader("totest.properties"));
		String classname = prop.getProperty("1");
		System.out.println("class name: " + classname);
		Class cl = Class.forName(classname);
		Object obj = cl.getConstructor().newInstance();
		
		//field
		Field[] fields = cl.getDeclaredFields();
		for(Field f : fields) {
			SetMe annot = f.getAnnotation(SetMe.class); //get SetMe annotation of field f
			if(annot != null) {
				String toInject = prop.getProperty(annot.value(), "No value specified");
				f.setAccessible(true);
				f.set(obj, toInject); //set field f of obj to toInject
			}
		}
		System.out.println("@SetMe");
		System.out.println("Object after'injections' is " + obj);
		System.out.println("================");
		
		//method
		Method[] methods = cl.getDeclaredMethods();
		for(Method m : methods) {
			RunMe annot = m.getAnnotation(RunMe.class);
			if(annot != null) {
				System.out.println("@RunMe value = " + annot.value() + " num = " + annot.num());
		        m.setAccessible(true);
		        m.invoke(obj);
			}
		}
	}

}
