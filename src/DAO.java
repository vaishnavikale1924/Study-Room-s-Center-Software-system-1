import java.sql.Connection;
import java.sql.DriverManager;


public class DAO {
	
		String username = "root";
		String password = "tiger";
		String DB_URL = "jdbc:mysql://localhost:3306/studyroomdb";
		public Connection getConnection(){
			Connection conn = null;
			try{
				//Step 2: Register JDBC driver
				Class.forName("com.mysql.jdbc.Driver");
				
				//Step 3 : Open a connection 
				System.out.println("Connected to Database Successfully!!!");	
				
				conn = DriverManager.getConnection(DB_URL,username,password);
			}
			catch(Exception e){
				System.out.println("Unable to connect Database");
			}
			return conn;
		}
}
