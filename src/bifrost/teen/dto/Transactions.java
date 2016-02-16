package bifrost.teen.dto;

import java.sql.Date;

public class Transactions {
	
	private String categoryAccountNo = null;
	private double amount = 0;
	private Date transactionDate = null;
	private String debitCredit = null;
	private String Description = null;
	private String categoryName = null;
	

	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryAccountNo() {
		return categoryAccountNo;
	}
	public void setCategoryAccountNo(String categoryAccountNo) {
		this.categoryAccountNo = categoryAccountNo;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getDebitCredit() {
		return debitCredit;
	}
	public void setDebitCredit(String debitCredit) {
		this.debitCredit = debitCredit;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	@Override
	public String toString() {
		return "Transactions [categoryName=" + categoryName + ", amount="
				+ amount + ", transactionDate=" + transactionDate
				+ ", debitCredit=" + debitCredit + ", Description="
				+ Description + "]";
	}
}
