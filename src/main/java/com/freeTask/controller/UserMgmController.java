package com.freeTask.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.freeTask.entity.Account;
import com.freeTask.model.UserMgmForm;
import com.freeTask.service.AccountService;

@Controller
public class UserMgmController {

	@Autowired
	private AccountService accountService;

	@GetMapping("/userMgm/search")
	public String userSearch(UserMgmForm userMgmForm, Model model) {

		boolean isUsername = false;
		boolean isType = false;
		boolean isActive = false;

		List<Account> accountList = new ArrayList<Account>();
		List<String> typeList = new ArrayList<String>();
		List<String> temp = new ArrayList<String>();

		if ("".equals(userMgmForm.getUsername()) || userMgmForm.getUsername() == null)
			isUsername = true;

		if (userMgmForm.getType() == null || "0".equals(userMgmForm.getType()))
			isType = true;

		if (userMgmForm.getActive() == null
				|| (userMgmForm.getActive().length == 0 || userMgmForm.getActive().length == 2))
			isActive = true;
		
		System.out.println("user = " + isUsername + "type = " + isType + "active = " + isActive);

		if ((!isUsername && !isType && !isActive) || (isUsername && isType && isActive))
			accountList = accountService.findAll();
		else if (!isUsername) {
			if (!isType)
				accountList = accountService.getAccountListUsernameAndType(userMgmForm.getUsername(),
						userMgmForm.getType());
			else if (!isActive)
				if("0".equals(userMgmForm.getActive()[0]))
				accountList = accountService.getAccountListUsernameAndActiveTrue(userMgmForm.getUsername());
				else
					accountList = accountService.getAccountListUsernameAndActiveFalse(userMgmForm.getUsername());
			else
				accountList = accountService.getAccountListUsername(userMgmForm.getUsername());

		} else if (!isType) {
			if (!isActive) {
				if ("0".equals(userMgmForm.getActive()[0]))
					accountList = accountService.getAccountListTypeAndActiveTrue(userMgmForm.getType());
				else
					accountList = accountService.getAccountListTypeAndActiveFalse(userMgmForm.getType());
			} else
				accountList = accountService.getAccountListType(userMgmForm.getType());
		}else if(!isActive) {
			if("0".equals(userMgmForm.getActive()[0]))
				accountList = accountService.getAccountListActiveTrue();
			else
				accountList = accountService.getAccountListActiveFalse();
		}

		accountService.findAll().stream().forEach(account -> temp.add(account.getType()));
		temp.stream().distinct().forEach(type -> typeList.add(type));

		model.addAttribute("typeList", typeList);
		model.addAttribute("accountList", accountList);

		return "tile/userMgm";
	}

}
