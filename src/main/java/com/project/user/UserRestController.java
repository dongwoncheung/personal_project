package com.project.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.common.EncryptUtils;
import com.project.user.bo.UserBo;


@Controller
@RequestMapping("/user")
public class UserRestController {
	@Autowired
	private UserBo userBO;
	@PostMapping("/sign-up")
		public Map<String, Object> signUp(
				@RequestParam("loginId") String loginId,
				@RequestParam("nicknameId") String nicknameId,
				@RequestParam("password") String password,
				@RequestParam("name") String name,
				@RequestParam("phoneNumber") String phoneNumber,
				@RequestParam("emailAddress") String emailAddress,
				@RequestParam("address") String address){
		// 비밀번호 해싱
	    String hashedPassword = EncryptUtils.md5(password);
	    
	    //DB insert
	    Integer userId = userBO.addUser(loginId, nicknameId, hashedPassword, name, phoneNumber, emailAddress, address);
	    
	    Map<String, Object> result = new HashMap<>();
	    if(userId != null) {
	    	result.put("code", 200);
	    	result.put("result", "성공");
	    }else {
	    	result.put("code", 500);
	    	result.put("errorMessage", "회원가입 실패");
	    }
	    
	    return result;
		}
	
	
}

