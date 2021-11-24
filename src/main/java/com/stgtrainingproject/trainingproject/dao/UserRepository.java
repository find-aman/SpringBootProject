package com.stgtrainingproject.trainingproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stgtrainingproject.trainingproject.entities.User;

public interface UserRepository extends JpaRepository<User, Integer > {
	
	@Query("select u from User u where u.userId = :userId")
	public User getUserByUserId(@Param("userId") String userId);

}
