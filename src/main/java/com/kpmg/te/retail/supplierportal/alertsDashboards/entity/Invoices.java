package com.kpmg.te.retail.supplierportal.alertsDashboards.entity;


public class Invoices {

	private long inid;
	private String invoiceNo;
	private String status;
	private String creationDateTime;

	public long getInid() {
		return inid;
	}

	public void setInid(long inid) {
		this.inid = inid;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
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
		return "Invoices [inid=" + inid + ", invoiceNo=" + invoiceNo + ", status=" + status + ", creationDateTime="
				+ creationDateTime + "]";
	}

}
