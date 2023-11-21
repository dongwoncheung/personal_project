package com.project.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.user.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>{
		//UserEntity 는 null이거나 채워져있거나 -> 로그인 아이디 중복 확인
		public UserEntity findByLoginId(String loginId);// 단건 조회
		
		public UserEntity findByNicknameId(String nicknameId);
		//userentity 는 null이거나 채워져있거나
		public UserEntity findByLoginIdAndPassword(String loginId, String password); //pk매소드로 조회
}
