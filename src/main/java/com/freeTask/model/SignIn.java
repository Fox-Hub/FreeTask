package com.freeTask.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class SignIn {
	
	@NotNull(message = "ユーザーIDを入力してください")
	private String userId;
	@NotEmpty(message = "パスワードを入力してください")
	private String password;

}
