package com.project.room.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.project.room.domain.Room;

@Repository
public interface RoomMapper {
	
	public List<Room> selectRoomListByUserId(int userId);
	
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
