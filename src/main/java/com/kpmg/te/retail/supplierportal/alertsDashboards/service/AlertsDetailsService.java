package com.kpmg.te.retail.supplierportal.alertsDashboards.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kpmg.te.retail.supplierportal.alertsDashboards.controller.AlertsController;
import com.kpmg.te.retail.supplierportal.alertsDashboards.modelsdao.ASNMaster;
import com.kpmg.te.retail.supplierportal.alertsDashboards.modelsdao.CustomerOrderMaster;
import com.kpmg.te.retail.supplierportal.alertsDashboards.modelsdao.CustomerReturnsMaster;
import com.kpmg.te.retail.supplierportal.alertsDashboards.modelsdao.InvoiceMaster;
import com.kpmg.te.retail.supplierportal.alertsDashboards.modelsdao.ItemMaster;
import com.kpmg.te.retail.supplierportal.alertsDashboards.modelsdao.PriceMaster;
import com.kpmg.te.retail.supplierportal.alertsDashboards.modelsdao.PurchaseOrderMaster;
import com.kpmg.te.retail.supplierportal.alertsDashboards.modelsdao.RetailerReturnsMaster;

@RestController
@RequestMapping("/api/alerts/details-service/")
public class AlertsDetailsService {

	@Autowired
	AlertsController alertsController;

	private static final Logger logger = Logger.getLogger(AlertsService.class.getName());
	
	@RequestMapping(path = "/getASNDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ASNMaster getASNDetails(@RequestParam String asnID) throws ClassNotFoundException, SQLException {
		ASNMaster asn = new ASNMaster();
		asn = alertsController.getASNDetails(asnID);
		logger.info("The ASN Details to display is: " + asn.toString());
		return asn;
	}

	@RequestMapping(path = "/getInvoiceDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public InvoiceMaster getInvoiceDetails(@RequestParam String invoiceID) throws ClassNotFoundException, SQLException {
		InvoiceMaster invoices = new InvoiceMaster();
		invoices = alertsController.getInvoiceDetails(invoiceID);
		logger.info("The Invoice Details to display is: " + invoices.toString());
		return invoices;
	}

	@RequestMapping(path = "/getPurchaseOrders", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public PurchaseOrderMaster getPurchaseOrders(@RequestParam String poId)
			throws ClassNotFoundException, SQLException {
		PurchaseOrderMaster po = new PurchaseOrderMaster();
		po = alertsController.getPODetails(poId);
		logger.info("The Purchase Order Details to display is: " + po.toString());
		return po;
	}

	@RequestMapping(path = "/getCustomerOrders", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerOrderMaster getCustomerOrders(@RequestParam String customerOrderID)
			throws ClassNotFoundException, SQLException {
		CustomerOrderMaster co = new CustomerOrderMaster();
		co = alertsController.getCustomerOrderDetails(customerOrderID);
		logger.info("The Customer Orders Details to display is: " + co.toString());
		return co;
	}

	@RequestMapping(path = "/getCustomerReturns", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerReturnsMaster getCustomerReturns(@RequestParam String crId)
			throws ClassNotFoundException, SQLException {
		CustomerReturnsMaster cr = new CustomerReturnsMaster();
		cr = alertsController.getCustomerReturnDetails(crId);
		logger.info("The Customer Return Details to display is: " + cr.toString());
		return cr;
	}

	@RequestMapping(path = "/getRetailerReturns", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public RetailerReturnsMaster getRetailerReturns(@RequestParam String rrId)
			throws ClassNotFoundException, SQLException {
		RetailerReturnsMaster rr = new RetailerReturnsMaster();
		rr = alertsController.getRetailerReturnsDetails(rrId);
		logger.info("The Retailer Return Details to display is: " + rr.toString());
		return rr;
	}

	@RequestMapping(path = "/getItemListingDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<ItemMaster> getItemListingDetails(@RequestParam String[] ilId)
			throws ClassNotFoundException, SQLException {
		ArrayList<ItemMaster> ilList = new ArrayList<ItemMaster>();
		ilList = alertsController.getItemListingDetails(ilId);
		logger.info("The Item Listing Details to display is: " + ilList.toString());
		return ilList;
	}

	@RequestMapping(path = "/getPriceChange", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<PriceMaster> getPriceChange(@RequestParam String[] ccId)
			throws ClassNotFoundException, SQLException {
		ArrayList<PriceMaster> ccList = new ArrayList<PriceMaster>();
		ccList = alertsController.getCostChangeDetails(ccId);
		logger.info("The Cost Change Details to display is: " + ccList.toString());
		return ccList;
	}

}
