package com.xworkz;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDelete {
	public static void main(String[] args) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/university","root","root");
			Statement st=con.createStatement();
			String sql="delete from collegeData where college_id=5";
			int rs=st.executeUpdate(sql);
			if(rs==1) {
				System.out.println("record deleted successfully");
			}else {
				System.out.println("record not deleted");
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
