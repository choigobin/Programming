package com.jslhrd.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jslhrd.domain.MemberVO;
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
	// 회원가입처리
	
	//로그인 폼
	@GetMapping("userlogin_form")
	public void userLogin() {
		log.info("userLogin().............");
	}
	
	//로그인 처리
	@PostMapping("userlogin_form")
	public String userLoginPro(MemberVO vo, Model model, HttpServletRequest request) {
		log.info("userLoginPro().............");
		String passwd = service.userIdSearch(vo);
		if(passwd==null) { // 아이디가 존재하지 않을 경우
			model.addAttribute("isRow", -1);
			return "/Member/userlogin_form";
		}else {
			if(passwd.equals(vo.getPasswd())) {
				//id,pass 동일
				service.lastTimeUpdate(vo);
				request.getSession().setAttribute("user", service.userLogin(vo));
				request.getSession().setMaxInactiveInterval(1800);
				
				return "/Member/userlogin_ok";
			}else {//비번오류
				model.addAttribute("isRow", 0);
				return "/Member/userlogin_form";
			}
		}
	}
	
	//로그아웃 처리
	@GetMapping("logout")
	public void userLogout(HttpServletRequest request) {
		log.info("userLogout().............");
		request.getSession().invalidate();
	}
	
	//회원정보수정
	@GetMapping("userinfo_modify")
	public void userModify() {
		log.info("userModify().............");
	}
}
