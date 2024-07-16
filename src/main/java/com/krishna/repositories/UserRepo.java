package com.krishna.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.krishna.entities.UserAccount;

import jakarta.transaction.Transactional;

public interface UserRepo extends JpaRepository<UserAccount, Integer> {
	
	@Modifying
	@Transactional
	@Query("update UserAccount set activeSw=:status where userId=:id")
	public Integer updateAccStatus(Integer id, String status);

}
