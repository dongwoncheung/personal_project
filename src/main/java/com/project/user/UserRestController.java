package com.project.user;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class UserRestController {

	@PostMapping("/sign-up")
	public Map<String, Integer> signUp(
			@RequestParam("nicknameId") String nicknameId,
			@RequestParam("password") String password,
			@RequestParam("name") String name,
			@RequestParam("phoneNumber") String phoneNumber,
			@RequestParam("address") String address,
			@RequestParam("emailAddress") String emailAddress
			){
			
		//db insert 
		userBO.
		return;
	}
}
