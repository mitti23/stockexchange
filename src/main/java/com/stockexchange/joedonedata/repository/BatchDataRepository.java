package com.stockexchange.joedonedata.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.stockexchange.joedonedata.repository.model.BatchDataEntity;

public interface BatchDataRepository extends PagingAndSortingRepository<BatchDataEntity, String>,
		CrudRepository<BatchDataEntity, String>, JpaSpecificationExecutor<BatchDataEntity> {

	
	@Modifying
	@Query("update BatchDataEntity o set status = :status ,remarks = :remarks, totalrecords = :records   where o.id = :id  ")
	void updateDetails(@Param("id") int id, @Param("status") String status, @Param("remarks") String remarks,	@Param("records") int records);
 

}
