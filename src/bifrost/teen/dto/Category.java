package bifrost.teen.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Category {
	
	private double categoryAccountNo;
	private BigDecimal fnbAccountNo;
	private String name = null;
	private double balance;
	
	
	public double getCategoryAccountNo() {
		return categoryAccountNo;
	}
	public void setCategoryAccountNo(double categoryAccountNo) {
		this.categoryAccountNo = categoryAccountNo;
	}
	
	public BigDecimal getFnbAccountNo() {
		return fnbAccountNo;
	}
	public void setFnbAccountNo(BigDecimal fnbAccountNo) {
		this.fnbAccountNo = fnbAccountNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "Category [categoryAccountNo=" + categoryAccountNo
				+ ", fnbAccountNo=" + fnbAccountNo + ", name=" + name + ", balance="
				+ balance + "]";
	}
	
}
