package com.antra2;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class JDBCEx1 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		/*Driver d=new oracle.jdbc.driver.OracleDriver();
		System.out.println(d);
		DriverManager.registerDriver(d);*/
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		//new oracle.jdbc.driver.OracleDriver();
		
		/*Scanner sc=new Scanner(System.in);
		int id=sc.nextInt();
		String name=sc.next();
		int sal=sc.nextInt();*/
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "oracle");
		//Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/system", "root", "manas");
		Statement stmt=con.createStatement();
		//stmt.executeUpdate("insert into emp values("+id+","+"'"+name+"'"+","+sal+")");
		ResultSet rs=stmt.executeQuery("select * from emp");
		ResultSetMetaData rms=rs.getMetaData();
		for(int i=1;i<=rms.getColumnCount();i++) {
			System.out.println(rms.getColumnName(i));
			System.out.println(rms.getColumnType(i));
		}
		
		
		/*while(rs.next()) {
			System.out.println(rs.getInt("Id"));
			System.out.println(rs.getString("Name"));
			System.out.println(rs.getInt("sal"));
		}*/
		
		con.close();
		
		}

}
