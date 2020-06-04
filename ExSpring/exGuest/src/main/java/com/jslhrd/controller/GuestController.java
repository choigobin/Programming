package com.jslhrd.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jslhrd.domain.GuestVO;
import com.jslhrd.service.GuestService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("Guest")
@AllArgsConstructor
public class GuestController {
	private static final Logger log =
			LoggerFactory.getLogger(GuestController.class);
	
	private GuestService service;
	
	@GetMapping("guest_list")
	public void guestList(Model model) {
		log.info("guestList()...");
		model.addAttribute("list",service.guestList());
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
}
