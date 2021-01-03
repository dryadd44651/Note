package net.antra.design.singleton;
//not thread safe
public class SingletonB {
	private static SingletonB instance = null;

	private SingletonB(){
	}
	public static SingletonB getInstance(){
			if(instance == null){
				instance = new SingletonB();
			}
		return instance;
	}
	
}
