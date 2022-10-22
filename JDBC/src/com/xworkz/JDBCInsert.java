package com.xworkz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCInsert {
	public static void main(String[] args) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/university","root","root");
			Statement st=con.createStatement();
			String sql="insert into collegeData values(3,'SSSIT','ssit@1',35,'pune')";
			int rs=st.executeUpdate(sql);
			if(rs==1) {
				System.out.println("Record inserted succeff fully");
			}else {
				System.out.println("not inserted");
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}