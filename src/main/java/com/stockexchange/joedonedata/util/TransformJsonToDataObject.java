package com.stockexchange.joedonedata.util;

import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.stockexchange.joedonedata.Exception.DataException;
import com.stockexchange.joedonedata.repository.model.DataEntity;

public class TransformJsonToDataObject {

	public static DataEntity getObjectFromString(String jsonStr) {

		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setDateFormat("dd/mm/yyyy"); // setting custom date format
		Gson gson = gsonBuilder.create();

		DataEntity obj = null;

		try {
			obj = gson.fromJson(jsonStr, DataEntity.class);
		} catch (Exception e) {
 			e.printStackTrace();
		}
		return obj;
	}

	public static DataEntity getObjectFromString(String commaDelimiterStr, String delimiter, int lineNumber) {
		if (commaDelimiterStr == null) {
			throw new DataException("Data is invalid.");
		}
		String[] s = commaDelimiterStr.split(delimiter);
		if (s.length < 16) {
			throw new DataException("Data is invalid.");
		}
		try {
			DataEntity obj = new DataEntity();
			obj.setQuarter(CommonUtil.getIntValue(s[0]));
			obj.setStock(s[1]);
			obj.setLastBusinessDate(CommonUtil.getDate(s[2]));
			if (!CommonUtil.isEmpty(s[3]))
				obj.setOpen(CommonUtil.getBigDecimal(s[3]));
			if (!CommonUtil.isEmpty(s[4]))
				obj.setHigh(CommonUtil.getBigDecimal(s[4]));
			if (!CommonUtil.isEmpty(s[5]))
				obj.setLow(CommonUtil.getBigDecimal(s[5]));
			if (!CommonUtil.isEmpty(s[6]))
				obj.setClose(CommonUtil.getBigDecimal(s[6]));
			if (!CommonUtil.isEmpty(s[7]))
				obj.setVolume(CommonUtil.getLongValue(s[7]));
			if (!CommonUtil.isEmpty(s[8]))
				obj.setPercentChangePrice(CommonUtil.getBigDecimal(s[8]));
			if (!CommonUtil.isEmpty(s[9]))
				obj.setPercentChangeVolumeOverLastWk(CommonUtil.getBigDecimal(s[9]));
			if (!CommonUtil.isEmpty(s[10]))
				obj.setPreviousWeeksVolume(CommonUtil.getLongValue(s[10]));
			if (!CommonUtil.isEmpty(s[11]))
				obj.setNextWeeksOpen(CommonUtil.getBigDecimal(s[11]));
			if (!CommonUtil.isEmpty(s[12]))
				obj.setNextWeeksClose(CommonUtil.getBigDecimal(s[12]));
			if (!CommonUtil.isEmpty(s[13]))
				obj.setPercentChangeNextWeeksPrice(CommonUtil.getBigDecimal(s[13]));
			if (!CommonUtil.isEmpty(s[14]))
				obj.setDaysToNextDividend(CommonUtil.getIntValue(s[14]));
			if (!CommonUtil.isEmpty(s[15]))
				obj.setPercentReturnNextDividend(CommonUtil.getBigDecimal(s[15]));
			return obj;
		} catch (DataException e) {
			String error = e.getMessage() + ", check line :" + lineNumber;
			throw new DataException(error);
		}
	}

}
