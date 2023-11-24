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



	/**
	 * 로그인 아이디 중복확인
	 * @param loginId
	 * @return
	 */
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


	/**
	 * 닉네임아이디 중복확인
	 * @param nicknameId
	 * @return
	 */
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
	@PostMapping("/sign-in")
	public Map<String, Object>signIn(
			@RequestParam("loginId") String loginId,
			@RequestParam("password") String password,
			HttpServletRequest request){
		
		//비밀번호를 hashing
		String hashedPassword = EncryptUtils.md5(password);
		//db조회(loginId, 해싱된 비밀번호)
		UserEntity user = userBO.getUserEntityByLoginIdPassword(loginId, hashedPassword);
		
		Map<String, Object>result = new HashMap<>();
		
		if(user != null) {
			HttpSession session =  request.getSession();
			session.setAttribute("userId", user.getId());
			session.setAttribute("userName", user.getName());
			session.setAttribute("loginId", user.getLoginId());
			result.put("code", 200);
			result.put("result", "성공");
		}else {
			result.put("code", 500);
			result.put("errorMessage", "잘못된 사용자입니다");
		}
		return result;
	}

}

