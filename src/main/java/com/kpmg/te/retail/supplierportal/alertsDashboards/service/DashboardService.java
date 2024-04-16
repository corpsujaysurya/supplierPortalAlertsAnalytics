package com.kpmg.te.retail.supplierportal.alertsDashboards.service;

import java.sql.SQLException;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.kpmg.te.retail.supplierportal.alertsDashboards.controller.DashboardController;
import com.kpmg.te.retail.supplierportal.alertsDashboards.dao.DashboardsDao;
import com.kpmg.te.retail.supplierportal.alertsDashboards.entity.Dashboards;
import com.kpmg.te.retail.supplierportal.alertsDashboards.manager.DashboardManager;

@RestController
@RequestMapping("/api/dashboards/service")
public class DashboardService {

	@Autowired
	DashboardManager dashboardManager;

	@Autowired
	DashboardsDao dashboardDao;

	@Autowired
	DashboardController dashboardController;

	private static final Logger logger = Logger.getLogger(DashboardService.class.getName());

	@RequestMapping(path = "/getAllDashboardData", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Dashboards getDashboardData() throws ClassNotFoundException, SQLException {
		Dashboards dbrd = new Dashboards();
		dbrd = dashboardController.getAllDashboardData();
		logger.info(dbrd.toString());
		return dbrd;
	}

}
