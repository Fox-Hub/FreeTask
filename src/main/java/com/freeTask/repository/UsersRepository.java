package com.freeTask.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.freeTask.entity.Users;

public interface UsersRepository extends JpaRepository<Users, String> {
	
	Users findByUseridAndPassword(String userid, String password);

}
