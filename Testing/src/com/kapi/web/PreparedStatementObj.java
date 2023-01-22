package com.kapi.web;

//Below code is just for reference purpose, this is not the right way to code
//As per the coding standard of Java....
import java.sql.*;
import java.util.Scanner;
class PreparedStatementObj {
	static final String query="SELECT NAME,ACC_NO FROM ARUN_BANK WHERE NAME=?";
	//static final String query="SELECT *FROM ARUN_BANK";
	public static void main(String [] args) throws SQLException{
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","arunkc9900");
		PreparedStatement ps=con.prepareStatement(query);
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Account holder name: ");
		String name=sc.nextLine().trim().toUpperCase();
		ps.setString(1,name);
		ResultSet rs=ps.executeQuery();
		boolean flag=false;
		while(rs.next()) {
			flag=true;
			System.out.println(rs.getString(1)+"\t"+rs.getString(2));//TESTING PUSH
		}
		if(!flag) {
			System.out.println("No Data Found with the given name");
		}
		con.close();
	}
}
