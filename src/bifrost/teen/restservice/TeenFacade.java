package bifrost.teen.restservice;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import bifrost.teen.dao.AccountsDaoImpl;
import bifrost.teen.dao.CategoryDaoImpl;
import bifrost.teen.dao.TransactionsDaoImpl;
import bifrost.teen.dto.Account;
import bifrost.teen.dto.Category;
import bifrost.teen.dto.Transactions;
import bifrost.teen.exception.DaoException;


@Path("/teentab")
@Singleton
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class TeenFacade {

    @GET
    @Path("/accounts")
	public Account getAccounts() {

		AccountsDaoImpl service = new AccountsDaoImpl();
		Account account = new Account();
		try {
			account = service.getAccount();
		} catch (DaoException e) {
			e.printStackTrace();
		}

		return account;

	}

	public void createCategory(Category category) {

		try {
			CategoryDaoImpl cat = new CategoryDaoImpl();
			cat.addNewCategory(category);

		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

	public void requestFunds() {

	}

	public List<Transactions> getTransactions() {

		TransactionsDaoImpl trans = new TransactionsDaoImpl();
		List<Transactions> transList = new ArrayList<Transactions>();
		
		try {
			transList =  trans.getTransactions();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		return transList;
	}

    @GET
    @Path("/categories")
	public List<Category> getCategories() {

		List<Category> catList = new ArrayList<Category>();
		CategoryDaoImpl cat = new CategoryDaoImpl();
		try {
			catList =  cat.getCategories();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		return catList;

	}

    @POST
    @Path("/categories/catagory")
	public void addCategory(Category category) throws DaoException {

		try {
			CategoryDaoImpl cat = new CategoryDaoImpl();
			cat.addNewCategory(category);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

}
