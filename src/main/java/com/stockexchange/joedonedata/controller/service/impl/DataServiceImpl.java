package com.stockexchange.joedonedata.controller.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.stockexchange.joedonedata.Exception.DataException;
import com.stockexchange.joedonedata.controller.service.DataService;
import com.stockexchange.joedonedata.repository.BatchDataRepository;
import com.stockexchange.joedonedata.repository.DataRepository;
import com.stockexchange.joedonedata.repository.model.BatchDataEntity;
import com.stockexchange.joedonedata.repository.model.DataEntity;
import com.stockexchange.joedonedata.util.CommonUtil;
import com.stockexchange.joedonedata.util.TransformJsonToDataObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
@Transactional
public class DataServiceImpl implements DataService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DataServiceImpl.class);

	@Autowired
	DataRepository dataRepository;

	@Autowired
	BatchDataRepository batchDataRepository;

	@Value("${file.upload-dir}")
	String filepath;

	int recordCount = 0;

	@Override
	public void addData(DataEntity data) {
		validate(data);
		try {
			dataRepository.save(data);
		} catch (Exception e) {
			LOGGER.error("Error while adding data "+data,e);
			throw new RuntimeException(e);
		}
	}

	private void validate(DataEntity data) {
		if (!(data.getQuarter() == 1 || data.getQuarter() == 2 || data.getQuarter() == 3 || data.getQuarter() == 4)) {
			throw new DataException("Quarter value should be in [1, 2 , 3 , 4 ] ");
		}
		if (CommonUtil.isEmpty(data.getStock())) {
			throw new DataException("Stock is mandatory!");
		}
		if (data.getLastBusinessDate() == null) {
			throw new DataException("Date is mandatory!");
		}
		// Similarly other validations can be added as per business requirement
	}

	

	@Override
	public void uploadFileData(MultipartFile file) {
		BatchDataEntity batch = null;
		boolean hasError = false;
		try {
			String filePath = filepath + file.getOriginalFilename();			
			File convFile = new File(filePath);
			file.transferTo(convFile);			
			Scanner input = new Scanner(convFile);

			batch = saveBatchDetails(file.getOriginalFilename());
			ArrayList<DataEntity> dataList = readFile(input);
			dataRepository.saveAll(dataList);
			batchDataRepository.updateDetails(batch.getId(), "S", "Successfully updated", recordCount);

		} catch (Exception e) {
			LOGGER.error("Error while uploading file ",e);
			hasError = true;

		}   finally {
			if (hasError) {
				if (batch != null) {
					batchDataRepository.updateDetails(batch.getId(), "E", "Error in uploading data", 0);
				}
				throw new DataException("Error while reading file or records, check on line " + recordCount);
			}
		}

	}

	private ArrayList<DataEntity> readFile(Scanner input) {
		ArrayList<DataEntity> dataList = new ArrayList<DataEntity>();
		boolean isFirstLine = true;
		while (input.hasNext()) {
			recordCount++;
			if (isFirstLine) {
				isFirstLine = false;
				input.nextLine();
			} else {
				String string = input.nextLine();
 				DataEntity data = TransformJsonToDataObject.getObjectFromString(string, ",",recordCount);
 				validate(data);
				dataList.add(data);
			}
		}
		return dataList;
	}

	private BatchDataEntity saveBatchDetails(String filename) {
		BatchDataEntity batch = new BatchDataEntity();
		batch.setFilename(filename);
		batch.setStatus("I");// Batch started to process
		batch.setRemarks("File process start");
		batch.setProcessedstarttime(new Date());
		return batchDataRepository.save(batch);

	}

	@Override
	public List<DataEntity> searchData(String quarter, String stock) {
		boolean quarterCheck = false;
		boolean stockCheck = false;
		int quarterInt=0;
		if(quarter != null && !quarter.trim().equals("")) {
			quarterCheck = true;
			try {
			quarterInt = CommonUtil.getIntValue(quarter);
			}catch(Exception e) {
				throw new DataException("Invalid value for quarter [ valid values : 1, 2, 3, 4]");

			}
			if(quarterInt<1 || quarterInt >4) {
				throw new DataException("Invalid value for quarter [ valid values : 1, 2, 3, 4]");
			}
		}
		if(stock != null && !stock.trim().equals("")) {
			stockCheck = true;
		}
		List<DataEntity> listObject= new ArrayList<DataEntity>();
		if(quarterCheck && stockCheck) {
			listObject = dataRepository.findByStockandQuarter(stock,quarterInt);
		}else if(quarterCheck) {
			listObject = dataRepository.findByQuarter(quarterInt);
		}else {
			//only stock check
			listObject = dataRepository.findByStock(stock);
		}
		return listObject;
	}

}
