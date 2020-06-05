package com.jslhrd.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jslhrd.domain.GuestVO;
import com.jslhrd.service.GuestService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("Guest")
@AllArgsConstructor
public class GuestController {
	private static final Logger log = LoggerFactory.getLogger(GuestController.class);

	private GuestService service;

	@GetMapping("guest_list")
	public void guestList(Model model) {
		log.info("guestList()...");
		model.addAttribute("list", service.guestList());
	}

	// 글 등록폼
	@GetMapping("guest_write")
	public void guestWrite() {
		log.info("guestWrite()...");
	}

	// 등록 메시지 처리
	@PostMapping("guest_write")
	public String guestWritePro(GuestVO vo, RedirectAttributes rttr) {
		log.info("guestWritePro()...");
		int row = service.guestWrite(vo);
		rttr.addFlashAttribute("row", row);
		return "redirect:/Guest/guest_write_pro";
	}

	@GetMapping("guest_write_pro")
	public void guestWriteProJSP() {
		log.info("guestWriteProJSP()...");
	}

	// View 처리
	@GetMapping("guest_view")
	public void guestView(@RequestParam("idx") int idx, Model model) {
		log.info("guestView().......");
		//service.guestHits(idx);// 조회수 증가
		GuestVO vo = service.guestSelect(idx);
		model.addAttribute("guest", vo);
	}
	
	@GetMapping("guestHits")
	public String guestReadCnt(@RequestParam("idx") int idx, 
			HttpServletRequest request, HttpServletResponse response) {
		log.info("guestHits().......");
		service.guestHits(idx, request, response);
		return "redirect:guest_view?idx="+idx;
	}
	
}
