// A simple Java program to demonstrate the use of reflection 
import java.lang.reflect.Method; 
import java.lang.reflect.Field; 
import java.lang.reflect.Constructor; 

// class whose object is to be created 
class Test 
{ 
	// creating a private field 
	private String s; 

	// creating a public constructor 
	public Test() { s = "GeeksforGeeks"; } 

	// Creating a public method with no arguments 
	public void method1() { 
		System.out.println("The string is " + s); 
	} 

	// Creating a public method with int as argument 
	public void method2(int n) { 
		System.out.println("The number is " + n); 
	} 

	// creating a private method 
	private void method3() { 
		System.out.println("Private method invoked"); 
	} 
} 

class Demo 
{ 
	public static void main(String args[]) throws Exception 
	{ 
		// Creating object whose property is to be checked 
		Test obj = new Test(); 
        // get class
		Class cls = obj.getClass(); 
		System.out.println("The name of class is " + cls.getName()); 
        // get constutor 
		Constructor constructor = cls.getConstructor(); 
		System.out.println("The name of constructor is " + constructor.getName()); 
        // get method
		System.out.println("The public methods of class are : "); 
		Method[] methods = cls.getMethods(); 
		for (Method method:methods) 
			System.out.println(method.getName()); 
        // get method and call method
		Method methodcall1 = cls.getDeclaredMethod("method2", int.class); 
		// invokes the method at runtime 
		methodcall1.invoke(obj, 19);
        // get private Variable and set it to be accessible (only work after java6)
		Field field = cls.getDeclaredField("s"); 
		field.setAccessible(true); 
		field.set(obj, "JAVA"); 
        // getter of variable s
		Method methodcall2 = cls.getDeclaredMethod("method1"); 
		methodcall2.invoke(obj); 
        // set private function to be accessible
		Method methodcall3 = cls.getDeclaredMethod("method3"); 
		methodcall3.setAccessible(true); 
		methodcall3.invoke(obj); 
        // Reflection
        // Pro: test and debug, review the program
        // Con: Performance Overhead and Exposure of Internals
	} 
} 
