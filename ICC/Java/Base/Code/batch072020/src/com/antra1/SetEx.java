package com.antra1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetEx {

	public static void main(String[] args) {
		
		
		
		Set set=new TreeSet(new SortedSetEx());//allows only homogenious objects//it is sorted output//balanced tree Data structure
		set.add(13);
		set.add(55);
		set.add(34);
		set.add(18);
		set.add(4);
		set.add(87);
		set.add(7);
		set.add(56);
		set.add(9);
		set.add(45);
		set.add(78);
		
		Iterator it=set.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		
		//Set set=new HashSet();//un orderd//no duplicates are allowed//HashTable data structure
		/*Set set=new LinkedHashSet();//it is orderd //no duplicates are allowed//Hashtable and linked list Data structure
		set.add(1);
		set.add("Manas");
		set.add(856);
		set.add(new Student());
		set.add(99.8f);
		set.add(856);
		
		Iterator it=set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}*/
		
		/*for(Object o:set) {
			System.out.println(o);
		}*/
		
		/*for(int i=0;i<set.size();i++) {
			System.out.println(set.get());
		}*/
		
	}

}
