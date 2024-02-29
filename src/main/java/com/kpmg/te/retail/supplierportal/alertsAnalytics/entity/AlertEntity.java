package com.kpmg.te.retail.supplierportal.alertsAnalytics.entity;

public class AlertEntity {

	private String moduleName;
	private String alertId;
	private String alertMsg;
	private String alertDate;

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getAlertId() {
		return alertId;
	}

	public void setAlertId(String alertId) {
		this.alertId = alertId;
	}

	public String getAlertMsg() {
		return alertMsg;
	}

	public void setAlertMsg(String alertMsg) {
		this.alertMsg = alertMsg;
	}

	public String getAlertDate() {
		return alertDate;
	}

	public void setAlertDate(String alertDate) {
		this.alertDate = alertDate;
	}

	@Override
	public String toString() {
		return "AlertEntity [moduleName=" + moduleName + ", alertId=" + alertId + ", alertMsg=" + alertMsg
				+ ", alertDate=" + alertDate + "]";
	}

}
