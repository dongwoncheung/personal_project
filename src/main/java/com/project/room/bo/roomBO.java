package com.project.room.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.common.FileManagerService;
import com.project.room.domain.Room;
import com.project.room.mapper.RoomMapper;

@Service
public class RoomBO {

	@Autowired
	private RoomMapper roomMapper;
	
	@Autowired
	private FileManagerService fileManager;
	
	//게시글 업로드
	//in:controller에 있는 파라미터들
	//out:x
	public void addRoom(int userId, String userLoginId, String title, String content, String price, String homeAddress, String location, MultipartFile file) {
		String imagePath = null;
		if(file != null) {
			imagePath = fileManager.saveFile(userLoginId, file);
		}
		roomMapper.insertRoom(userId, title, content, price, homeAddress, location, imagePath);
	}
	
	//게시글 detail
	//in: postid, userid
	//out:post에 수정된것들 
	public  Room getPostByPostIdUserId(int postId, int userId) {
		return roomMapper.selectPostByPostIdUserId(postId, userId);
	}
}
