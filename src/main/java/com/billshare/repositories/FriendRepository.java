package com.billshare.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.billshare.entities.FriendEntity;
import com.billshare.entities.UserEntity;


@Repository
public interface FriendRepository extends JpaRepository<FriendEntity, Long> { 
	
	public List<FriendEntity> findByRequesterAndAddressee(UserEntity requester, UserEntity addressee);
	
	@Query("select f.addressee from FriendEntity as f where f.requester = ?1 and status= ?2")
	public List<UserEntity> findFriendsofUser(UserEntity requestor, String status);
}
