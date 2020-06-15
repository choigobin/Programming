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

import com.jslhrd.domain.BoardVO;
import com.jslhrd.domain.PageVO;
import com.jslhrd.service.BoardService;
import com.jslhrd.util.PageIndex;
import com.jslhrd.util.SqlMark;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("Board") // 폴더를 나타냄
@AllArgsConstructor // 자동생성자 생성
public class BoardController {

	private static final Logger log = LoggerFactory.getLogger(BoardController.class);

	private BoardService service;

	@GetMapping("board_list")
	public void boardList(@RequestParam("page") int page, PageVO vo, Model model) {

		log.info("boardList()....");
		String url = "board_list";

		int nowpage = 1; // 시작페이지
		int maxlist = 10; // 페이지당 최대 자료수
		int totpage = 1; // 총 페이지 개수

		int totcount = 0;
		if (vo.getKey() == null) {
			totcount = service.boardCount();
		} else {

			totcount = service.boardSearchCount(vo);
		}

		// 총페이지수 계산
		if (totcount % maxlist == 0) {
			totpage = totcount / maxlist;
		} else {
			totpage = totcount / maxlist + 1;
		}
		if (totpage == 0) {
			totpage = 1;
		}
		if (page != 0) {
			nowpage = page;
		}
		if (nowpage > totpage) { // 현재페이지가 총페이지보다크면 마지막페이지를 현제페이지로
			nowpage = totpage;
		}
		int startpage = (nowpage - 1) * maxlist + 1;// 현재 페이지 시작번호
		int endpage = nowpage * maxlist;
		int listcount = totcount - ((nowpage - 1) * maxlist);

		// PageVO vo = new PageVO();
		vo.setStartpage(startpage);
		vo.setEndpage(endpage);

		model.addAttribute("page", nowpage);
		model.addAttribute("totpage", totpage);
		model.addAttribute("listcount", listcount);
		model.addAttribute("totcount", totcount);

		if (vo.getKey() == null) {
			model.addAttribute("list", service.boardList(vo));

		} else {
			model.addAttribute("list", service.boardListSearch(vo));
		}

		if (vo.getKey() == null) {
			model.addAttribute("listpage", PageIndex.pageList(nowpage, totpage, url, ""));

		} else {
			model.addAttribute("listpage", PageIndex.pageListHan(nowpage, totpage, url, vo.getSearch(), vo.getKey()));
		}

	}

	@PostMapping("board_list")
	public void boardListSearch(@RequestParam("page") int page, PageVO vo, Model model) {
		
		
		log.info("boardListSearch()....");
		String url = "board_list";
		
		int nowpage = 1; // 시작페이지
		int maxlist = 10; // 페이지당 최대 자료수
		int totpage = 1; // 총 페이지 개수
		
		int totcount = service.boardSearchCount(vo);// 검색조건에맞는 게시물 갯수
	
		// 총페이지수 계산
		if (totcount % maxlist == 0) {
			totpage = totcount / maxlist;
		} else {
			totpage = totcount / maxlist + 1;
		}
		if (totpage == 0) {
			totpage = 1;
		}
		if (page != 0) {
			nowpage = page;
		}
		if (nowpage > totpage) { // 현재페이지가 총페이지보다크면 마지막페이지를 현제페이지로
			nowpage = totpage;
		}
		int startpage = (nowpage - 1) * maxlist + 1;// 현재 페이지 시작번호
		int endpage = nowpage * maxlist;
		int listcount = totcount - ((nowpage - 1) * maxlist);

		// PageVO vo = new PageVO();
		vo.setStartpage(startpage);
		vo.setEndpage(endpage);
		
		model.addAttribute("page", nowpage);
		model.addAttribute("totpage", totpage);
		model.addAttribute("listcount", listcount);
		model.addAttribute("list", service.boardListSearch(vo));
		model.addAttribute("totcount", totcount);
		// model.addAttribute("listpage", PageIndex.pageList(nowpage, totpage, url,
		// ""));
		
		model.addAttribute("listpage", PageIndex.pageListHan(nowpage, totpage, url, vo.getSearch(), vo.getKey()));
		
	}

	// 글 등록 폼
	@GetMapping("board_write")
	public void guestWrite(@RequestParam("page") int page, Model model) {

		model.addAttribute("page", page);
		log.info("board_write().....");
	}

