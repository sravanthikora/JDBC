package users;
	
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.util.Scanner;
	
	
	public class update {
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

	}





