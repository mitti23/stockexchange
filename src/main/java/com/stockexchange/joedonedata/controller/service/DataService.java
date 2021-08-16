package com.stockexchange.joedonedata.controller.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.stockexchange.joedonedata.repository.model.DataEntity;

public interface DataService {

	public void addData(DataEntity data);

	public void uploadFileData(MultipartFile file);

	public List<DataEntity> searchData(String quarter, String stock);

}
