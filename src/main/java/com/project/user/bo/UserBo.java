package com.project.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.user.entity.UserEntity;
import com.project.user.repository.UserRepository;



@Service
public class UserBo {

	@Autowired
	private UserRepository userRepository;
	//회원가입
	//in-> parameter들
	//out-> 결과값으로 받는것들

	public Integer addUser(String nicknameId, String password, 
			String name, String phoneNumber, String address, String emailAddress) {
			UserEntity userEntity = userRepository.save(
					UserEntity.builder()
					.nicknameId(nicknameId)
					.password(password)
					.name(name)
					.phoneNumber(phoneNumber)
					.address(address)
					.emailAddress(emailAddress)
					.build());
			return userEntity == null ? null : userEntity.getId();

		
				
	}
	
	
}
