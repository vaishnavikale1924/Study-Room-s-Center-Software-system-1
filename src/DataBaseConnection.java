import java.sql.Connection;
import java.sql.DriverManager;


public class DataBaseConnection {
	
	public static void main(String[] args) throws Exception{
		String username = "root";
		String password = "tiger";
		String DB_URL = "jdbc:mysql://localhost:3306/studyroomdb";
		
		try{
			//Step 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection(DB_URL,username,password);
			
			//Step 3 : Open a connection 
			System.out.println("Connected to Database Successfully!!!");	
		}
		catch(Exception e){
			System.out.println("Unable to connect Database");
		}

	}

}
