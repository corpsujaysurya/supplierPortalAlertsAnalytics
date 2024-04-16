package com.kpmg.te.retail.supplierportal.alertsDashboards.entity;

import java.util.ArrayList;
import java.util.List;

public class Dashboards {

	private ArrayList<String> alertsList;
	private ArrayList<String> asnList;
	private ArrayList<String> invList;
	private ArrayList<String> ccList;
	private ArrayList<String> ilList;
	private ArrayList<String> poList;
	private ArrayList<String> coList;
	private ArrayList<String> rrList;
	private ArrayList<String> crList;

	public ArrayList<String> getAlertsList() {
		return alertsList;
	}

	public void setAlertsList(ArrayList<String> alertsList) {
		this.alertsList = alertsList;
	}

	public ArrayList<String> getAsnList() {
		return asnList;
	}

	public void setAsnList(ArrayList<String> asnList) {
		this.asnList = asnList;
	}

	public ArrayList<String> getInvList() {
		return invList;
	}

	public void setInvList(ArrayList<String> invList) {
		this.invList = invList;
	}

	public ArrayList<String> getCcList() {
		return ccList;
	}

	public void setCcList(ArrayList<String> ccList) {
		this.ccList = ccList;
	}

	public ArrayList<String> getIlList() {
		return ilList;
	}

	public void setIlList(ArrayList<String> ilList) {
		this.ilList = ilList;
	}

	public ArrayList<String> getPoList() {
		return poList;
	}

	public void setPoList(ArrayList<String> poList) {
		this.poList = poList;
	}

	public ArrayList<String> getCoList() {
		return coList;
	}

	public void setCoList(ArrayList<String> coList) {
		this.coList = coList;
	}

	public List<String> getRrList() {
		return rrList;
	}

	public void setRrList(ArrayList<String> rrList) {
		this.rrList = rrList;
	}

	public List<String> getCrList() {
		return crList;
	}

	public void setCrList(ArrayList<String> crList) {
		this.crList = crList;
	}

	@Override
	public String toString() {
		return "Dashboards [alertsList=" + alertsList + ", asnList=" + asnList + ", invList=" + invList + ", ccList="
				+ ccList + ", ilList=" + ilList + ", poList=" + poList + ", coList=" + coList + ", rrList=" + rrList
				+ ", crList=" + crList + "]";
	}

}
