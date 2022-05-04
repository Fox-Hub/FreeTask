package com.freeTask.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Account {
	@Id
	@Column(length = 80)
	private String username;

	@Column(length = 20)
	private String type;

	private Boolean active;
}
