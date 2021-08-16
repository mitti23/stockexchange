package com.stockexchange.joedonedata.repository.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@Entity
@Table(name = "batchdata")
@JsonInclude(Include.NON_NULL)
public class BatchDataEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "filename", length = 250)
	private String filename;

	@Column(name = "status", length = 5)
	private String status;
 
	@Column(name = "remarks", length = 500)
	private String remarks;

	@Column(name = "totalrecords")
	private int totalrecords;

	@Column(name = "processedstarttime")
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	private Date processedstarttime;

	@Column(name = "totalprocesstime")
	private int totalprocesstime;

	@Column(name = "lastupdatedon")
	@UpdateTimestamp
	@DateTimeFormat(pattern = "yyyy-mm-dd hh:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastupdatedon;

	@Column(name = "createdon")
	@CreationTimestamp
	@DateTimeFormat(pattern = "yyyy-mm-dd hh:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdon;

	@Column(name = "lastupdatedby", length = 64)
	private String lastupdatedby;

	@Column(name = "createdby",   length = 64)
	private String createdby;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getTotalrecords() {
		return totalrecords;
	}

	public void setTotalrecords(int totalrecords) {
		this.totalrecords = totalrecords;
	}

	public Date getProcessedstarttime() {
		return processedstarttime;
	}

	public void setProcessedstarttime(Date processedstarttime) {
		this.processedstarttime = processedstarttime;
	}

	public int getTotalprocesstime() {
		return totalprocesstime;
	}

	public void setTotalprocesstime(int totalprocesstime) {
		this.totalprocesstime = totalprocesstime;
	}

	public Date getLastupdatedon() {
		return lastupdatedon;
	}

	public void setLastupdatedon(Date lastupdatedon) {
		this.lastupdatedon = lastupdatedon;
	}

	public Date getCreatedon() {
		return createdon;
	}

	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}

	public String getLastupdatedby() {
		return lastupdatedby;
	}

	public void setLastupdatedby(String lastupdatedby) {
		this.lastupdatedby = lastupdatedby;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	@Override
	public String toString() {
		return "BatchDataEntity [id=" + id + ", filename=" + filename + ", status=" + status + ", remarks=" + remarks
				+ ", totalrecords=" + totalrecords + ", processedstarttime=" + processedstarttime
				+ ", totalprocesstime=" + totalprocesstime + ", lastupdatedon=" + lastupdatedon + ", createdon="
				+ createdon + ", lastupdatedby=" + lastupdatedby + ", createdby=" + createdby + "]";
	}
	
	
}
