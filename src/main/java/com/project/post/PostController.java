package com.project.post;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.post.bo.postBO;
import com.project.post.domain.Post;
import com.project.post.domain.Post;

@Controller
@RequestMapping("/room")
public class PostController {


	@Autowired
	private postBO postBO;

	// 메인 페이지 접속
	@GetMapping("/main-page")
		public String mainPage(Model model, HttpSession session) {
			Integer userId = (Integer)session.getAttribute("userId");
			
			List<Post> postList = postBO.getPostListByUserId(userId);
			model.addAttribute("postList", postList);
			model.addAttribute("mainSection", "room/roomMainPage");
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


	// 글 수정 view 단계
	@GetMapping("/room-detail")
	public String roomDetail(@RequestParam("postId") int postId,
			HttpSession session, 
			Model model) {
		
		//로그인 된사람만 들어와서 가능하게
		int userId = (int)session.getAttribute("userId");
		
		//DB
		Post post = postBO.getPostByPostIdUserId(postId, userId);
		model.addAttribute("post", post);
		model.addAttribute("mainSection", "room/roomDetail");
		return"template/layout";
				
	}
	

	
}
