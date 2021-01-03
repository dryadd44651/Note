package net.antra.design.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SingletonA {
	private static final SingletonA instance = new SingletonA();

	private SingletonA() {
		if (instance != null)
		throw new RuntimeException("Cannot create");
	}

	public static SingletonA getInstance(){
		return instance;
	}
	
	private void dosomething(){
		System.out.println(1234);
	}
	
//	public static void main(String[] arg) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
//		Class clazz = SingletonA.class;
//		Constructor[] cs = clazz.getDeclaredConstructors();
//		
//		Method m = clazz.getDeclaredMethod("dosomething", null);
//		m.setAccessible(true);
//		m.invoke(SingletonA.getInstance(),	 null);
//	}
}
