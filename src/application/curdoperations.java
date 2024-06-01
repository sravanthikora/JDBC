package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class curdoperations {
	
	private static final String Driver = "com.mysql.cj.jdbc.Driver";
	
	private static final String username = "root";
	private static final String password = "root";
	public static void main(String[] args) {
		int ch;
		do {
			System.out.println("Curd Operations");
			System.out.println("******");
			Display();
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your Choice :");
			ch=Integer.parseInt(sc.next());   //ch=sc.nextInt();
			switch(ch) {
			case 1 :
				createdatabase();
				break;
			case 2 :
				deletedatabase();
				break;
			case 3 :
				createtable();
				break;
			case 4 :
				droptable();
				break;
			case 5 :
				insertdata();
				break;
			case 6 :
				updatetable();
				break;
			case 7 :
				deletedata();
				break;
			case 8 :
				getall();
				break;
			case 9 :
				getbyid();
				break;
			case 10 :
				System.exit(0);
				break;
			default:
				System.out.println("invalid");
				break;
			}
		} while (ch>0);
	}






	private static void createdatabase() {
		try {
			final String url ="jdbc:mysql://localhost:3306/";
			Scanner sc = new Scanner(System.in);
			//load the driver
			//my sql driver name com.mysql.cj.jdbc.Driver : cj is used when sql version is greater than 8
			Class.forName(Driver);
			
			Connection conn = DriverManager.getConnection(url,username,password);
			System.out.println("Enter the databse name");
			String name="Create database " +sc.next();
			
			PreparedStatement pmst = conn.prepareStatement(name);  //connection btwn the connection and statement
			
			int i = pmst.executeUpdate();
			
			if (i>0) {
				System.out.println("Databse Created");
			}
			else {
				System.out.println("Database not created");
			}
			conn.close();
			pmst.close();

			
			} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

	private static void deletedatabase() {
		try {
			final String url ="jdbc:mysql://localhost:3306/";
			Scanner sc = new Scanner(System.in);
			
			Class.forName(Driver);
			
			Connection conn = DriverManager.getConnection(url,username,password);
			System.out.println("Enter the databse name :");
			String name="drop database " +sc.next();
			
			PreparedStatement pmst = conn.prepareStatement(name); 
			
			int i = pmst.executeUpdate();
			
			if (i==0) {
				System.out.println("Databse deleted");
			}
			else {
				System.out.println("Database not deleted");
			}
			conn.close();
			pmst.close();

			
			} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static void createtable() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("enter the database name");
			String url ="jdbc:mysql://localhost:3306/"+sc.next();
			
			Class.forName(Driver);
			
			Connection conn = DriverManager.getConnection(url,username,password);
			System.out.println("Enter the table name :");
			String name="Create table " +sc.next() +"(id int, name varchar(20),email varchar(20))";
			
			PreparedStatement pmst = conn.prepareStatement(name); 
			
			int i = pmst.executeUpdate();
			
			if (i==0) {
				System.out.println("table Created");
			}
			else {
				System.out.println("table not created");
			}
			conn.close();
			pmst.close();

			
			} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	private static void droptable() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("enter the database name :");
			String url ="jdbc:mysql://localhost:3306/"+sc.next();
			
			Class.forName(Driver);
			
			Connection conn = DriverManager.getConnection(url,username,password);
			System.out.println("Enter the table name");
			String name="drop table " +sc.next() ;
			
			PreparedStatement pmst = conn.prepareStatement(name); 
			
			int i = pmst.executeUpdate();
			
			if (i==0) {
				System.out.println("table deleted");
			}
			else {
				System.out.println("table not deleted");
			}
			conn.close();
			pmst.close();

			
			} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	private static void insertdata() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("enter the database name :");
			String url ="jdbc:mysql://localhost:3306/"+sc.next();
			
			Class.forName(Driver);
			
			Connection conn = DriverManager.getConnection(url,username,password);
			System.out.println("Enter the table name");
			String name="insert into " +sc.next()+"(id,name,email) values(?,?,?)" ;
			
			PreparedStatement pmst = conn.prepareStatement(name); 
			System.out.println("enter Id");
			pmst.setInt(1, sc.nextInt());
			System.out.println("enter name");
			pmst.setString(2, sc.next());
			System.out.println("enter email");
			pmst.setString(3, sc.next());
			
			int i = pmst.executeUpdate();
			
			if (i>0) {
				System.out.println("data inserted");
			}
			else {
				System.out.println("data not inserted");
			}
			conn.close();
			pmst.close();

			
			} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	private static void updatetable() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("enter the database name :");
			String url ="jdbc:mysql://localhost:3306/"+sc.next();
			
			Class.forName(Driver);
			
			Connection conn = DriverManager.getConnection(url,username,password);
			System.out.println("Enter the table name");
			String name="update " +sc.next()+" set name = ? , email = ? where id = ?" ;
			
			PreparedStatement pmst = conn.prepareStatement(name); 
			System.out.println("Enter name : ");
			pmst.setString(1, sc.next());
			System.out.println("Enter email : ");
			pmst.setString(2, sc.next());
			System.out.println("Enter Id : ");
			pmst.setInt(3, sc.nextInt());
			int i = pmst.executeUpdate();
			
			if (i>0) {
				System.out.println("data updated");
			}
			else {
				System.out.println("data not updated");
			}
			conn.close();
			pmst.close();

			
			} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	private static void deletedata() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("enter the database name :");
			String url ="jdbc:mysql://localhost:3306/"+sc.next();
			
			Class.forName(Driver);
			
			Connection conn = DriverManager.getConnection(url,username,password);
			System.out.println("Enter the table name");
			String name="delete from " +sc.next()+" where id =?" ;
			
			PreparedStatement pmst = conn.prepareStatement(name); 
			System.out.println("enter Id");
			pmst.setInt(1, sc.nextInt());

			
			int i = pmst.executeUpdate();
			
			if (i>0) {
				System.out.println("data deleted");
			}
			else {
				System.out.println("data not deleted");
			}
			conn.close();
			pmst.close();

			
			} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void getall() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("enter the database name :");
			String url ="jdbc:mysql://localhost:3306/"+sc.next();
			
			Class.forName(Driver);
			
			Connection conn = DriverManager.getConnection(url,username,password);
			System.out.println("Enter the table name :");
			String name="select * from " +sc.next() ;
			
			PreparedStatement pmst = conn.prepareStatement(name); 
			ResultSet rs =pmst.executeQuery();
			while(rs.next()) {
				System.out.println("********");
				System.out.println("ID : "+rs.getInt("id"));
				System.out.println("Name : "+rs.getString("name"));
				System.out.println("Email : "+rs.getString("email"));
				
			}
			
			conn.close();
			pmst.close();

			
			} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	private static void getbyid() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("enter the database name :");
			String url ="jdbc:mysql://localhost:3306/"+sc.next();
			
			Class.forName(Driver);
			
			Connection conn = DriverManager.getConnection(url,username,password);
			System.out.println("Enter the table name :");
			String name="select * from " +sc.next()+" where id =?";
			
			PreparedStatement pmst = conn.prepareStatement(name); 
			System.out.println("Enter ID : ");
			pmst.setInt(1, sc.nextInt());
			ResultSet rs =pmst.executeQuery();
			while(rs.next()) {
				System.out.println("********");
				System.out.println("ID : "+rs.getInt("id"));
				System.out.println("Name : "+rs.getString("name"));
				System.out.println("Email : "+rs.getString("email"));
				
			}
			
			conn.close();
			pmst.close();

			
			} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	private static void Display() {		
		System.out.println("\t1.Create database");
		System.out.println("\t2.Delete data");
		System.out.println("\t3.create table");
		System.out.println("\t4.Drop Table");
		System.out.println("\t5.Insert data");
		System.out.println("\t6.Update data");
		System.out.println("\t7.Delete data");
		System.out.println("\t8.Get all");
		System.out.println("\t9.Get by ID");
		System.out.println("\t10. EXIT");
	}

}
