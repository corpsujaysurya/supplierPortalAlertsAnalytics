package com.kpmg.te.retail.supplierportal.alertsDashboards.entity;

public class Alerts {
	private String alertId;
	private String moduleName;
	private String alertMessage;
	private String alertDate;

	public String getAlertId() {
		return alertId;
	}

	public void setAlertId(String alertId) {
		this.alertId = alertId;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getAlertMessage() {
		return alertMessage;
	}

	public void setAlertMessage(String alertMessage) {
		this.alertMessage = alertMessage;
	}

	public String getAlertDate() {
		return alertDate;
	}

	public void setAlertDate(String alertDate) {
		this.alertDate = alertDate;
	}

	@Override
	public String toString() {
		return "Alerts [alertId=" + alertId + ", moduleName=" + moduleName + ", alertMessage=" + alertMessage
				+ ", alertDate=" + alertDate + "]";
	}

}
