package com.project.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.user.entity.UserEntity;
import com.project.user.repository.UserRepository;


@Service
public class UserBo {
	@Autowired
	private UserRepository userRepository;
	
	public UserEntity getUserEntityByNicknameId(String nicknameId) {
		return userRepository.findByLoginId(nicknameId); 
	}
	//회원가입
	//in-> parameter들
	//out-> 결과값으로 받는것들
	public Integer addUser(String loginId, String nicknameId, 
			String password, String name, 
			String phoneNumber, String emailAddress, 
			String address) {
		
		UserEntity userEntity = userRepository.save(
				UserEntity.builder()
				.loginId(loginId)
				.nicknameId(nicknameId)
				.password(password)
				.name(name)
				.phoneNumber(phoneNumber)
				.emailAddress(emailAddress)
				.address(address)
				.build());
		return userEntity == null ? null : userEntity.getId();
	}

	
	
}
