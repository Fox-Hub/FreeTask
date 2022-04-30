package com.freeTask.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Users {
	
	@Id
	private Integer id;
	private String userid;
	private String password;

}
