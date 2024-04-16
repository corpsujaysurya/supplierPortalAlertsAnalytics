package com.kpmg.te.retail.supplierportal.alertsDashboards.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.UUID;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Component;

import com.kpmg.te.retail.supplierportal.alertsDashboards.modelsdao.DateAndTime;

@Component
public class ListingPricingUtils {

	private static final Logger logger = Logger.getLogger(ListingPricingUtils.class.getName());

	public int convertStringToInt(String str) {
		int result = 0;
		if (str == null || str.isEmpty() || str.trim().isEmpty()) {
			return result;
		}
		result = Integer.parseInt(str);
		return result;
	}

	public String getCellValue(Row row, int cellNo) {
		DataFormatter formatter = new DataFormatter();
		Cell cell = row.getCell(cellNo);
		return formatter.formatCellValue(cell);
	}

	@SuppressWarnings({ "unused", "deprecation" })
	public DateAndTime getDateAndTimeForUploadData() {
		DateAndTime dat = new DateAndTime();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		dat.setYear(timestamp.getYear());
		dat.setMonth(timestamp.getMonth());
		dat.setDate(timestamp.getDay());
		dat.setHour(timestamp.getHours());
		dat.setMinute(timestamp.getMinutes());
		dat.setSecond(timestamp.getSeconds());
		dat.setTimestamp(timestamp.toString());
		return dat;
	}

	public String setRandomUUID() {
		return UUID.randomUUID().toString();
	}

	public StringBuilder toString(String[] a) {
		int iMax = a.length - 1;
		StringBuilder b = new StringBuilder();
		b.append('(');
		for (int i = 0;; i++) {
			b.append("'" + String.valueOf(a[i]) + "'");
			if (i == iMax) {
				b.append(')').toString();
				return b;
			}
			b.append(", ");
			System.out.println(b.toString());
		}

	}

	public String createNewAlertId() {
		String alertId = "AL-" + generateRandomNumber(7);
		logger.info("[C]ListingPricingUtils::[M]createNewAlertId -> The Alert ID generated is:" + alertId.toString());
		return alertId;
	}

	public String generateCurrentDate() {
		return new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime());
	}

	public String generateRandomNumber(int charLength) {
		return String.valueOf(charLength < 1 ? 0
				: new Random().nextInt((9 * (int) Math.pow(10, charLength - 1)) - 1)
						+ (int) Math.pow(10, charLength - 1));
	}

}
