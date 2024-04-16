package com.kpmg.te.retail.supplierportal.alertsDashboards.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;

import com.kpmg.te.retail.supplierportal.alertsDashboards.constants.DashboardConstants;



@Component
public class DashboardsDao {
	
	private static final Logger logger = Logger.getLogger(DashboardsDao.class.getName());
	
	public Connection getConnectioDetails() throws ClassNotFoundException, SQLException {
		String myDriver = DashboardConstants.myDriver;
		String myUrl = DashboardConstants.myUrl;
		Class.forName(myDriver);
		Connection conn = DriverManager.getConnection(myUrl, DashboardConstants.mySQL_ID, DashboardConstants.mySQL_pass);
		return conn;
	}

	public void closeConnection(Connection conn) throws SQLException {
		conn.close();
	}

	public ArrayList<String> getLatestAlertsData() throws ClassNotFoundException, SQLException {
		ArrayList<String> alertsDashboardMsgList = new ArrayList<String>();
		Connection conn = getConnectioDetails();
		String query = "SELECT  ALERT_ID,ALERT_MSG from SUPPLIER_PORTAL_ALERTS ORDER BY ALERT_DATE DESC LIMIT 8";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			String dashboardMsg = new String();
			dashboardMsg = rs.getString("ALERT_ID").concat("||").concat((rs.getString("ALERT_MSG")));
			alertsDashboardMsgList.add(dashboardMsg);
		}
		logger.info("The Alerts Dashboard list is: " + alertsDashboardMsgList.toString());
		return alertsDashboardMsgList;
	}

	public ArrayList<String> getLatestASNData() throws SQLException, ClassNotFoundException {
		ArrayList<String> asnDashboardMsgList = new ArrayList<String>();
		Connection conn = getConnectioDetails();
		String query = "SELECT  ALERT_ID,ALERT_MSG from SUPPLIER_PORTAL_ALERTS WHERE MODULE_NAME = 'ASN' ORDER BY ALERT_DATE DESC LIMIT 8";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			String asndashboardMsg = new String();
			asndashboardMsg = rs.getString("ALERT_ID").concat("||").concat((rs.getString("ALERT_MSG")));
			asnDashboardMsgList.add(asndashboardMsg);
		}
		logger.info("The ASN Dashboard list is: " + asnDashboardMsgList.toString());
		return asnDashboardMsgList;
	}
	
	public ArrayList<String> getLatestInvData() throws SQLException, ClassNotFoundException {
		ArrayList<String> invoiceDashboardMsgList = new ArrayList<String>();
		Connection conn = getConnectioDetails();
		String query = "SELECT  ALERT_ID,ALERT_MSG from SUPPLIER_PORTAL_ALERTS WHERE MODULE_NAME = 'INVOICES' ORDER BY ALERT_DATE DESC LIMIT 8";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			String invoicedashboardMsg = new String();
			invoicedashboardMsg = rs.getString("ALERT_ID").concat("||").concat((rs.getString("ALERT_MSG")));
			invoiceDashboardMsgList.add(invoicedashboardMsg);
		}
		logger.info("The Invoice Dashboard list is: " + invoiceDashboardMsgList.toString());
		return invoiceDashboardMsgList;
	}



	public ArrayList<String> getLatestPOData() throws SQLException, ClassNotFoundException {
		ArrayList<String> poDashboardMsgList = new ArrayList<String>();
		Connection conn = getConnectioDetails();
		String query = "SELECT  ALERT_ID,ALERT_MSG from SUPPLIER_PORTAL_ALERTS WHERE MODULE_NAME = 'PO' ORDER BY ALERT_DATE DESC LIMIT 8";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			String poDashboardMsg = new String();
			poDashboardMsg = rs.getString("ALERT_ID").concat("||").concat((rs.getString("ALERT_MSG")));
			poDashboardMsgList.add(poDashboardMsg);
		}
		logger.info("The Purchase Order Dashboard list is: " + poDashboardMsgList.toString());
		return poDashboardMsgList;
	}
	
	public ArrayList<String> getLatestCOData() throws SQLException, ClassNotFoundException {
		ArrayList<String> coDashboardMsgList = new ArrayList<String>();
		Connection conn = getConnectioDetails();
		String query = "SELECT  ALERT_ID,ALERT_MSG from SUPPLIER_PORTAL_ALERTS WHERE MODULE_NAME = 'CO' ORDER BY ALERT_DATE DESC LIMIT 8";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			String coDashboardMsg = new String();
			coDashboardMsg = rs.getString("ALERT_ID").concat("||").concat((rs.getString("ALERT_MSG")));
			coDashboardMsgList.add(coDashboardMsg);
		}
		logger.info("The Customer Order Dashboard list is: " + coDashboardMsgList.toString());
		return coDashboardMsgList;
	}



	public ArrayList<String> getLatestCCData() throws SQLException, ClassNotFoundException {
		ArrayList<String> ccDashboardMsgList = new ArrayList<String>();
		Connection conn = getConnectioDetails();
		String query = "SELECT  ALERT_ID,ALERT_MSG from SUPPLIER_PORTAL_ALERTS WHERE MODULE_NAME = 'COST CHANGE' ORDER BY ALERT_DATE DESC LIMIT 8";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			String ccDashboardMsg = new String();
			ccDashboardMsg = rs.getString("ALERT_ID").concat("||").concat((rs.getString("ALERT_MSG")));
			ccDashboardMsgList.add(ccDashboardMsg);
		}
		logger.info("The Cost Change Dashboard list is: " + ccDashboardMsgList.toString());
		return ccDashboardMsgList;
	}
	
	public ArrayList<String> getLatestILData() throws SQLException, ClassNotFoundException {
		ArrayList<String> ilDashboardMsgList = new ArrayList<String>();
		Connection conn = getConnectioDetails();
		String query = "SELECT  ALERT_ID,ALERT_MSG from SUPPLIER_PORTAL_ALERTS WHERE MODULE_NAME = 'ITEM LISTING' ORDER BY ALERT_DATE DESC LIMIT 8";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			String ilDashboardMsg = new String();
			ilDashboardMsg = rs.getString("ALERT_ID").concat("||").concat((rs.getString("ALERT_MSG")));
			ilDashboardMsgList.add(ilDashboardMsg);
		}
		logger.info("The Cost Change Dashboard list is: " + ilDashboardMsgList.toString());
		return ilDashboardMsgList;
	}
	
	public ArrayList<String> getLatesRRData() throws SQLException, ClassNotFoundException {
		ArrayList<String> coDashboardMsgList = new ArrayList<String>();
		Connection conn = getConnectioDetails();
		String query = "SELECT  ALERT_ID,ALERT_MSG from SUPPLIER_PORTAL_ALERTS WHERE MODULE_NAME = 'CO' ORDER BY ALERT_DATE DESC LIMIT 8";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			String coDashboardMsg = new String();
			coDashboardMsg = rs.getString("ALERT_ID").concat("||").concat((rs.getString("ALERT_MSG")));
			coDashboardMsgList.add(coDashboardMsg);
		}
		logger.info("The Customer Order Dashboard list is: " + coDashboardMsgList.toString());
		return coDashboardMsgList;
	}

	public ArrayList<String> getLatestCRData() throws SQLException, ClassNotFoundException {
		ArrayList<String> crDashboardMsgList = new ArrayList<String>();
		Connection conn = getConnectioDetails();
		String query = "SELECT  ALERT_ID,ALERT_MSG from SUPPLIER_PORTAL_ALERTS WHERE MODULE_NAME = 'CUST RETURNS' ORDER BY ALERT_DATE DESC LIMIT 8";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			String crDashboardMsg = new String();
			crDashboardMsg = rs.getString("ALERT_ID").concat("||").concat((rs.getString("ALERT_MSG")));
			crDashboardMsgList.add(crDashboardMsg);
		}
		logger.info("The Customer Returns Dashboard list is: " + crDashboardMsgList.toString());
		return crDashboardMsgList;
	}

}
