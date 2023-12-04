package com.project.post;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.post.bo.postBO;

@RequestMapping("/room")
@RestController
public class PostRestController {

	@Autowired
	private postBO postBO;
	/**
	 * 매물 올리기 API
	 * @param subject
	 * @param content
	 * @param price
	 * @param homeAddress
	 * @param location
	 * @param file
	 * @param session
	 * @return
	 */
	@PostMapping("/mine")
	public Map<String, Object> mine(
	        @RequestParam("subject") String subject,
	        @RequestParam("content") String content,
	        @RequestParam("price") String price,
	        @RequestParam("homeAddress") String homeAddress,
	        @RequestParam("location") String location,
	        @RequestParam(value = "file", required = false) MultipartFile file,
	        HttpSession session) {
		
		int userId = (int) session.getAttribute("userId");
	    String userLoginId = (String) session.getAttribute("userLoginId");
		
	    postBO.addRoom(userId, userLoginId, subject, content, price, homeAddress, location, file);
		
		//응답
		Map<String, Object>result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
	
		return result;
		
	}
	@PutMapping("/update")
	public Map<String, Object> update(
			@RequestParam("title")String title,
			@RequestParam("content")String content,
			@RequestParam(value = "file", required = false)MultipartFile file,
			@RequestParam("price")String price,
			HttpSession session){
		
		int userId = (int)session.getAttribute("userId"); // 일괄처리 비일괄인경우 integer로 해야된다
		String userLoginId = (String)session.getAttribute("userLoginId");
		
		// db update
			
		postBO.updatePost(userId, userLoginId, userId, title, content, file, price);
		
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		return result;// 응답값 jason으로 리턴
	}
}
