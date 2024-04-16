package com.kpmg.te.retail.supplierportal.alertsDashboards.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kpmg.te.retail.supplierportal.alertsDashboards.constants.AlertsAnalyticsConstants;
import com.kpmg.te.retail.supplierportal.alertsDashboards.entity.AlertEntity;
import com.kpmg.te.retail.supplierportal.alertsDashboards.modelsdao.ASNMaster;
import com.kpmg.te.retail.supplierportal.alertsDashboards.modelsdao.CustomerOrderMaster;
import com.kpmg.te.retail.supplierportal.alertsDashboards.modelsdao.CustomerReturnsMaster;
import com.kpmg.te.retail.supplierportal.alertsDashboards.modelsdao.InvoiceMaster;
import com.kpmg.te.retail.supplierportal.alertsDashboards.modelsdao.ItemMaster;
import com.kpmg.te.retail.supplierportal.alertsDashboards.modelsdao.PriceMaster;
import com.kpmg.te.retail.supplierportal.alertsDashboards.modelsdao.PurchaseOrderMaster;
import com.kpmg.te.retail.supplierportal.alertsDashboards.modelsdao.RetailerReturnsMaster;
import com.kpmg.te.retail.supplierportal.alertsDashboards.utils.ListingPricingUtils;

@Component
public class AlertsDao {

	@Autowired
	ListingPricingUtils listingPricingUtils;

	private static final Logger logger = Logger.getLogger(AlertsDao.class.getName());

	public Connection getConnectioDetails() throws ClassNotFoundException, SQLException {
		String myDriver = AlertsAnalyticsConstants.myDriver;
		String myUrl = AlertsAnalyticsConstants.myUrl;
		Class.forName(myDriver);
		Connection conn = DriverManager.getConnection(myUrl, AlertsAnalyticsConstants.mySQL_ID,
				AlertsAnalyticsConstants.mySQL_pass);
		return conn;
	}

	public void closeConnection(Connection conn) throws SQLException {
		conn.close();
	}

