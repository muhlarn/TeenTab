package bifrost.teen.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	static Connection connection = null; 
	
	public static Connection getConnection() {
		
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(
			   "jdbc:postgresql://localhost:5432/codefest2","postgres", "sa");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
		//connection.close();

	}
	
	public static void closeConnection() {
		
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
