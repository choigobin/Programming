package com.jslhrd.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jslhrd.domain.SampleDTO;
import com.jslhrd.domain.TodoDTO;

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
	public String ex01(SampleDTO dto, @ModelAttribute("page") int page) {
		log.info("SampleDTO : " + dto);
		log.info("Page : " + page);
		
		return "ex01"; // 리턴 타입이 String 이면 view 를 기준으로 jsp 실행
	}
	
	@GetMapping("exRedirect")
	public String exRedirect(RedirectAttributes rttr) {
		rttr.addFlashAttribute("page", 10);
		log.info("rttr : " + rttr);
		
		return "redirect:/sample/ex01";
	}
	
	@GetMapping("ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		log.info("name: " + name);
		log.info("age: "+ age );
		return "page";
	}
	
	@GetMapping("ex02List")
	public String ex02List(@RequestParam("ids") List<String> list) {
		log.info("list : " + list);
		
		return "ex02List";
	}
	
	@GetMapping("ex02ArrayList")
	public String ex02List(@RequestParam("ids") ArrayList<String> alist) {
		log.info("alist : " + alist);
		
		return "ex02List";
	}
	
	@GetMapping("ex02String")
	public String ex02List(@RequestParam("ids") String[] str) {
		log.info("str : " + Arrays.toString(str));
		
		return "ex02List";
	}
	
	
	@InitBinder public void initBinder(WebDataBinder binder) { SimpleDateFormat
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false)); }
	 
	@GetMapping("ex03")
	public String ex03(TodoDTO dto) {
		log.info("TodoDTO : " + dto);
		
		return "sample/exSample"; // 리턴 타입이 String 이면 view 를 기준으로 jsp 실행
	}
	
	@GetMapping("exModel")
	public String ex04(Model model) {
		List<String> list = new ArrayList<String>();
		list.add("홍길동");
		list.add("이길동");
		list.add("강길동");
		list.add("박길동");
		list.add("우길동");
		
		model.addAttribute("list", list);
		
		log.info("list : " + list);
		log.info("model : " + model);
		
		return "exModel";
	}
	
	@GetMapping("ex05")
	public @ResponseBody SampleDTO ex05() {
		log.info("ex05()......");
		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("홍길동");
		
		return dto;
	}
	
	//등록폼
	@GetMapping("exUpload")
	public void exUpload() {
		log.info("exUpload()......");
	}
	
	//등록 처리
	@PostMapping("exUploadPro")
	public String exUploadPro(ArrayList<MultipartFile> files) {
		log.info("exUploadPro()......");
		
		files.forEach(file -> {
			log.info("---------------------------");
			log.info("name: " + file.getOriginalFilename());
			log.info("size: " + file.getSize());
		});
		
		return "test";
	}
	
	
}
