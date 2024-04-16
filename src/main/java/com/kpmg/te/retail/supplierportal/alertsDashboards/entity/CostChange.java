package com.kpmg.te.retail.supplierportal.alertsDashboards.entity;

public class CostChange {
	
	private long itid;
	private String itemId;
	private String status;
    private String creationDateTime;
	
	public long getItid() {
		return itid;
	}
	public void setItid(long itid) {
		this.itid = itid;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
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
		return "CostChange [itid=" + itid + ", itemId=" + itemId + ", status=" + status + ", creationDateTime="
				+ creationDateTime + "]";
	}
	
	
	
}
