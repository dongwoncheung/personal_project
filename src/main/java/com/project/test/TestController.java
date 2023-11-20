package com.project.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class TestController {
	

	@ResponseBody
	@GetMapping("/test1")
	public String test1() {
		return "hello world";
	}
	@ResponseBody
	@GetMapping("/test2")
		public Map<String, Object>test2(){
			Map<String, Object> map = new HashMap<>();
			map.put("a", 1);
			map.put("b", 200);
			return map;
		}
	@GetMapping("/test3")
	public String test3() {
		return"test/test";
	}

}
