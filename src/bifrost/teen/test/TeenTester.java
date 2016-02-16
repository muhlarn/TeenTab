package bifrost.teen.test;

import java.math.BigDecimal;

import bifrost.teen.dao.TeenFacade;
import bifrost.teen.dto.Category;
import bifrost.teen.exception.DaoException;

public class TeenTester {

	public static void main(String[] args) {

		System.out.println("\n-------------- getting accounts");
		new TeenFacade().getAccounts();

		System.out.println("\n-------------- getting category list");
		new TeenFacade().getCategories();

		System.out.println("\n-------------- add category");
		// new TeenFacade().addCategory(getCategory());

		System.out.println("\n-------------- get transaction");
		new TeenFacade().getTransactions();

	}

	public static Category getCategory() {

		Category cat = new Category();
		cat.setBalance(444);
		cat.setCategoryAccountNo(8766);
		cat.setName("airtime");
		cat.setFnbAccountNo(new BigDecimal("62003344545"));

		return cat;
	}

}
