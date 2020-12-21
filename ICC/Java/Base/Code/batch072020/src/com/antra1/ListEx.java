package com.antra1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class ListEx {
	
	public static void main(String[] args) {
		
		List al=new ArrayList();//Object array Data Structure//retriving would be easier
		//List al=new LinkedList();//double linked list Data Structure//insertions and deletion would be easier
		//Vector al=new Vector();//Resizable or Growable array DS//synchronized class
		//Stack al=new Stack();//LIFO
		al.add(4);//new Integer(4);
		al.add(9);
		al.add(13);
		al.add(4);
		al.add(78);
		al.add(43);
		al.add(89);
		
		Iterator it=al.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		//List li=Collections.synchronizedList(al);
		
		/*List li=Collections.unmodifiableList(al);
		li.add(90);*/
		
		/*for(Object o:al) {
			System.out.println(o);
		}*/
		
		/*for(int i=0;i<al.size();i++) {
			System.out.println(al.get(i));
		}*/
		
		/*System.out.println(al);
		
		al.remove(1);
		System.out.println(al);
		al.add(1, 99);
		System.out.println(al);
		
		System.out.println(al.get(5));
		System.out.println(al.size());*/
	}

}
