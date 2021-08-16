package com.stockexchange.joedonedata.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.stockexchange.joedonedata.repository.model.DataEntity;

public interface   DataRepository extends  PagingAndSortingRepository<DataEntity, String>,
CrudRepository<DataEntity, String>, JpaSpecificationExecutor<DataEntity> {

	@Query("select de from DataEntity  de where de.quarter = :quarter and de.stock = :stock ")
	List<DataEntity>  findByStockandQuarter(@Param("stock") String stock,
			  @Param("quarter") int quarter);
			
 	@Query("select de from DataEntity  de where de.quarter = :quarter  ")
	List<DataEntity> findByQuarter(@Param("quarter") int quarter);

	@Query("select de from DataEntity  de where   de.stock = :stock ")
	List<DataEntity> findByStock(@Param("stock") String stock);

}
