//package bifrost.teen.services;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//import bifrost.teen.datasource.AccountsDaoImpl;
//import bifrost.teen.datasource.DBConnection;
//import bifrost.teen.dto.Account;
//import bifrost.teen.dto.Category;
//
//public class CategoryService {
//	
//
//	public List<Category> getCategory(String accountNo) {
//
//		Connection c = DBConnection.getConnection();		
//		List<Category> categoryList = new ArrayList<Category>();
//
//		Statement stmt = null;
//		ResultSet resultSet;
//		try {
//			
//			stmt = c.createStatement();
//			 resultSet = stmt.executeQuery("SELECT * FROM categories where fk_fnb_acc_no = " + accountNo + ";");
//			while (resultSet.next()) {
//				
//				Category category = new Category();
//				category.setCategoryAccountNo(resultSet.getString("pk_category_acc_no"));
//				category.setName(resultSet.getString("acc_name"));
//				category.setBalance(Double.valueOf(resultSet.getString("acc_balance")));
//				categoryList.add(category);
//
//				System.out.println(category);
//			}
//			resultSet.close();
//			stmt.close();
//			c.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return categoryList;
//
//	}
//	
//
//}
