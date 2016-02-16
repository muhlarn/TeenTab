package bifrost.teen.dto;

import java.sql.Date;

public class Request {
	private int requestID;
	private String categoryAccountNo = null;
	private double amount = 0;
	private String status = null;
	private Date requestDate  = null;
	private Date approvedDate = null;
	private String declineReason = null;
	private String requestReason = null;
	
	/*
	 *   
	 *   pk_request_id integer NOT NULL,
  		fk_category_acc_no integer NOT NULL,
  		amount character varying(255) NOT NULL,
  		status character varying(50) NOT NULL,
  		datetime character varying(50) NOT NULL,
  		player_role character varying(255) NOT NULL,
  		decision_reason character varying(255) NOT NULL,
  		decline_reason character varying(255) NOT NULL,

	 */

	public double getAmount() {
		return amount;
	}
	public int getRequestID() {
		return requestID;
	}
	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}
	public String getCategoryAccountNo() {
		return categoryAccountNo;
	}
	public void setCategoryAccountNo(String categoryAccountNo) {
		this.categoryAccountNo = categoryAccountNo;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	public String getDeclineReason() {
		return declineReason;
	}
	public void setDeclineReason(String declineReason) {
		this.declineReason = declineReason;
	}
	public String getRequestReason() {
		return requestReason;
	}
	public void setRequestReason(String requestReason) {
		this.requestReason = requestReason;
	}
	public Date getApprovedDate() {
		return approvedDate;
	}
	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}
	@Override
	public String toString() {
		return "Request [requestID=" + requestID + ", categoryAccountNo="
				+ categoryAccountNo + ", amount=" + amount + ", status="
				+ status + ", requestDate=" + requestDate + ", approvedDate="
				+ approvedDate + ", declineReason=" + declineReason
				+ ", requestReason=" + requestReason + "]";
	}

}
