package com.kpmg.te.retail.supplierportal.alertsDashboards.entity;



public class PurchaseOrders {
	private long pid;
	private String poNumber;
	private String status;
	private String creationDateTime;


	public String getPoNumber() {
		return poNumber;
	}

	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreationDateTime() {
		return creationDateTime;
	}

	public void setCreationDateTime(String creationDateTime) {
		this.creationDateTime = creationDateTime;
	}

	@Override
	public String toString() {
		return "PurchaseOrders [pid=" + pid + ", poNumber=" + poNumber + ", status=" + status + ", creationDateTime="
				+ creationDateTime + "]";
	}

}
