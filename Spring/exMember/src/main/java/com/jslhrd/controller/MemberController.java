package com.jslhrd.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jslhrd.service.MemberService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/Member")
@AllArgsConstructor
public class MemberController {
	private static final Logger log =
			LoggerFactory.getLogger(MemberController.class);
	
	private MemberService service;
	
	@GetMapping("userinfo_list")
	public void memList(Model model) {
		log.info("memList().....");
		model.addAttribute("list", service.memList());
	}
	//회원가입폼
	@GetMapping("userinfo_insert")
	public void memInsert() {
		log.info("memInsert().....");
	}
	
}
