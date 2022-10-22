package com.xworkz;

import java.sql.*;

public class JdbcDemo {
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/university","root","root");
		Statement st=con.createStatement();
		String sql="select * from collegeData";
		ResultSet rs=st.executeQuery(sql);
		while(rs.next())
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
			con.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
}
