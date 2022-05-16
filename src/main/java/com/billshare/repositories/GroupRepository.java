package com.billshare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.billshare.entities.GroupEntity;

@Repository
public interface GroupRepository extends JpaRepository<GroupEntity, Long>{
	
//	@Query("select user_groups.group from UserGroupEntity as user_groups where user_groups.member = ?1")
//	public List<GroupEntity> findUserGroups(UserEntity member);
}
