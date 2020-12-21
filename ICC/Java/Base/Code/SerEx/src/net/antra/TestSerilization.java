package net.antra;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestSerilization {
	
	public static void main(String[] args) throws IOException {
		
		
		Employee emp=new Employee();

		emp.id=102;
		emp.name="manas kumar";
		emp.sal=300;
		
		
		
		try {
			
			/*FileOutputStream fos=new FileOutputStream("abc.txt");
			ObjectOutputStream obj=new ObjectOutputStream(fos);
			
			 obj.writeObject(emp);*/
			
			
			
			FileInputStream fis=new FileInputStream("abc.txt");
			ObjectInputStream obji=new ObjectInputStream(fis);
			Employee e=(Employee)obji.readObject();
			System.out.println(e.id);
			System.out.println(e.name);
			System.out.println(e.sal);
			
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//fos=null;
			//obj=null;
		}
		
		
	}
	
}
