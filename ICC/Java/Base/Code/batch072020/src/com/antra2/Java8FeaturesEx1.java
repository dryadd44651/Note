package com.antra2;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Java8FeaturesEx1 {

	public static void main(String[] args) {
		
		
		Supplier<Double> sup=()->{return Math.random();};
		//OTP
		System.out.println(sup.get());
		/*Consumer<Integer> consumer=i->System.out.println(i);
		consumer.accept(1);*/
		
		/*Function<Integer,Integer> function=i->{return i*2;}; 
		
		System.out.println(function.apply(5));*/
		
		/*Predicate<Integer> predicate = age -> {
			if (age > 18) {
				return true;
			} else {
				return false;
			}
		};
		
		System.out.println(predicate.test(12));*/
		
		/*I3 i3=()->System.out.println("I am doing work");
		i3.doWork();*/
		
		/*Vechile v1=v->{
				if(v.equals("bike")) {
					return true;
				}else {
					return false;	
				}
			};
		
			System.out.println(v1.isFourWheeler("bike"));*/
			
		/*Vechile v1=new Vechile() {
			
			public boolean isFourWheeler(String vechile) {
				if(vechile.equals("bike")) {
					return true;
				}else {
					return false;	
				}
			}
		};
		
		System.out.println(v1.isFourWheeler("car"));*/
		/*I1.m3();
		I1Impl i1=new I1Impl();
		i1.m2();*/
		
		
	}
}
