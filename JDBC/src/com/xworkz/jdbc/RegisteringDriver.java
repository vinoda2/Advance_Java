package com.xworkz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RegisteringDriver {

	public static void main(String[] args) throws SQLException {
		try {
			System.out.println("loading the driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println(Class.forName("com.mysql.cj.jdbc.Driver"));
			System.out.println("create a connection");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crop" ,"root", "root");
			System.out.println("create query");
			String query="select * from cropdetails";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			System.out.println("table created");

			while(rs.next()) {
				//System.out.println("institute");
				System.out.println("institute"+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
			}
			rs.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
