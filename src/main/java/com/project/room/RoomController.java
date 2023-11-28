package com.project.room;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/room")
public class RoomController {

	@GetMapping("/room-mine")
	public String mine(Model model) {
		model.addAttribute("mainSection", "room/roomMine");
		return "template/layout";
	}
	
}
