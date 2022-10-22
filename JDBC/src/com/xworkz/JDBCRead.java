package com.xworkz;

import java.sql.*;

public class JDBCRead {
	public static void main(String[] args) throws SQLException {
		try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/university","root","root");Statement st=con.createStatement()){
			String read="select * from collegeData";
			ResultSet rs=st.executeQuery(read);
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
			}
		}
	}
}
