package com.sh.bootstart.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;

@Controller
//@RestController		// @Controller + @ResponseBody
@RequestMapping("/")
public class HomeController {

	@GetMapping("/home")
	@ResponseBody
	public List<Map<String, String>> home(String merong, String huk) {
		// view로 데이터를 보내고 싶다면 model에 담는당!
		
		System.out.print("merong:"+merong);
		System.out.print("huk:"+huk);
		
		List<Map<String, String>> myList = new ArrayList<>();
		
		Map<String, String> saram;
		for(int i=1; i<=4; i++) {
			saram = new HashMap<>();
			saram.put("이름", "길동"+i);
			saram.put("별명", "짱"+i);
			myList.add(saram);
		}
		
		// ajax 쓸 땐 model이 필요없음!
		// jsonview등의 라이브러리엔 필요하기도 함!(무시)
		//model.addAttribute("myName", myList);
		
		//response.getWriter().write("Hello");
		
		return myList;
	}
	
	/* JS 배열 -> List, JS {}는 Map으로 받는다 */
	@PostMapping("/myPost")
	@ResponseBody
	public String myPost(@RequestBody List<Map<String, String>> sh) {
		System.out.print("sh:"+sh);
		
		return "OK";
	}
	
	// put, delete는 근본적으로 post와 같음
	// 현실에 비유하면 모두가 깃발인데 색깔(의미)만 다른 것
	@PutMapping("/myPut")
	@ResponseBody
	public List<Map<String, String>> myPut(@RequestBody List<Map<String, String>> sh) {
		System.out.print("sh:"+sh);
		
		return sh;
	}
	
	
}
