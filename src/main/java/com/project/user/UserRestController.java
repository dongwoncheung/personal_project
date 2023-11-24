package com.project.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.common.EncryptUtils;
import com.project.user.bo.UserBo;
import com.project.user.entity.UserEntity;


@RequestMapping("/user")
@RestController
public class UserRestController {
	@Autowired
	private UserBo userBO;

//	@RequestMapping("/check-duplicates")
//	public Map<String, Object> isDuplicatedId(
//			@RequestParam("loginId") String loginId,
//			@RequestParam("nicknameId") String nicknameId) {
//
//		Map<String, Object> result = new HashMap<>();
//	    // Check for duplicated ID
//	    UserEntity userEntity = userBO.isDuplicatedLoginId(loginId, nicknameId);
//	    result.put("code", 200);
//	    result.put("isDuplicatedId", false);
//	    
//	    if(userEntity != null) {
//	    	result.put("isDuplicatedId", true);
//	    }
//	    return result;
//	}

//	    // Check for duplicated nickname
//	    UserEntity isDuplicatedNickname = userBO.isDuplicatedNicknameId(nicknameId);
//	    result.put("isDuplicatedNickname", isDuplicatedNickname);

	@RequestMapping("/is-duplicated-id")
	public Map<String, Object> isDuplicatedId(
			@RequestParam("loginId") String loginId) {

		Map<String, Object> result = new HashMap<>();
		result.put("isDuplicatedId", false);

		// select
		UserEntity userEntity = userBO.getUserEntityByLoginId(loginId);
		result.put("code", 200);

		if (userEntity != null) {
			result.put("isDuplicatedId", true);
		}

		return result;
	}


	@RequestMapping("/duplicated-nicknameId")
	public Map<String, Object> isDuplicatedNicknameId(
			@RequestParam("nicknameId") String nicknameId) {

		Map<String, Object> result = new HashMap<>();
		result.put("isDuplicatedNicknameId", false);

		// select
		UserEntity userEntity = userBO.getUserEntityByNicknameId(nicknameId);
		result.put("code", 200);

		if (userEntity != null) {
			result.put("isDuplicatedId", true);
		}

		return result;
	}
	
	/**
	 * 회원가입
	 * @param loginId
	 * @param nicknameId
	 * @param password
	 * @param name
	 * @param phoneNumber
	 * @param emailAddress
	 * @param address
	 * @return
	 */
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

