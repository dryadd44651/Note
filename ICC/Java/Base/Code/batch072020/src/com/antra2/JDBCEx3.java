package com.antra2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCEx3 {

	public static void main(String[] args) throws SQLException {
		// Connection
		// con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
		// "system", "oracle");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/system", "root", "manas");
		PreparedStatement stmt = con.prepareStatement("insert into emp values(?,?,?)");
		stmt.setInt(1, 2);
		stmt.setString(2, "kumar");
		stmt.setInt(3, 863);
		stmt.addBatch();

		stmt.setInt(1, 3);
		stmt.setString(2, "Tom");
		stmt.setInt(3, 865);
		stmt.addBatch();

		stmt.setInt(1, 4);
		stmt.setString(2, "david");
		stmt.setInt(3, 890);
		stmt.addBatch();
		
		stmt.executeBatch();
		con.close();
	}
}
