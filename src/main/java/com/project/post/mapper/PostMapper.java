package com.project.post.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.project.post.domain.Post;
import com.project.post.domain.Post;

@Repository
public interface PostMapper {
	
	public List<Post> selectPostListByUserId(int userId);
	
	//int userId, String userLoginId, String title, String content, String price, String homeAddress, String location, MultipartFile file
	public Post insertPost(
			@Param("userId") int userId,
	        @Param("title") String title,
	        @Param("content") String content,
	        @Param("price") String price,
	        @Param("homeAddress") String homeAddress,
	        @Param("location") String location,
	        @Param("imageUrl") String imageUrl);

	public Post selectPostByPostIdUserId(
			@Param("postId") int postId,
			@Param("userId") int userId);
	
	// 게시글 수정
	//int userId, String userLoginId, int postId, String title, String content, MultipartFile file,String price
	public void updatePostByPostIdUserId(
			@Param("postId") int postId,
			@Param("userId") int userId,
			@Param("title") String title,
			@Param("content") String content,
			@Param("price") String price,
			@Param("imageUrl") String imageUrl);
}
