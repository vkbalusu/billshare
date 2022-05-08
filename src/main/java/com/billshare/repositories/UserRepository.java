package com.billshare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.billshare.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	public User findByEmail(String email);
}
