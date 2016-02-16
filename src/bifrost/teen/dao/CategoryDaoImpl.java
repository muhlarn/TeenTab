package bifrost.teen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bifrost.teen.dto.Account;
import bifrost.teen.dto.Category;
import bifrost.teen.exception.DaoException;

public class CategoryDaoImpl extends DatabaseAccessor {
	private static final String CATEGORY_BY_ACCOUNT = "SELECT * FROM categories ";// WHERE fk_fnb_acc_no = ?";
	private static final String INSERT_CATEGORY = "INSERT INTO categories (pk_category_acc_no,fk_fnb_acc_no,acc_name,acc_balance) VALUES (?,?,?,?)";
	/*
	 *  pk_category_acc_no integer NOT NULL,
  		fk_fnb_acc_no integer NOT NULL,
  		acc_name character varying(255) NOT NULL,
  		acc_balance integer NOT NULL,

	 */
	public List<Category> getCategories() throws DaoException {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		List<Category> categoryList = new ArrayList<Category>();
		try {
			connection = connect();
			statement = connection.prepareStatement(CATEGORY_BY_ACCOUNT);
			//statement.setString(1, accountNo);
			resultSet = statement.executeQuery();        
			while (resultSet.next()) {
				Category category = new Category();
				category.setCategoryAccountNo(resultSet.getDouble("pk_category_acc_no"));
				category.setName(resultSet.getString("acc_name"));
				category.setBalance(Double.valueOf(resultSet.getString("acc_balance")));
				categoryList.add(category);
				System.out.println(category);
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
		return categoryList;
	}
	
	public void addNewCategory(Category category) throws DaoException {
		PreparedStatement statement = null;
		Connection connection = null;
		
		try {
			connection = connect();
			statement = connection.prepareStatement(INSERT_CATEGORY);
			statement.setDouble(1, category.getCategoryAccountNo());
			statement.setBigDecimal(2, category.getFnbAccountNo());
			statement.setString(3, category.getName());
			statement.setDouble(4, category.getBalance());
			int numRowsAffected = statement.executeUpdate();
			System.out.println("Num rows affected: "+numRowsAffected);
		}	catch (SQLException sqle) {
			throw new DaoException("Could not find record for account no = " + category, sqle );
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
		