package com.project.room;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.room.bo.RoomBO;
import com.project.room.domain.Room;

@Controller
@RequestMapping("/room")
public class RoomController {


	@Autowired
	private RoomBO roomBO;

	
	@GetMapping("/main-page")
		public String mainPage(Model model, HttpSession session) {
			Integer userId = (Integer)session.getAttribute("userId");
			
			List<Room> roomList = roomBO.getRoomListByUserId(userId);
			model.addAttribute("roomList", roomList);
			model.addAttribute("viewName", "post/postList");
			return "template/layout";
			
			
		}
	
	/**글쓰기 화면
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/room-mine")
	public String mine(Model model) {
		model.addAttribute("mainSection", "room/roomMine");
		return "template/layout";
	}


	@GetMapping("/room-detail")
	public String roomDetail(@RequestParam("postId") int postId,
			HttpSession session, Model model) {
		
		//로그인 된사람만 들어와서 가능하게
		int userId = (int)session.getAttribute("userId");
		
		//DB
		Room room = roomBO.getPostByPostIdUserId(postId, userId);
		model.addAttribute("room", room);
		model.addAttribute("mainSection", "room/roomDetail");
		return"template/layout";
				
	}
	
}
