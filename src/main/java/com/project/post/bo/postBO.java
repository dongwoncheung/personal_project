package com.project.post.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.common.FileManagerService;
import com.project.post.domain.Post;
import com.project.post.mapper.PostMapper;
import com.project.post.domain.Post;

@Service
public class postBO {

	@Autowired
	private PostMapper postMapper;
	
	@Autowired
	private FileManagerService fileManager;
	// 게시글 뿌리기
	public List<Post> getPostListByUserId(int userId){
		
		List<Post> postList = postMapper.selectPostListByUserId(userId);
		
		return postList;
	}
	//게시글 업로드
	//in:controller에 있는 파라미터들
	//out:x
	public void addRoom(int userId, String userLoginId, 
			String title, String content, 
			String price, String homeAddress, 
			String location, MultipartFile file) {
		Post post = postMapper.insertPost(userId, title, content, price, homeAddress, location, location);
		if(post == null) {
			return;
		}
		
	}
	
	//게시글 detail
	//in: postid, userid
	//out:post에 수정된것들 
	public  Post getPostByPostIdUserId(int postId, int userId) {
		return postMapper.selectPostByPostIdUserId(postId, userId);
	}
	
	
	//게시글 수정
	//in: 수정을 할 parameter들
	//out: x
	public void updatePost(int userId, String userLoginId, int postId, String title, String content, MultipartFile file,String price) {
		Post post = postMapper.selectPostByPostIdUserId(postId, userId);
		if(post == null) {
			return;
		}
		String imageUrl = null;
		if(file != null) {
			imageUrl = fileManager.saveFile(userLoginId, file);
		}
		if (imageUrl != null && post.getImageUrl() != null) {
			// 업로드가 성공을 했고, 기존 이미지가 존재한다면 => 삭제
			// 이미지 제거
			fileManager.deleteFile(post.getImageUrl());
		}
	
	// DB 글 update
	postMapper.updatePostByPostIdUserId(postId, userId, title, content, price, imageUrl);
}
}