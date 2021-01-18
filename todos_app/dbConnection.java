package todos_app;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbConnection {
	
	private final String url = "jdbc:postgresql://localhost/postgres";
    private final String user = "postgres";
    private final String password = "prithvi";
    
	Connection con = null;
	public Connection getConnection() {
		
		try {
			con=DriverManager.getConnection(url, user, password);
			System.out.println("Connection Established");
		}
		catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		return con;
	}
	    
}