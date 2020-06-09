package com.jslhrd.controller;

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
import com.jslhrd.domain.PageVO;
import com.jslhrd.service.GuestService;
import com.jslhrd.util.PgIndex;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("Guest")
@AllArgsConstructor
public class GuestController {
	private static final Logger log = LoggerFactory.getLogger(GuestController.class);

	private GuestService service;

	@GetMapping("guest_list")
	public void guestList(Model model, @RequestParam(defaultValue = "1") int page) {
		log.info("guestList()...");
		String url="guest_list";
		int nowpage=page; // 현재페이지
		int maxlist=10;// 페이지당 자료수
		int totcount = service.guestCount();
		int totpage= (totcount+maxlist-1)/maxlist; // 총페이지
		if(totpage==0) { //총 페이지는 최소 1
			totpage=1;
		}
		if(nowpage<1) { //현재 페이지가 1보다 작을 때 현재페이지를 1로
			nowpage=1;
		}
		if(nowpage>totpage) { //현재 페이지가 총페이지보다 크면 마지막페이지를 현재페이지로
			nowpage=totpage;
		}
		int startpage = (nowpage-1)*maxlist+1; // 현재페이지 시작번호
		int endpage = nowpage*maxlist;
		int listcount = totcount-((nowpage-1)*maxlist);
		
		PageVO vo = new PageVO();
		vo.setStartpage(startpage);
		vo.setEndpage(endpage);
		
		model.addAttribute("list", service.guestList(vo));
		model.addAttribute("page",nowpage);
		model.addAttribute("totpage",totpage);
		model.addAttribute("listcount",listcount);
		
		model.addAttribute("listPage",PgIndex.pageList(nowpage, totpage, url, ""));
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
	public void guestView(@RequestParam("idx") int idx, @RequestParam("page") int page, Model model) {
		log.info("guestView().......");
		//service.guestHits(idx);// 조회수 증가
		GuestVO vo = service.guestSelect(idx);
		model.addAttribute("guest", vo);
		model.addAttribute("page", page);
	}
	
	@GetMapping("guestHits")
	public String guestReadCnt(@RequestParam("idx") int idx, @RequestParam("page") int page, 
			HttpServletRequest request, HttpServletResponse response) {
		log.info("guestHits().......");
		service.guestHits(idx, request, response);
		return "redirect:guest_view?idx="+idx+"&page="+page;
	}
	
}
