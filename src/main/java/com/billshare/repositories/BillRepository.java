package com.billshare.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.billshare.entities.BillEntity;
import com.billshare.entities.GroupEntity;
import com.billshare.entities.UserEntity;

@Repository
public interface BillRepository extends JpaRepository<BillEntity, Long>{
	
	public List<BillEntity> findByCreatedBy(UserEntity user);
	
	public List<BillEntity> findByGroup(GroupEntity group);
}
