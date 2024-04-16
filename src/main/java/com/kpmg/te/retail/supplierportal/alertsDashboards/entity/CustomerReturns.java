package com.kpmg.te.retail.supplierportal.alertsDashboards.entity;

public class CustomerReturns {

	private long rid;
	private String returnId;
	private String status;
	private String creationDateTime;

	public long getRid() {
		return rid;
	}

	public void setRid(long rid) {
		this.rid = rid;
	}

	public String getReturnId() {
		return returnId;
	}

	public void setReturnId(String returnId) {
		this.returnId = returnId;
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
		return "CustomerReturns [rid=" + rid + ", returnId=" + returnId + ", status=" + status + ", creationDateTime="
				+ creationDateTime + "]";
	}

}
