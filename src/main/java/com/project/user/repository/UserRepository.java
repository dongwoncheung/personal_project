package com.project.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.user.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>{

	//로그인 아이디 중복 확인
	public UserEntity findByLoginId(String loginId);
	
	//닉네임 아이디 중복확인
	public UserEntity findByNicknameId(String nicknameId);

	//로그인 
	public UserEntity findByLoginIdAndPassword(String loginId, String password);
}
