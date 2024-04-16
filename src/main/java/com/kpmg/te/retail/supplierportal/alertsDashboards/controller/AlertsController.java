package com.kpmg.te.retail.supplierportal.alertsDashboards.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kpmg.te.retail.supplierportal.alertsDashboards.dao.AlertsDao;
import com.kpmg.te.retail.supplierportal.alertsDashboards.entity.AlertEntity;
import com.kpmg.te.retail.supplierportal.alertsDashboards.modelsdao.ASNMaster;
import com.kpmg.te.retail.supplierportal.alertsDashboards.modelsdao.CustomerOrderMaster;
import com.kpmg.te.retail.supplierportal.alertsDashboards.modelsdao.CustomerReturnsMaster;
import com.kpmg.te.retail.supplierportal.alertsDashboards.modelsdao.InvoiceMaster;
import com.kpmg.te.retail.supplierportal.alertsDashboards.modelsdao.ItemMaster;
import com.kpmg.te.retail.supplierportal.alertsDashboards.modelsdao.PriceMaster;
import com.kpmg.te.retail.supplierportal.alertsDashboards.modelsdao.PurchaseOrderMaster;
import com.kpmg.te.retail.supplierportal.alertsDashboards.modelsdao.RetailerReturnsMaster;

@Component
public class AlertsController {

	@Autowired
	AlertsDao alertsDao;

	public ArrayList<AlertEntity> getAlertsList(String moduleName) throws ClassNotFoundException, SQLException {
		return alertsDao.getAlertsList(moduleName);
	}

	public ASNMaster getASNDetails(String asnID) throws ClassNotFoundException, SQLException {
		return alertsDao.getAsnDetailsData(asnID);
	}

	public InvoiceMaster getInvoiceDetails(String invoiceID) throws ClassNotFoundException, SQLException {
		return alertsDao.getInvoiceDetailsData(invoiceID);
	}

	public PurchaseOrderMaster getPODetails(String poId) throws ClassNotFoundException, SQLException {
		return alertsDao.getPODetailsData(poId);
	}

	public CustomerOrderMaster getCustomerOrderDetails(String customerOrderID)
			throws ClassNotFoundException, SQLException {
		return alertsDao.getCODetailsData(customerOrderID);
	}

	public CustomerReturnsMaster getCustomerReturnDetails(String crId) throws ClassNotFoundException, SQLException {
		return alertsDao.getCustomerReturnsDetailsData(crId);
	}

	public RetailerReturnsMaster getRetailerReturnsDetails(String rrId) throws ClassNotFoundException, SQLException {
		return alertsDao.getRetailererReturnsDetailsData(rrId);
	}

	public ArrayList<ItemMaster> getItemListingDetails(String[] ilId) throws ClassNotFoundException, SQLException {
		return alertsDao.getItemListingDetailsData(ilId);
	}

	public ArrayList<PriceMaster> getCostChangeDetails(String[] ccId) throws ClassNotFoundException, SQLException {
		return alertsDao.getCostChangeDetailsData(ccId);
	}

}
