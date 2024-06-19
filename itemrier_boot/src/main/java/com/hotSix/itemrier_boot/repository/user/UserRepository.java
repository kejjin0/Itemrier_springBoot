package com.hotSix.itemrier_boot.repository.user;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hotSix.itemrier_boot.domain.user.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	UserEntity findByUserId(int userId);
	UserEntity findByEmail(String email);
	
	@Query("SELECT COUNT(email) FROM UserEntity WHERE email = :email")
	int countByEmail(String email);
}
