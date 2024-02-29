package com.kpmg.te.retail.supplierportal.alertsAnalytics.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;

import com.kpmg.te.retail.supplierportal.alertsAnalytics.constants.AlertsAnalyticsConstants;
import com.kpmg.te.retail.supplierportal.alertsAnalytics.entity.AlertEntity;

@Component
public class AlertsDao {
	
	private static final Logger logger = Logger.getLogger(AlertsDao.class.getName());
	public Connection getConnectioDetails() throws ClassNotFoundException, SQLException {
		String myDriver = AlertsAnalyticsConstants.myDriver;
		String myUrl = AlertsAnalyticsConstants.myUrl;
		Class.forName(myDriver);
		Connection conn = DriverManager.getConnection(myUrl, AlertsAnalyticsConstants.mySQL_ID, AlertsAnalyticsConstants.mySQL_pass);
		return conn;
	}

	public void closeConnection(Connection conn) throws SQLException {
		conn.close();
	}

	public ArrayList<AlertEntity> getAlertsList(String moduleName) throws SQLException, ClassNotFoundException {
		ArrayList<AlertEntity> alertListEntity = new ArrayList<AlertEntity>();
		AlertEntity ae = null;
		Connection conn = getConnectioDetails();
		String query = "SELECT  * from SUPPLIER_PORTAL_ALERTS WHERE MODULE_NAME = '" + moduleName + '\'';
		logger.info(query);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			ae = new AlertEntity();
			ae.setModuleName(moduleName);
			ae.setAlertId(rs.getString("alert_id"));
			ae.setAlertDate(rs.getString("alert_date"));
			ae.setAlertMsg(rs.getString("alert_msg"));
			alertListEntity.add(ae);
		}
		logger.info("[C]AlertsDao::[M]getAlertsList -> The Alerts List for module  is: " + alertListEntity.toString());
		return alertListEntity;
	}

}
