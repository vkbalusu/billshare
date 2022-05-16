package com.billshare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.billshare.entities.IndebtEntity;

@Repository
public interface IndebtRepository extends JpaRepository<IndebtEntity, Long>{
	
//	@Query("select indebts.bill from IndebtEntity as indebts where indebts.debtor = ?1")
//	public List<BillEntity> findUserBills(UserEntity debtor);
}
