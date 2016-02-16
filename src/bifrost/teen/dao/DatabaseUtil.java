package bifrost.teen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseUtil {
	public static void close(PreparedStatement query) {
		DatabaseUtil.close( null, query, null );
	}

	public static void close(Connection connection, PreparedStatement query) {
		DatabaseUtil.close( connection, query, null );
	}

	public static void close(Connection connection, PreparedStatement query, ResultSet rs) {
		if( rs != null ) {
			try { rs.close(); } catch(Exception e) {}
		}
		rs = null;
		if( query != null ) {
			try { query.close(); } catch(Exception e) {}
		}
		query = null;
		if( connection != null ) {
			try { connection.close(); } catch(Exception e) {}
		}
		connection = null;
	}
}
