package com.antra2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCEx2 {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		/*Scanner sc=new Scanner(System.in);
		int id=sc.nextInt();
		String name=sc.next();
		int sal=sc.nextInt();*/
		//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "oracle");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/system", "root", "manas");
		try {
		con.setAutoCommit(false);
		PreparedStatement stmt=con.prepareStatement("insert into emp values(?,?,?)");
		stmt.setInt(1, 2);
		stmt.setString(2, "kumar");
		stmt.setInt(3, 863);
		stmt.execute();
		
		stmt.setInt(1, 3);
		stmt.setString(2, "Tom");
		stmt.setInt(3, 865);
		stmt.execute();
		
		stmt.setInt(1, 2);
		stmt.setString(2, "david");
		stmt.setInt(3, 890);
		stmt.execute();
		con.commit();
		}catch(Exception e){
			e.printStackTrace();
		con.rollback();	
		}finally {
			con.close();
		}
		
		
	}

}