	public ArrayList<AlertEntity> getAlertsList(String moduleName) throws SQLException, ClassNotFoundException {
		ArrayList<AlertEntity> alertListEntity = new ArrayList<AlertEntity>();
		AlertEntity ae = null;
		Connection conn = getConnectioDetails();
		String query = "SELECT  * from SUPPLIER_PORTAL.SUPPLIER_PORTAL_ALERTS WHERE MODULE_NAME = '" + moduleName + '\'' + "ORDER BY ALERT_DATE DESC LIMIT 20";
		logger.info(query);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			ae = new AlertEntity();
			ae.setModuleName(moduleName);
			ae.setAlertId(rs.getString("ALERT_ID"));
			ae.setAlertDate(rs.getString("ALERT_DATE"));
			ae.setAlertMsg(rs.getString("ALERT_MSG"));
			alertListEntity.add(ae);
		}
		logger.info("[C]AlertsDao::[M]getAlertsList -> The Alerts List for module  is: " + alertListEntity.toString());
		return alertListEntity;
	}

	public ASNMaster getAsnDetailsData(String asnID) throws ClassNotFoundException, SQLException {
		ASNMaster asnMasterObj = null;
		Connection conn = getConnectioDetails();
		String query = "SELECT  * from SUPPLIER_PORTAL.ASN_MASTER WHERE ASN_ID = '" + asnID + "'";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			asnMasterObj = new ASNMaster();
			asnMasterObj.setUniqueId(rs.getString("UNIQUE_ID"));
			asnMasterObj.setAsnId(rs.getString("ASN_ID"));
			asnMasterObj.setAsnStatus(rs.getString("ASN_STATUS"));
			asnMasterObj.setAsnCreationDate(rs.getString("ASN_CREATION_DATE"));
			asnMasterObj.setShippingDate(rs.getString("SHIPPING_DATE"));
			asnMasterObj.setEstimatedDelDate(rs.getString("ETA"));
			asnMasterObj.setContainerCount(rs.getString("CONTAINER_COUNT"));
			asnMasterObj.setContainerDetails(rs.getString("CONTAINER_DETAILS"));
			asnMasterObj.setContainerId(rs.getString("CONTAINER_ID"));
			asnMasterObj.setShippedQty(rs.getString("SHIPPED_QTY"));
			asnMasterObj.setPoNum(rs.getString("PO_DETAILS"));
			asnMasterObj.setConsignmentCost(rs.getString("CONSIGNMENT_COST"));
			asnMasterObj.setDeliveryNoteNo(rs.getString("DC_NO"));
			asnMasterObj.setEwayNo(rs.getString("EWAY_NO"));
			asnMasterObj.setAwbNo(rs.getString("AWB_NO"));
			asnMasterObj.setDriverName(rs.getString("DRIVER_NAME"));
			asnMasterObj.setVehicleNo(rs.getString("VEHICLE_NO"));
			asnMasterObj.setModeOfTransport(rs.getString("TRANSPORT_MODE"));
			asnMasterObj.setTransportCompName(rs.getString("TRANSPORT_COMPANY_NAME"));
			asnMasterObj.setConsignmentWeight(rs.getString("GROSS_CONTANER_WEIGHT"));
			asnMasterObj.setDriverLicenseNo(rs.getString("DL_NO"));
			asnMasterObj.setPermitLevel(rs.getString("PERMIT_LEVEL"));
			asnMasterObj.setVehicleEngNo(rs.getString("ENGINE_NO"));
			asnMasterObj.setVehicleChassiesNo(rs.getString("CHASSIS_NO"));
			asnMasterObj.setShippingAddr(rs.getString("SUPPLIER_SITE"));
			asnMasterObj.setDelAddr(rs.getString("RETAILER_STORE"));
		}
		logger.info("[C]AlertsDao::[M]getAsnDetailsData -> The ASN Details are: " + asnMasterObj.toString());
		return asnMasterObj;
	}

	public InvoiceMaster getInvoiceDetailsData(String invoiceID) throws ClassNotFoundException, SQLException {
		InvoiceMaster inVoiceMasterObj = null;
		Connection conn = getConnectioDetails();
		String query = "SELECT  * from SUPPLIER_PORTAL.INVOICE_MASTER WHERE INVOICE_ID = '" + invoiceID + "'";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			inVoiceMasterObj = new InvoiceMaster();
			inVoiceMasterObj.setUniqueId(rs.getString("UNIQUE_ID"));
			inVoiceMasterObj.setInvoiceId(rs.getString("INVOICE_ID"));
			inVoiceMasterObj.setInvoiceDate(rs.getString("INVOICE_DATE"));
			inVoiceMasterObj.setInvoiceType(rs.getString("INVOICE_TYPE"));
			inVoiceMasterObj.setInvoiceStatus(rs.getString("INVOICE_STATUS"));
			inVoiceMasterObj.setCurrency(rs.getString("CURRENCY"));

			inVoiceMasterObj.setAttachments(rs.getString("ATTACHMENTS"));
			inVoiceMasterObj.setTotalItemQty(rs.getString("TOTAL_ITEM_QUANTIY"));
			inVoiceMasterObj.setTotalUniqueItems(rs.getString("TOTAL_UNIQUE_ITEMS"));
			inVoiceMasterObj.setDeliveryAddress(rs.getString("DELIVERY_ADDRESS"));
			inVoiceMasterObj.setSenderAddress(rs.getString("SENDER_ADDRESS"));

			inVoiceMasterObj.setInvoiceTotalAmount(rs.getString("INVOICE_TOTAL_AMOUNT"));
			inVoiceMasterObj.setInvoiceDueAmount(rs.getString("INVOICE_DUE_AMOUNT"));
			inVoiceMasterObj.setNettedAmt(rs.getString("NETTED_AMOUNT"));
			inVoiceMasterObj.setInvoicePaymentStatus(rs.getString("INVOICE_PAYMENT_STATUS"));
			inVoiceMasterObj.setInvoiceOnHoldFlag(rs.getString("INVOICE_ON_HOLD_FLAG"));
			inVoiceMasterObj.setInvoiceDueDate(rs.getString("INVOICE_DUE_DATE"));
			inVoiceMasterObj.setPoNumber(rs.getString("PO_NUMBER"));
			inVoiceMasterObj.setCreated_datetime(rs.getString("CREATED_DATETIME"));
			inVoiceMasterObj.setCustomerId(rs.getString("CUSTOMER_ID"));
			// inVoiceMasterObj.setItemDetails(rs.getString("ITEM_DETAILS")); //Contains PO
			// Data as JSON to be parsed by UI
			String invoicedItemsList = rs.getString("INVOICED_ITEM_DETAILS");
			inVoiceMasterObj.setInvoicedItems(invoicedItemsList);
		}
		logger.info("[C]AlertsDao::[M]getInvoiceDetailsData -> The Invoice details is: " + inVoiceMasterObj.toString());
		return inVoiceMasterObj;
	}

	public PurchaseOrderMaster getPODetailsData(String poId) throws ClassNotFoundException, SQLException {
		PurchaseOrderMaster poMasterObj = null;
		Connection conn = getConnectioDetails();
		String query = "SELECT  * from SUPPLIER_PORTAL.PURCHASE_ORDER_MASTER WHERE PO_NUMBER ='" + poId + "'";
		logger.info(query);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			poMasterObj = new PurchaseOrderMaster();
			poMasterObj.setUniqueId(rs.getString("UNIQUE_ID"));
			poMasterObj.setPoNumber(rs.getString("PO_NUMBER"));
			poMasterObj.setLocation(rs.getString("LOCATION"));
			poMasterObj.setCreationDate(rs.getString("CREATION_DATE"));
			poMasterObj.setTotalItemQty(rs.getLong("TOTAL_ITEM_QUANTIY"));
			poMasterObj.setTotalUniqItms(rs.getLong("TOTAL_UNIQUE_ITEMS"));
			poMasterObj.setShipByDate(rs.getString("SHIPBY_DATE"));
			poMasterObj.setEstDelDate(rs.getString("ESTIMATED_DELIVERY_DATE"));
			poMasterObj.setLeadTime(rs.getString("LEAD_TIME"));
			poMasterObj.setTotalCost(rs.getString("TOTAL_COST"));
			poMasterObj.setItemDetails(rs.getString("ITEM_DETAILS"));
			poMasterObj.setAsnDetails(rs.getString("ASN_DETAILS"));
		}
		logger.info("[C]AlertsDao::[M]getPODetailsData -> The Item details list is: " + poMasterObj.toString());
		return poMasterObj;
	}

	public CustomerOrderMaster getCODetailsData(String customerOrderID) throws ClassNotFoundException, SQLException {
		CustomerOrderMaster coMasterObj = null;
		Connection conn = getConnectioDetails();
		String query = "SELECT  * from SUPPLIER_PORTAL.CUSTOMER_ORDER_MASTER WHERE CO_NUMBER ='" + customerOrderID
				+ "'";
		logger.info(query);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			coMasterObj = new CustomerOrderMaster();
			coMasterObj.setCoNumber(rs.getString("CO_NUMBER"));
			coMasterObj.setCustomerMobNum(rs.getString("MOBILE_NUM"));
			coMasterObj.setOrderCreationDate(rs.getString("CREATION_DATE"));
			coMasterObj.setExpectedDelDate(rs.getString("EXP_DELIVERY_DATE"));
			coMasterObj.setOrderStatus(rs.getString("ORDER_STATUS"));
			coMasterObj.setGiftWrap(rs.getString("GIFT_WRAP"));
			coMasterObj.setGiftMessage(rs.getString("GIFT_MESSAGE"));
			coMasterObj.setCustomerName(rs.getString("CUSTOMER_NAME"));
			coMasterObj.setDeliveryType(rs.getString("DELIVERY_TYPE"));
			coMasterObj.setShippingAddress(rs.getString("SHIPPING_ADDRESS"));
			coMasterObj.setItemDetails(rs.getString("ITEM_DETAILS"));
		}
		logger.info("[C]AlertsDao::[M]getCODetailsData -> The Customer Order Details is: " + coMasterObj.toString());
		return coMasterObj;
	}

	public CustomerReturnsMaster getCustomerReturnsDetailsData(String crId)
			throws ClassNotFoundException, SQLException {
		CustomerReturnsMaster custRetMasterObj = null;
		Connection conn = getConnectioDetails();
		String query = "SELECT  * from SUPPLIER_PORTAL.CUSTOMER_RETURNS_MASTER WHERE RETURN_ID ='" + crId + "'";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			custRetMasterObj = new CustomerReturnsMaster();
			custRetMasterObj.setReturnId(rs.getString("return_id"));
			custRetMasterObj.setReturnDate(rs.getString("return_date"));
			custRetMasterObj.setReturnSite(rs.getString("return_Site"));
			custRetMasterObj.setCustomerName(rs.getString("CUSTOMER_NAME"));
			custRetMasterObj.setCustomerMobileNumber(rs.getString("CUSTOMER_MOBILE_NUMBER"));
			custRetMasterObj.setCustomerAddr(rs.getString("CUSTOMER_ADDRESS"));
			custRetMasterObj.setAwbNo(rs.getString("AWB_NO"));
			custRetMasterObj.seteWayBill("EWAY_BILL");
			custRetMasterObj.setTplPartner("TPL_PARTNER");

			custRetMasterObj.setOrderedDate(rs.getString("ordered_date"));
			custRetMasterObj.setReturnStatus("RETURN_STATUS");
			custRetMasterObj.setTotalUniqRetItems("TOTAL_UNIQUE_ITEMS");
			custRetMasterObj.setTotalReturnItems("TOTAL_ITEM_QUANTIY");
			custRetMasterObj.setTotalCostReturns("TOTAL_COST");
			custRetMasterObj.setReturnSite("RETURN_SITE");
			custRetMasterObj.setCustomerComments("CONCERN_MSG");

			custRetMasterObj.setProcessedStatusFlag(rs.getString("processed_status_flag"));
			custRetMasterObj.setConcernRaisedFlag(rs.getString("concern_raised_flag"));
			custRetMasterObj.setItemDetails(rs.getString("item_details"));
		}
		logger.info("[C]AlertsDao::[M]getCustomerReturnsDetailsData -> The Customer Returns Details are: "
				+ custRetMasterObj.toString());
		return custRetMasterObj;
	}

	public RetailerReturnsMaster getRetailererReturnsDetailsData(String rrId)
			throws ClassNotFoundException, SQLException {
		RetailerReturnsMaster retailerRetMasterObj = null;
		Connection conn = getConnectioDetails();
		String query = "SELECT  * from SUPPLIER_PORTAL.RETAILER_RETURNS_MASTER WHERE RETURN_ID = '" + rrId + "'";
		Statement st = conn.createStatement();
		logger.info(query);
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			retailerRetMasterObj = new RetailerReturnsMaster();
			retailerRetMasterObj.setReturnId(rs.getString("return_id"));
			retailerRetMasterObj.setReturnDate(rs.getString("return_date"));
			retailerRetMasterObj.setProcessedStatusFlag(rs.getString("processed_status_flag"));
			retailerRetMasterObj.setConcernRaisedFlag(rs.getString("concern_raised_flag"));
			retailerRetMasterObj.setOrderedDate(rs.getString("ordered_date"));
			retailerRetMasterObj.setPoList(rs.getString("po_list"));
			retailerRetMasterObj.setAsnList(rs.getString("asn_list"));
			retailerRetMasterObj.setConcernMsg(rs.getString("concern_msg"));
			retailerRetMasterObj.setReturnStatus(rs.getString("return_status"));
			retailerRetMasterObj.setTotalReturnItems(rs.getString("total_item_quantiy"));
			retailerRetMasterObj.setTotalUniqRetItems(rs.getString("total_unique_items"));
			retailerRetMasterObj.setTotalCostReturns(rs.getString("total_cost"));
			retailerRetMasterObj.setReturnSite(rs.getString("return_Site"));
			retailerRetMasterObj.setTruckNo(rs.getString("truck_No"));
			retailerRetMasterObj.setDriverName(rs.getString("driver_Name"));
			retailerRetMasterObj.setDriverDLNo(rs.getString("driver_DL_No"));
			retailerRetMasterObj.setLogisticsPartner(rs.getString("logistics_Partner"));
			retailerRetMasterObj.setItemDetails(rs.getString("item_details"));
		}
		logger.info("[C]AlertsDao::[M]getRetailererReturnsDetailsData -> The Retailer Returns List is: "
				+ retailerRetMasterObj.toString());
		return retailerRetMasterObj;
	}

	public ArrayList<ItemMaster> getItemListingDetailsData(String[] itemId)
			throws ClassNotFoundException, SQLException {
		ItemMaster itemMasterObj;
		ArrayList<ItemMaster> itemMasterList = new ArrayList<ItemMaster>();
		Connection conn = getConnectioDetails();
		String[] strarr = itemId;
		StringBuilder itemIdString = listingPricingUtils.toString(strarr);
		String query = "SELECT  * from SUPPLIER_PORTAL.ITEM_LISTING_MASTER WHERE ITEM_ID IN" + itemIdString
				+ "ORDER BY CREATED_DATETIME DESC LIMIT 20";
		logger.info(query);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			itemMasterObj = new ItemMaster();
			itemMasterObj.setItemId(rs.getString("item_Id"));
			itemMasterObj.setItemName(rs.getString("ITEM_NAME"));
			itemMasterObj.setItemDescription(rs.getString("item_Description"));
			itemMasterObj.setSku(rs.getString("sku"));
			itemMasterObj.setCategory(rs.getString("category"));
			itemMasterObj.setPrice(rs.getString("price"));
			itemMasterObj.setStatus(rs.getString("status"));
			itemMasterObj.setImageUrl(rs.getString("image_Url"));
			itemMasterObj.setRemoveItemFlag(rs.getString("remove_Item_Flag"));
			itemMasterList.add(itemMasterObj);
		}
		logger.info("[C]AlertsDao::[M]getItemListingDetailsData -> The Item details list is: " + itemMasterList.toString());
		return itemMasterList;
	}

	public ArrayList<PriceMaster> getCostChangeDetailsData(String[] ccId) throws ClassNotFoundException, SQLException {
		PriceMaster priceMasterObj;
		ArrayList<PriceMaster> priceMasterList = new ArrayList<PriceMaster>();
		Connection conn = getConnectioDetails();
		String[] strarr = ccId;
		StringBuilder costChangeIdString = listingPricingUtils.toString(strarr);
		String query = "SELECT  * from SUPPLIER_PORTAL.COST_CHANGE_MASTER WHERE ITEM_ID IN" + costChangeIdString
				+ "ORDER BY CREATED_DATETIME DESC LIMIT 20";
		logger.info(query);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			priceMasterObj = new PriceMaster();
			priceMasterObj.setItemId(rs.getString("item_Id"));
			priceMasterObj.setItemName(rs.getString("item_Name"));
			priceMasterObj.setItemDescription(rs.getString("item_Description"));
			priceMasterObj.setSku(rs.getString("sku"));
			priceMasterObj.setCategory(rs.getString("category"));
			priceMasterObj.setPrice(rs.getString("price"));
			priceMasterObj.setStatus(rs.getString("status"));
			priceMasterObj.setImageUrl(rs.getString("image_Url"));
			priceMasterObj.setRemoveItemFlag(rs.getString("remove_Item_Flag"));
			priceMasterList.add(priceMasterObj);
		}
		logger.info("[C]AlertsDao::[M]getCostChangeDetailsData -> The Product details list is: "
				+ priceMasterList.toString());
		return priceMasterList;
	}

}
