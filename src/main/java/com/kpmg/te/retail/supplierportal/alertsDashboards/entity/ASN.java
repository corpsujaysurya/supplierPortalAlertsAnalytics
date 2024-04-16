package com.kpmg.te.retail.supplierportal.alertsDashboards.entity;

public class ASN {

	private long asid;
	private String asnNumber;
	private String status;
    private String creationDateTime;
	
	public long getAsid() {
		return asid;
	}
	public void setAsid(long asid) {
		this.asid = asid;
	}
	public String getAsnNumber() {
		return asnNumber;
	}
	public void setAsnNumber(String asnNumber) {
		this.asnNumber = asnNumber;
	}
	public String getStatus() {
		return status;
	}
	public String getCreationDateTime() {
		return creationDateTime;
	}
	public void setCreationDateTime(String creationDateTime) {
		this.creationDateTime = creationDateTime;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ASN [asid=" + asid + ", asnNumber=" + asnNumber + ", status=" + status + ", creationDateTime="
				+ creationDateTime + "]";
	}
	
	
	
	
}
