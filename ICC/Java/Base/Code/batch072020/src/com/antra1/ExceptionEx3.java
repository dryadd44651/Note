package com.antra1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;

public class ExceptionEx3 {
	public static void main(String[] args) throws FileNotFoundException  {
	
		FileInputStream fis=new FileInputStream("abc.txt");
		ArithmeticException ae=new ArithmeticException();
		//throw new EmployeeNotFoundExeption("no employee available");
		//throw new StudentNotfoundException("no student available");
		/*try {
			throw new Exception();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		System.out.println("in main method");
		
	/*	try {
			System.out.println("in try block");
			System.out.println(1/0);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("in finally block");
		}*/
		
		/*try {
			
			int i[]=new int[1];
			i[0]=10;
			i[1]=67;
			FileInputStream fis=new FileInputStream("abc.txt");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(ArrayIndexOutOfBoundsException ae) {
			ae.printStackTrace();
		} catch(Exception e) {
			
		}finally {
			System.out.println("in finally block");
		}*/
		
		//ObjectInputStream obji=new ObjectInputStream(fis);
	}

}
