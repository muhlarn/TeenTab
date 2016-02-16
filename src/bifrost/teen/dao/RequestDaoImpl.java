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
import bifrost.teen.exception.DaoException;

public class RequestDaoImpl extends DatabaseAccessor {
	private static final String REQUEST_BY_ACCOUNT = "SELECT * FROM request req, categories cat WHERE cat.fk_fnb_acc_no = ? AND req.fk_category_acc_no = cat.pk_category_acc_no";
	private static final String REQUEST_BY_CATEGORY = "SELECT * FROM request WHERE fk_category_acc_no = ?";
	private static final String INSERT_REQUEST = "INSERT INTO categories (fk_category_acc_no,amount,status,datetime,player_role,decision_reason) VALUES (?,?,?,?,?,?)";
	private static final String UPDATE_REQUEST = "UPDATE request SET  status = ?, approved_date = ?, decline_reason = ? WHERE  pk_request_id = ?";
	
	/*
	 *  pk_request_id integer NOT NULL,
  		fk_category_acc_no integer NOT NULL,
  		amount character varying(255) NOT NULL,
  		status character varying(50) NOT NULL,
  		datetime character varying(50) NOT NULL,
  		player_role character varying(255) NOT NULL,
  		decision_reason character varying(255) NOT NULL,
  		decline_reason character varying(255) NOT NULL,

	 */
	public List<Request> getRequestByAccount(String accountNo) throws DaoException {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		List<Request> requestList = new ArrayList<Request>();
		try {
			connection = connect();
			statement = connection.prepareStatement(REQUEST_BY_ACCOUNT);
			statement.setString(1, accountNo);
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
			throw new DaoException("Could not find record for account no = " + accountNo, sqle );
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
	
	public List getRequestByCategory(String categoryAccountNo) throws DaoException {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		List<Request> requestList = new ArrayList<Request>();
		try {
			connection = connect();
			statement = connection.prepareStatement(REQUEST_BY_CATEGORY);
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
			throw new DaoException("Could not find record for category account no = " + categoryAccountNo, sqle );
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

	
	public void addNewRequest(Request request) throws DaoException {
		PreparedStatement statement = null;
		Connection connection = null;
		
		try {
			connection = connect();
			statement = connection.prepareStatement(INSERT_REQUEST);
			//statement.setString(1, request.getCategoryAccountNo());
			statement.setString(1, request.getCategoryAccountNo());
			statement.setString(2, String.valueOf(request.getAmount()));
			statement.setString(3, request.getStatus());
			statement.setDate(4, request.getRequestDate());
			statement.setString(5, request.getRequestReason());
			statement.setString(6, request.getDeclineReason());			
			
			int numRowsAffected = statement.executeUpdate();
			System.out.println("Num rows affected: "+numRowsAffected);
		}	catch (SQLException sqle) {
			throw new DaoException("Could not find record for account no = " + request, sqle );
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
	
	public void updateRequest(Request request) throws DaoException {
		PreparedStatement statement = null;
		Connection connection = null;
		
		try {
			connection = connect();
			statement = connection.prepareStatement(UPDATE_REQUEST);
			statement.setString(1, request.getStatus());
			statement.setDate(2, request.getApprovedDate());
			statement.setString(3, request.getDeclineReason());
			statement.setInt(4, request.getRequestID());	
			
			int numRowsAffected = statement.executeUpdate();
			System.out.println("Num rows affected: "+numRowsAffected);
		}	catch (SQLException sqle) {
			throw new DaoException("Could not find record for account no = " + request, sqle );
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
		