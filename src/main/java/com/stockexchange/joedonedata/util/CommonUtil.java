package com.stockexchange.joedonedata.util;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.stockexchange.joedonedata.Exception.DataException;

public class CommonUtil {

	static DateFormat dateformat = new SimpleDateFormat("dd/mm/yyyy");

	public static Date getDate(String dateStr) {
		if (dateStr == null) {
			throw new DataException("Error while parsing date :" + dateStr);

		}
		try {
			if(dateStr.length()<10) {
				dateStr="0"+dateStr;
			}
			return dateformat.parse(dateStr);
		} catch (ParseException e) {
			throw new DataException("Error while parsing date :" + dateStr);
		}
	}

	public static BigDecimal getBigDecimal(String string) {
		try {
			string=string.replace("$","");
			return new BigDecimal(string);
		} catch (Exception e) {
			throw new DataException("Error while parsing value :" + string + " to big decimal");
		}
	}

	public static int getIntValue(String string) {
		try {
			return Integer.parseInt(string);
		} catch (Exception e) {
			throw new DataException("Error while parsing value :" + string + " to integer ");
		}
	}

	public static long getLongValue(String string) {
		try {
			return Long.parseLong(string);
		} catch (Exception e) {
			throw new DataException("Error while parsing value :" + string + " to long ");
		}
	}
	
	public static boolean isEmpty(String value) {
		if (value == null || value.trim().equals("")) {
			return true;
		}
		return false;
	}

}
