package com.jslhrd.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jslhrd.domain.SampleDTO;

@Controller
@RequestMapping("/sample/")
public class SampleController {
	private static final Logger log = 
			LoggerFactory.getLogger(SampleController.class);
	
	@RequestMapping("")
	public void basic() {
		log.info("basic() test ..... " );
	}
	
	@GetMapping("aaa")
	public void aaaGet() {
		log.info("aaaGet() test ..... " );
	}
	
	@PostMapping("aaa")
	public void aaaPost() {
		log.info("aaaPost() test ..... " );
	}
	
	@RequestMapping("aaa")
	public void aaaRequest() {
		log.info("aaaRequest() test ..... " );
	}
	
	@RequestMapping("board_list")
	public void board_list() {
		log.info("board_list() test ..... " );
		// 리턴 타입이 void 이면 맵핑된 폴더 기준으로 jsp 실행
	}
	
	@GetMapping("ex01")
	public String ex01(SampleDTO dto) {
		log.info("SampleDTO : " + dto);
		
		return "sample/ex01"; // 리턴 타입이 String 이면 view 를 기준으로 jsp 실행
	}
	
	@GetMapping("ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		log.info("name: " + name);
		log.info("age: "+ age );
		return "page";
	}
	
}
