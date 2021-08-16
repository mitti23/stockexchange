package com.stockexchange.joedonedata.controller;

import java.util.List;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.stockexchange.joedonedata.Exception.DataException;
import com.stockexchange.joedonedata.controller.service.DataService;
import com.stockexchange.joedonedata.repository.model.DataEntity;
import com.stockexchange.joedonedata.util.TransformJsonToDataObject;

/**
 * Controller contains API, to add, upload and search data
 */
@RestController
@RequestMapping("stockmarket")
public class DataController {

	@Autowired
	DataService dataService;

	// Add single records
	// Upload File
	// Request: {{Serverurl}}/stockmarket
	// Request Type: POST
	// Response: String : success / failure
	// Assumption: Data can be replicate for stock, quarter
	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> addData(@RequestBody String strObj, HttpSession session) {
		DataEntity data = TransformJsonToDataObject.getObjectFromString(strObj);
		if (data == null) {
			// throw error
			return new ResponseEntity<Object>("Request data format is invalid.", HttpStatus.BAD_REQUEST);
		}
		dataService.addData(data);
		return new ResponseEntity<Object>("Data successfully added to backend.", HttpStatus.OK);
	}

	// Upload File : Bulk Upload
	// Request: {{Serverurl}}/stockmarket/uploadFile
	// Request Type: Post
	// Response: String : success / failure
	// Assumption: Data can be replicate for stock, quarter
	// Mandatory check on quarter, date and stock
	@PostMapping("/uploadFile")
	public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) {
		dataService.uploadFileData(file);
		return new ResponseEntity<Object>("File successfully uploaded.", HttpStatus.OK);
	}

	// To search backend data
	// URL : {{Serverurl}}/stockmarket?stock=AA&quarter=2
	// Request Type: GET
	// Response: Array of DataEntity Object

	@GetMapping()
	public ResponseEntity<Object> getDataList(@RequestParam(value = "quarter", required = false) String quarter,
			@RequestParam(value = "stock", required = false) String stock) {
		if ((quarter == null || quarter.trim().equals("")) && (stock == null || stock.trim().equals(""))) {
			throw new DataException("Either 'stock' or 'quarter' parameter should be specified to start search");
		}
		List<DataEntity> list = dataService.searchData(quarter, stock);
		return new ResponseEntity<Object>(list, HttpStatus.OK);
	}

}
