package com.kpmg.te.retail.supplierportal.alertsAnalytics.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kpmg.te.retail.supplierportal.alertsAnalytics.dao.AlertsDao;
import com.kpmg.te.retail.supplierportal.alertsAnalytics.entity.AlertEntity;

@Component
public class AlertsController {
	
	@Autowired
	AlertsDao alertsDao;
	
	private static final Logger logger = Logger.getLogger(AlertsController.class.getName());

	public ArrayList<AlertEntity> getAlertsList(String moduleName) throws ClassNotFoundException, SQLException {
		return alertsDao.getAlertsList(moduleName);
	}

}
