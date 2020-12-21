package com.antra1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class MapEx {

	public static void main(String[] args) {

		//Map map=new HashMap();//it is unorderd//keys cannot be duplicated and values can be duplicated//Hashtable Data Structure
		//Map map=new LinkedHashMap();//it is orderd //Hashtable and Linked list Data structure
		ConcurrentHashMap map=new ConcurrentHashMap();
		map.put(17, "Manas");
		map.put(67, "Tom");
		map.put(90, "David");
		map.put(66, "chen");
		map.put(34, "Naveen");
		map.put(47, "Mert");
		map.put(56, "Manas");
		map.put(67, "Bob");
		
		Set set=map.keySet();
		Iterator it=set.iterator();
		
		while(it.hasNext()) {
			System.out.println(map.get(it.next()));
			map.put(68, "kumar");
		}
		
	}

}
