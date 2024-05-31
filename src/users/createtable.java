package users;
	
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.util.Scanner;
	
	
	public class createtable {
		private static final String Driver = "com.mysql.cj.jdbc.Driver";
		
		private static final String username = "root";
		private static final String password = "root";
		public static void main(String[] args) {
			
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

	}



