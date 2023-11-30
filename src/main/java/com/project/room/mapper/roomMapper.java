package com.project.room.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.project.room.domain.Room;

@Repository
public interface RoomMapper {
	//int userId, String userLoginId, String title, String content, String price, String homeAddress, String location, MultipartFile file
	public void insertRoom(
			@Param("userId") int userId,
			@Param("title") String title,
			@Param("content") String content,
			@Param("price") String price,
			@Param("homeAddress") String homeAddress,
			@Param("location") String location,
			@Param("imageUrl") String imageUrl);

	public Room selectPostByPostIdUserId(
			@Param("postId") int postId,
			@Param("userId") int userId);
}
