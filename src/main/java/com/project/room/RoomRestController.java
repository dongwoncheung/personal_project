package com.project.room;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.room.bo.RoomBO;

@RequestMapping("/room")
@RestController
public class RoomRestController {

	@Autowired
	private RoomBO roomBO;
	
	@PostMapping("/mine")
	public Map<String, Object>mine(
			@RequestParam("subject")String subject,
			@RequestParam("content")String content,
			@RequestParam("price")String price,
			@RequestParam("homeAddress")String homeAddress,
			@RequestParam("location")String location,
			@RequestParam(value = "file", required = false)MultipartFile file,
			HttpSession session){
		
		int userId = (int)session.getAttribute("userId");
		
		roomBO.addRoom(userId, location, subject, content, price, homeAddress, location, file);
		
		//응답
		Map<String, Object>result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
	
		return result;
	}
}
