package users;
	
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
	
	
	public class getbyid {
		private static final String Driver = "com.mysql.cj.jdbc.Driver";
		
		private static final String username = "root";
		private static final String password = "root";
		public static void main(String[] args) {
			
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

	}





