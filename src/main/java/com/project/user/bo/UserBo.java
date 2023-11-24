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
//	//아이디 중복확인
//	//in : loginId
//	//out: userEntity(null도 가능함)
//	public UserEntity getUserEntityByLoginIdAndNicknameId(String loginId, String nicknameId) {
//		return userRepository.findByLoginIdAndNicknameId(loginId, nicknameId); 
//	}
    // 아이디 중복확인
    // in: loginId
    // out: true if duplicated, false otherwise
//    public UserEntity isDuplicatedLoginId(String loginId, String nicknameId) {
//    	return userRepository.findByLoginIdAndNicknameId(loginId, nicknameId);
//    }

//	// 닉네임 중복확인
//	// in: nicknameId
//	// out: true if duplicated, false otherwise
//	public UserEntity isDuplicatedNicknameId(String nicknameId) {
//		return userRepository.findByNicknameId(nicknameId);
//		
//	}
    
//	//닉네임 중복 확인
//	//in : nicknameId
//	//out : userEntity 
//	public UserEntity getUserEntityByNicknameId(String nicknameId) {
//		return userRepository.findByNicknameId(nicknameId);
//	}

    public UserEntity getUserEntityByLoginId(String loginId) {
		return userRepository.findByLoginId(loginId); 
	}
	public UserEntity getUserEntityByNicknameId(String nicknameId) {
		return userRepository.findByNicknameId(nicknameId);
	}
	
}
