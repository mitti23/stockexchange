package com.stockexchange.joedonedata.repository.model;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.math.BigDecimal;
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

@Entity
@Table(name = "stockdata")
@JsonInclude(Include.NON_NULL)
public class DataEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "batchid", nullable = true)
	private int batchid;

	@Column(name = "quarter")
	private int quarter;

	@Column(name = "stock")
	private String stock;

	@Column(name = "lastbusinessdate")
	//@DateTimeFormat(pattern = "yyyy-mm-dd hh:mm:ss")
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	@Temporal(TemporalType.TIMESTAMP)
	Date lastBusinessDate;

	@Column(name = "open")
	BigDecimal open;

	@Column(name = "high")
	BigDecimal high;

	@Column(name = "low")
	BigDecimal low;

	@Column(name = "close")
	BigDecimal close;

	@Column(name = "volume")
	long volume;

	@Column(name = "percent_change_price")
	BigDecimal percentChangePrice;

	@Column(name = "percent_change_volume_over_last_wk")
	BigDecimal percentChangeVolumeOverLastWk;

	@Column(name = "previous_weeks_volume")
	long previousWeeksVolume;

	@Column(name = "next_weeks_open")
	BigDecimal nextWeeksOpen;

	@Column(name = "next_weeks_close")

	BigDecimal nextWeeksClose;

	@Column(name = "percent_change_next_weeks_price")
	BigDecimal percentChangeNextWeeksPrice;

	@Column(name = "days_to_next_dividend")
	int daysToNextDividend;

	@Column(name = "percent_return_next_dividend")
	BigDecimal percentReturnNextDividend;

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

	@Column(name = "createdby", length = 64)
	private String createdby;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBatchid() {
		return batchid;
	}

	public void setBatchid(int batchid) {
		this.batchid = batchid;
	}

	public int getQuarter() {
		return quarter;
	}

	public void setQuarter(int quarter) {
		this.quarter = quarter;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public Date getLastBusinessDate() {
		return lastBusinessDate;
	}

	public void setLastBusinessDate(Date lastBusinessDate) {
		this.lastBusinessDate = lastBusinessDate;
	}

	public BigDecimal getOpen() {
		return open;
	}

	public void setOpen(BigDecimal open) {
		this.open = open;
	}

	public BigDecimal getHigh() {
		return high;
	}

	public void setHigh(BigDecimal high) {
		this.high = high;
	}

	public BigDecimal getLow() {
		return low;
	}

	public void setLow(BigDecimal low) {
		this.low = low;
	}

	public BigDecimal getClose() {
		return close;
	}

	public void setClose(BigDecimal close) {
		this.close = close;
	}

	public long getVolume() {
		return volume;
	}

	public void setVolume(long volume) {
		this.volume = volume;
	}

	public BigDecimal getPercentChangePrice() {
		return percentChangePrice;
	}

	public void setPercentChangePrice(BigDecimal percentChangePrice) {
		this.percentChangePrice = percentChangePrice;
	}

	public BigDecimal getPercentChangeVolumeOverLastWk() {
		return percentChangeVolumeOverLastWk;
	}

	public void setPercentChangeVolumeOverLastWk(BigDecimal percentChangeVolumeOverLastWk) {
		this.percentChangeVolumeOverLastWk = percentChangeVolumeOverLastWk;
	}

	public long getPreviousWeeksVolume() {
		return previousWeeksVolume;
	}

	public void setPreviousWeeksVolume(long previousWeeksVolume) {
		this.previousWeeksVolume = previousWeeksVolume;
	}

	public BigDecimal getNextWeeksOpen() {
		return nextWeeksOpen;
	}

	public void setNextWeeksOpen(BigDecimal nextWeeksOpen) {
		this.nextWeeksOpen = nextWeeksOpen;
	}

	public BigDecimal getNextWeeksClose() {
		return nextWeeksClose;
	}

	public void setNextWeeksClose(BigDecimal nextWeeksClose) {
		this.nextWeeksClose = nextWeeksClose;
	}

	public BigDecimal getPercentChangeNextWeeksPrice() {
		return percentChangeNextWeeksPrice;
	}

	public void setPercentChangeNextWeeksPrice(BigDecimal percentChangeNextWeeksPrice) {
		this.percentChangeNextWeeksPrice = percentChangeNextWeeksPrice;
	}

	public int getDaysToNextDividend() {
		return daysToNextDividend;
	}

	public void setDaysToNextDividend(int daysToNextDividend) {
		this.daysToNextDividend = daysToNextDividend;
	}

	public BigDecimal getPercentReturnNextDividend() {
		return percentReturnNextDividend;
	}

	public void setPercentReturnNextDividend(BigDecimal percentReturnNextDividend) {
		this.percentReturnNextDividend = percentReturnNextDividend;
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
		return "DataEntity [id=" + id + ", batchid=" + batchid + ", quarter=" + quarter + ", stock=" + stock
				+ ", lastBusinessDate=" + lastBusinessDate + ", open=" + open + ", high=" + high + ", low=" + low
				+ ", close=" + close + ", volume=" + volume + ", percentChangePrice=" + percentChangePrice
				+ ", percentChangeVolumeOverLastWk=" + percentChangeVolumeOverLastWk + ", previousWeeksVolume="
				+ previousWeeksVolume + ", nextWeeksOpen=" + nextWeeksOpen + ", nextWeeksClose=" + nextWeeksClose
				+ ", percentChangeNextWeeksPrice=" + percentChangeNextWeeksPrice + ", daysToNextDividend="
				+ daysToNextDividend + ", percentReturnNextDividend=" + percentReturnNextDividend + ", lastupdatedon="
				+ lastupdatedon + ", createdon=" + createdon + ", lastupdatedby=" + lastupdatedby + ", createdby="
				+ createdby + "]";
	}
	
	
}
