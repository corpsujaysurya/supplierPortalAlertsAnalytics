package com.kpmg.te.retail.supplierportal.alertsDashboards.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kpmg.te.retail.supplierportal.alertsDashboards.entity.Dashboards;
import com.kpmg.te.retail.supplierportal.alertsDashboards.manager.DashboardManager;

@Component
public class DashboardController {
	
	@Autowired
	DashboardManager dashboardManager;
	
	private static final Logger logger = Logger.getLogger(DashboardManager.class.getName());
	
				public Dashboards getAllDashboardData() throws ClassNotFoundException, SQLException {
					Dashboards ds = new Dashboards();
					ArrayList<String> alerts = dashboardManager.getLatestAlertsData();
					ArrayList<String> asn = dashboardManager.getLatestASNData();
					ArrayList<String> inv = dashboardManager.getLatestInvoicesData();
					ArrayList<String> il = dashboardManager.getLatestItemListingData();
					ArrayList<String> cc = dashboardManager.getLatestCostChangeData();
					ArrayList<String> cr = dashboardManager.getLatestsCustomerReturnsData();
					ArrayList<String> rr = dashboardManager.getLatestRetailerReturnsData();
					ArrayList<String> po = dashboardManager.getLatestPOData();
					ArrayList<String> co = dashboardManager.getLatesCOData();
					ds.setAlertsList(alerts);
					ds.setAsnList(asn);
					ds.setInvList(inv);
					ds.setIlList(il);
					ds.setCcList(cc);
					ds.setCrList(cr);
					ds.setPoList(po);
					ds.setCoList(co);
					ds.setRrList(rr);
					logger.info("The DashboardList is: " + ds.toString());
					return ds;
				}
						
				
}