	/*
	 * //글 등록 처리
	 * 
	 * @PostMapping("guest_write") public String guestWritePro(GuestVO vo) {
	 * 
	 * log.info("guestWritePro()......"); int row = service.guestWrite(vo);
	 * 
	 * return "redirect:/Guest/guest_list"; }
	 * 
	 */

	// 등록 처리 메시지 확인후 리스트로 이동
	@PostMapping("board_write")
	public String boardWritePro(BoardVO vo, RedirectAttributes rttr, @RequestParam("page") int page) {

		log.info("boardWritePro().....");
		int row = service.boardWrite(vo);
		rttr.addFlashAttribute("row", row);
		return "redirect:/Board/board_write_pro?page=" + page;
	}

	@GetMapping("board_write_pro")
	public void boardWriteProJSP(@RequestParam("page") int page, Model model) {

		model.addAttribute("page", page);
		log.info("boardWriteProJSP()....");
	}

	// 뷰 처리
	@GetMapping("board_view")
	public void guestView(@RequestParam("idx") int idx, @RequestParam("page") int page, Model model) {
		log.info("boardView().....");
		// service.guestHits(idx); //조회수 증가
		BoardVO vo = service.boardSelect(idx);
		vo.setContents(SqlMark.lineBreak(vo.getContents())); // 라인 줄생기기
		model.addAttribute("board", vo);
		model.addAttribute("page", page);

	}
	/*
	 * //쿠키생성 확인후 뷰쪽으로 이동
	 * 
	 * @GetMapping("guestHits") public String guestReadCnt(@RequestParam("idx") int
	 * idx, HttpServletRequest request, HttpServletResponse response) {
	 * 
	 * boolean bool = false; Cookie info = null; Cookie[] cookies =
	 * request.getCookies(); for (int i = 0; i < cookies.length; i++) { info =
	 * cookies[i]; if (info.getName().equals("guestCookie" + idx)) { bool = true;
	 * break; } } String str = "" + System.currentTimeMillis(); if (!bool) { info =
	 * new Cookie("guestCookie" + idx, str); response.addCookie(info);
	 * service.guestHits(idx); } return "redirect:guest_view?idx="+idx; }
	 * 
	 */

	@GetMapping("boardHits")
	public String guestReadCnt(@RequestParam("idx") int idx, @RequestParam("page") int page, HttpServletRequest request,
			HttpServletResponse response) {

		service.boardHits(idx, request, response);

		return "redirect:board_view?idx=" + idx + "&page=" + page;
	}

	@GetMapping("board_modify")
	public void boardmodify(@RequestParam("idx") int idx,@RequestParam("page") int page, Model model) {

		BoardVO vo = service.boardSelect(idx);
		model.addAttribute("board", vo);
		model.addAttribute("page", page);
		log.info("board_modify().....");
	}

	@PostMapping("board_modify")
	public String boardmodifyPro(@RequestParam("page") int page,BoardVO vo, RedirectAttributes rttr) {

		log.info("boardModifyPro().....");
		int row = service.boardModify(vo);
		rttr.addFlashAttribute("row", row);
		return "redirect:board_modify_pro?page="+page+"&idx="+vo.getIdx();
	}

	@GetMapping("board_modify_pro")
	public void boardModifyProJSP(BoardVO vo,@RequestParam("page") int page, Model model) {
		
		model.addAttribute("idx", vo.getIdx());
		model.addAttribute("page", page);
		log.info("boardModifyProJSP()....");
	}

	@GetMapping("board_delete")
	public void boardDelete(@RequestParam("idx") int idx, @RequestParam("page") int page, Model model) {

		model.addAttribute("page", page);
		model.addAttribute("idx", idx);
		log.info("board_delete().....");
	}

	@PostMapping("board_delete")
	public String boardDeletePro(BoardVO vo, @RequestParam("page") int page, RedirectAttributes rttr) {

		log.info("boardDeletePro()....");
		int row = service.boardDelete(vo);
		rttr.addFlashAttribute("row", row);     
		
		return "redirect:/Board/board_delete_pro?page="+page;

	}

	@GetMapping("board_delete_pro")
	public void boardDeleteProJSP(@RequestParam("page") int page,Model model) {
		model.addAttribute("page",page);
		log.info("boarddeleteProJSP()....");
	}

}
