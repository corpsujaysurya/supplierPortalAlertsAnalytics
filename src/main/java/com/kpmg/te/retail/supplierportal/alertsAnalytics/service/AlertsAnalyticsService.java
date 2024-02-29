package com.kpmg.te.retail.supplierportal.alertsAnalytics.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kpmg.te.retail.supplierportal.alertsAnalytics.controller.AlertsController;
import com.kpmg.te.retail.supplierportal.alertsAnalytics.entity.AlertEntity;

@RestController
@RequestMapping("/api/alerts-analytics/service/")
public class AlertsAnalyticsService {
	
	@Autowired
	AlertsController alertsController;
	
	private static final Logger logger = Logger.getLogger(AlertsAnalyticsService.class.getName());
	
	
	
	@RequestMapping(path = "/alerts/getAlertDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<AlertEntity> getAlertsForModule(@RequestParam String moduleName) throws ClassNotFoundException, SQLException {
		ArrayList<AlertEntity> alertEntityList = new ArrayList<AlertEntity>();
		alertEntityList = alertsController.getAlertsList(moduleName);
		logger.info("The Alert List to display is: " + alertEntityList.toString());
		return alertEntityList;
	}

}
