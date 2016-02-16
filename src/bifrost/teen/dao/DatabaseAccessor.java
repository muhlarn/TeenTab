package bifrost.teen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import bifrost.teen.datasource.DBConnection;

/**
 * 
 * @author F3557790
 *
 */
public class DatabaseAccessor {

	private static final String DS_NAME = "jdbc/sales";

	
	protected Connection connect() throws SQLException {

		Connection conn = null;

		try {
			
			Context envCtx = new InitialContext();

			DataSource ds = (DataSource) envCtx.lookup(DS_NAME);
			
			conn = ds.getConnection();
			
			

		} catch (NamingException e) {
			System.out.println("connection = " + conn);
			if (null == conn) {
				conn = DBConnection.getConnection();
			}
			//e.printStackTrace();
		}

		return conn;
	}

	protected void disconnect(Connection connection, PreparedStatement query) {
		DatabaseUtil.close(connection, query);
	}

}
