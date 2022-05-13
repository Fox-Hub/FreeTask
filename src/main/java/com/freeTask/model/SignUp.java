package com.freeTask.model;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class SignUp {
	
	@NotBlank(message = "ユーザーIDを入力してください")
	private String username;
	@NotBlank(message = "パスワードを入力してください")
	private String password;

}
