package bifrost.teen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bifrost.teen.dto.Account;
import bifrost.teen.exception.DaoException;
;

public class AccountsDaoImpl extends DatabaseAccessor{
	private static final String GET_ACCOUNT = "select * from fnb_account";

	public Account getAccount() throws DaoException {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		Account account = null;
		try {
			connection = connect();
			statement = connection.prepareStatement(GET_ACCOUNT);
			//statement.setString(1, accountNo);
			resultSet = statement.executeQuery();        
			account = getAccount(resultSet);	//getting back the DTO
			System.out.println(account);

		}	catch (SQLException sqle) {
			throw new DaoException("Could not find record for account no = " , sqle );
		}	finally {
			if (statement != null) {
				try {
					statement.close();
				}
				catch (Exception ex) {
				}
			}
			disconnect(connection, statement);
		}
		return account;
	}
	private Account getAccount(ResultSet resulSet) {
		Account account = null;
		try {
			while (resulSet.next()) {
				account = new Account();
				account.setAccountNo(resulSet.getString("pk_fnb_acc_no"));
				account.setBalance(Double.valueOf(resulSet.getString("acc_balance")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}

}
