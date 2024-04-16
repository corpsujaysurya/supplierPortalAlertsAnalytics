package com.kpmg.te.retail.supplierportal.alertsDashboards.manager;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kpmg.te.retail.supplierportal.alertsDashboards.dao.DashboardsDao;


@Component
public class DashboardManager {

	@Autowired
	private DashboardsDao dashboardDao;

	//private static final Logger logger = Logger.getLogger(DashboardManager.class.getName());

	public ArrayList<String> getLatestAlertsData() throws ClassNotFoundException, SQLException {
		return dashboardDao.getLatestAlertsData();
	}

	public ArrayList<String> getLatestASNData() throws ClassNotFoundException, SQLException {
		return dashboardDao.getLatestASNData();
	}
	
	public ArrayList<String> getLatestInvoicesData() throws ClassNotFoundException, SQLException {
		return dashboardDao.getLatestInvData();
	}

	public ArrayList<String> getLatestRetailerReturnsData() throws ClassNotFoundException, SQLException {
		return dashboardDao.getLatesRRData();
	}

	public ArrayList<String> getLatestsCustomerReturnsData() throws ClassNotFoundException, SQLException {
		return dashboardDao.getLatestCRData();
	}
	
	public ArrayList<String> getLatestPOData() throws ClassNotFoundException, SQLException {
		return dashboardDao.getLatestPOData();
	}
	
	public ArrayList<String> getLatesCOData() throws ClassNotFoundException, SQLException {
		return dashboardDao.getLatestCOData();
	}


	public ArrayList<String> getLatestCostChangeData() throws ClassNotFoundException, SQLException {
		return dashboardDao.getLatestCCData();
	}
	
	public ArrayList<String> getLatestItemListingData() throws ClassNotFoundException, SQLException {
		return dashboardDao.getLatestILData();
	}



}
