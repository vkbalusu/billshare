package com.billshare.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.billshare.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
	
	public UserEntity findByEmail(String email);
	
	//see: https://github.com/spring-projects/spring-data-jpa/issues/2472
	public List<UserEntity> findByEmailStartsWith(@Param("email") String email);
}
