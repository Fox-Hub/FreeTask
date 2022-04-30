package com.freeTask.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freeTask.entity.Users;
import com.freeTask.repository.UsersRepository;

@Service
public class UsersService {
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Transactional
	public Users getUser(String userid, String password) {
		Users user = usersRepository.findByUseridAndPassword(userid, password);
		return user;
	}

}
