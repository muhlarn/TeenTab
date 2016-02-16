//package bifrost.teen.services;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//import bifrost.teen.datasource.AccountsDaoImpl;
//import bifrost.teen.dto.Account;
//import bifrost.teen.dto.Category;
//
//public class AccountService {
//	
//
//	public Account getAccount() {
//
//		Connection c = AccountsDaoImpl.getConnection();
//		Account account = new Account();
//
//		Statement stmt = null;
//		ResultSet rs;
//		try {
//			stmt = c.createStatement();
//			rs = stmt.executeQuery("SELECT * FROM fnb_account;");
//			while (rs.next()) {
//
//				String account_no = rs.getBigDecimal("pk_fnb_acc_no") + "";
//				double acc_bal = rs.getDouble("acc_balance");
//
//				account.setAccountNo(account_no);
//				account.setBalance(acc_bal);
//
//				System.out.println(account);
//			}
//			rs.close();
//			stmt.close();
//			c.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return account;
//
//	}
//	
//
//}
