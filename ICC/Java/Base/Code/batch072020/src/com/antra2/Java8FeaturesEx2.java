package com.antra2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class Java8FeaturesEx2 {

	public static void main(String[] args) {
		
		Abc abc=new Abc();
		I4 i4=abc::someMethod;
		i4.m1();
		//I1 i1=A::methodname;
		/*A a=new A();
		I1 i1=a::last;
		i1.m1();*/
		
		//A a=new A();
		/*I1 i=A::new;
		i.m1();*/
		/*List<Person> list=Arrays.asList(new Person("Sara","F",20),
				new Person("Sara","F",27),
				new Person("Bob","M",20),
				new Person("Paula","F",32),
				new Person("Paul","M",32),
				new Person("Jack","M",2),
				new Person("Jack","M",72),
				new Person("Jill","F",12)
				);*/
		/*List<Person> newList=list.stream().filter(p->{if(p.getGender().equals("M")) {return true;}else {return false;} })
					.map(p->{int age=p.getAge();
						p.setAge(age+1);
						return p;
					}).collect(Collectors.toList());
		
		newList.stream().forEach(s->System.out.println(s.getAge()));*/
		/*List<Person> newList=list.stream().filter(person->{if(person.getGender().equals("F")) {
			return true;
		}else
			return false;
				
		}).collect(Collectors.toList());
		
		newList.stream().forEach(s->System.out.println(s.getName()));*/
		
		/*List<Integer> al=new ArrayList<Integer>();
		al.add(4);//new Integer(4);al.add(new Person(1,"",))
		al.add(9);
		al.add(13);
		al.add(4);
		al.add(78);
		al.add(43);
		al.add(89);
		
		al.stream().forEach(i->System.out.println(i));*/
		
		
		//Consumer<Integer> cm=i->System.out.println(i);
		
		
		
		
		/*for(Integer o:al) {
			System.out.println(o);
		}*/
		/*Iterator it=al.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}*/
	}
}
