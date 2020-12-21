package net.antra;

import java.io.Serializable;

import org.omg.IOP.TransactionService;

public class Employee implements Serializable{//marker interface implements Serializable

	public int id;
	public transient String name;		//transient
	public int sal;
	
}
