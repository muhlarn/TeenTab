package bifrost.teen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bifrost.teen.dto.Account;
import bifrost.teen.dto.Category;
import bifrost.teen.dto.Request;
import bifrost.teen.dto.Transactions;
import bifrost.teen.exception.DaoException;

public class TransactionsDaoImpl extends DatabaseAccessor {
	private static final String RETRIEVE_TRANSACTION_BY_CATEGORY  = "SELECT * FROM transactions WHERE fk_category_acc_no = ? AND datetime between(?,?)";
	private static final String RETRIEVE_TRANSACTIONS  = "SELECT * FROM transactions ";
	private static final String INSERT_TRANSACTION = "INSERT INTO transactions (fk_category_acc_no,amount,datetime,debit_credit,description) VALUES (?,?,?,?,?)";
	
	/*
	 *    pk_transaction_id integer NOT NULL,
  		fk_category_acc_no integer NOT NULL,
  		amount character varying(255) NOT NULL,
  		datetime character varying(255) NOT NULL,
  		debit_credit character varying(255) NOT NULL,
  		description character varying(255) NOT NULL,
	 */
	
	public List<Transactions> getTransactions() throws DaoException {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		List<Transactions> transactionList = new ArrayList<Transactions>();
		try {
			connection = connect();
			statement = connection.prepareStatement(RETRIEVE_TRANSACTIONS);
			resultSet = statement.executeQuery();        
			while (resultSet.next()) {
				Transactions transactions = new Transactions();
				transactions.setAmount(resultSet.getDouble("amount"));
				transactions.setCategoryAccountNo(resultSet.getString("fk_category_acc_no"));
				//transactions.setCategoryName(resultSet.getString("amount"));
				transactions.setDescription(resultSet.getString("description"));
				transactions.setTransactionDate(resultSet.getDate("datetime"));
				transactionList.add(transactions);
				System.out.println(transactions);
				
			}	//getting back the DTO

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
		return transactionList;
	}
	
	public List getTransactionByCategory(String categoryAccountNo) throws DaoException {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		List<Request> requestList = new ArrayList<Request>();
		try {
			connection = connect();
			statement = connection.prepareStatement(RETRIEVE_TRANSACTION_BY_CATEGORY);
			statement.setString(1, categoryAccountNo);
			resultSet = statement.executeQuery();        
			while (resultSet.next()) {
				Request request = new Request();
				request.setRequestID(Integer.parseInt(resultSet.getString("pk_request_id")));
				request.setCategoryAccountNo(resultSet.getString("fk_category_acc_no"));
				request.setAmount(Double.valueOf(resultSet.getString("amount")));
				request.setStatus(resultSet.getString("status"));
				request.setRequestDate(resultSet.getDate("datetime"));
				request.setRequestReason(resultSet.getString("decision_reason"));
				request.setDeclineReason(resultSet.getString("decline_reason"));
				requestList.add(request);
			}	//getting back the DTO

		}	catch (SQLException sqle) {
			throw new DaoException("Could not find record for account no = " + categoryAccountNo, sqle );
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
		return requestList;
	}
	
	
	public void addNewRequest(Transactions transactions) throws DaoException {
		PreparedStatement statement = null;
		Connection connection = null;
		
		try {
			connection = connect();
			statement = connection.prepareStatement(INSERT_TRANSACTION);
			//statement.setString(1, transactions.get);
			statement.setString(1, transactions.getCategoryAccountNo());
			statement.setString(2, String.valueOf(transactions.getAmount()));
			statement.setDate(3, transactions.getTransactionDate());
			statement.setString(4, transactions.getDebitCredit());
			statement.setString(5, transactions.getDescription());
			
			
			int numRowsAffected = statement.executeUpdate();
			System.out.println("Num rows affected: "+numRowsAffected);
		}	catch (SQLException sqle) {
			throw new DaoException("Could not find record for account no = " + transactions, sqle );
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
	}
}	
		