package com.jslhrd.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.jslhrd.domain.PageVO;
import com.jslhrd.domain.PdsVO;
import com.jslhrd.service.PdsService;
import com.jslhrd.util.PgIndex;
import com.jslhrd.util.SqlMark;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("Pds")
public class PdsController {
	private static final Logger log = LoggerFactory.getLogger(PdsController.class);
	
	private PdsService service;
	
	
	//전체 목록
	@GetMapping("pds_list")
	public void pdsList(@RequestParam("page") int page ,Model model, PageVO vo) {
		log.info("pdsList()......");
		String url="pds_list";
		
		int nowpage=1;// 시작페이지
		int maxlist=10; // 페이지당 자료수
		int totpage=1; //총페이지
		int totcount = 0;
		
		if(vo.getKey() == null) {
			totcount = service.pdsCount();//전체 카운트
		}else {
			totcount = service.pdsSearchCount(vo);//전체 카운트
		}
		
		// 총페이지수 계산
		if(totcount % maxlist ==0) {
			totpage=totcount/maxlist;
		}else {
			totpage=totcount/maxlist+1;
		}
		if(totpage==0) {
			totpage=1;
		}
		
		if(page !=0 ) {
			nowpage=page;
		}
		
		if(nowpage>totpage) {//현재 페이지가 총페이지보다 크면 마지막페이지를 현재페이지로
			nowpage=totpage;
		}
		int startpage = (nowpage-1)*maxlist+1;//현재 페이지시작번호
		int endpage = nowpage*maxlist;
		int listcount = totcount-((nowpage-1)*maxlist);
		
		//PageVO vo = new PageVO();
		vo.setStartpage(startpage);
		vo.setEndpage(endpage);
		
		if(vo.getKey() == null) {
			model.addAttribute("list", service.pdsList(vo));
		}else {
			model.addAttribute("list", service.pdsSearchList(vo));
		}
		
		model.addAttribute("page", nowpage);
		model.addAttribute("totpage", totpage);
		model.addAttribute("totcount", totcount);		
		model.addAttribute("listcount", listcount);
		
		if(vo.getKey() == null) {
			model.addAttribute("listPage", PgIndex.pageList(nowpage, totpage, url, ""));
		}else {
			model.addAttribute("listPage", PgIndex.pageListHan(nowpage, totpage, url,vo.getSearch(),vo.getKey()));
		}
	}
	
	@PostMapping("pds_list")
	public void pdsSearchList(@RequestParam("page") int page, PageVO vo, Model model) {
		log.info("PdsSearchList()......");
		String url="pds_list";
		
		int nowpage=1;// 시작페이지
		int maxlist=10; // 페이지당 자료수
		int totpage=1; //총페이지
		int totcount = service.pdsSearchCount(vo);//전체 카운트
		// 총페이지수 계산
		if(totcount % maxlist ==0) {
			totpage=totcount/maxlist;
		}else {
			totpage=totcount/maxlist+1;
		}
		if(totpage==0) {
			totpage=1;
		}
		
		if(page !=0 ) {
			nowpage=page;
		}
		
		if(nowpage>totpage) {//현재 페이지가 총페이지보다 크면 마지막페이지를 현재페이지로
			nowpage=totpage;
		}
		int startpage = (nowpage-1)*maxlist+1;//현재 페이지시작번호
		int endpage = nowpage*maxlist;
		int listcount = totcount-((nowpage-1)*maxlist);
		
		//PageVO vo = new PageVO();
		vo.setStartpage(startpage);
		vo.setEndpage(endpage);
		
		model.addAttribute("list", service.pdsSearchList(vo));
		model.addAttribute("page", nowpage);
		model.addAttribute("totcount", totcount);		
		model.addAttribute("totpage", totpage);
		model.addAttribute("listcount", listcount);
		
		//model.addAttribute("listPage", PgIndex.pageList(nowpage, totpage, url, ""));
		model.addAttribute("listPage", PgIndex.pageListHan(nowpage, totpage, url,vo.getSearch(),vo.getKey()));
	}
	
	//등록폼
	@GetMapping("pds_write")
	public void pdsWrite(@RequestParam("page") int page,Model model) {
		log.info("pdsWrite()....");
		model.addAttribute("page",page);
	}
	
	//등록처리
	@PostMapping("pds_write")
	//파일받기
	//	public String pdsWritePro(MultipartFile filename) { //파일만 받고 text는 못받음
	public String pdsWritePro(MultipartHttpServletRequest request) {
		log.info("pdsWrite()....");
		PdsVO vo = new PdsVO();//넘어오는객체 확인용
		vo.setName(request.getParameter("name"));
		vo.setEmail(request.getParameter("email"));
		vo.setPass(request.getParameter("pass"));
		vo.setSubject(request.getParameter("subject"));
		vo.setContents(request.getParameter("contents"));
		
		int page = Integer.parseInt(request.getParameter("page"));
		//String page = request.getParameter("page");	
	
		MultipartFile mf = request.getFile("filename");
//		File fileO = new File(UUID.randomUUID()+mf.getOriginalFilename());
//		try {
//			mf.transferTo(fileO);
//		} catch (IllegalStateException | IOException e1) {
//			e1.printStackTrace();
//		}
		//저장경로 설정
		String path = request.getRealPath("/resources/upload/");
		
		String fileName = UUID.randomUUID()+mf.getOriginalFilename();
		log.info("file name : " + fileName);
		
		File file = new File(path + fileName);
		log.info("file path : " + file);
		
		try {
			mf.transferTo(file); //파일의 실제 저장을 위한거
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		vo.setFilename(fileName);
		service.pdsWrite(vo);
		
		return "redirect:/Pds/pds_list?page="+page;
	}
	
	//뷰
	@GetMapping("pds_view")
	public void pdsView(@RequestParam("idx") int idx, @RequestParam("page") int page, Model model) {
		log.info("pdsView......");
		PdsVO vo = service.pdsView(idx);
		vo.setContents(SqlMark.lineBreak(vo.getContents()));
		model.addAttribute("pds",vo);
		model.addAttribute("page",page);
		model.addAttribute("idx",idx);
		
	}
	
	//특정게시물 조회수
	@GetMapping("pdsHits")
	public String pdsReadCnt(@RequestParam("idx") int idx,@RequestParam("page") int page, HttpServletRequest request, HttpServletResponse response) {
		service.pdsHits(idx, request, response);
		return "redirect:pds_view?idx="+ idx+"&page="+ page;
	}
	
	//수정
	@GetMapping("pds_modify")
	public void pds_modify(@RequestParam("idx") int idx, @RequestParam("page") int page ,Model model) {
		log.info("pds_modify....");
		PdsVO vo = service.pdsView(idx);
		model.addAttribute("pds", vo);
		model.addAttribute("page", page);
	}
	//수정처리
		@PostMapping("pds_modify")
		//파일받기
		//	public String pdsWritePro(MultipartFile filename) { //파일만 받고 text는 못받음
		public String pdsmodifyPro(MultipartHttpServletRequest request) {
			log.info("pdsModifyPro()....");
			PdsVO vo = new PdsVO();//넘어오는객체 확인용
			vo.setIdx(Integer.parseInt(request.getParameter("idx")));
			vo.setName(request.getParameter("name"));
			vo.setEmail(request.getParameter("email"));
			vo.setPass(request.getParameter("pass"));
			vo.setSubject(request.getParameter("subject"));
			vo.setContents(request.getParameter("contents"));
			log.info("getfile filename:   "+ request.getFile("filename").getName());

			PdsVO pwcheck = service.pdsView(vo.getIdx());
			log.info("pwcheck"+ pwcheck.getPass()+":"+vo.getPass());
			if(pwcheck.getPass().equals(vo.getPass())) {
				
			
			if(request.getFile("filename").getName().equals(request.getParameter("fileOrign")) || request.getFile("filename").getOriginalFilename().isEmpty()||request.getFile("filename").getOriginalFilename().contentEquals("")) {
			
				//파일교체 x
				vo.setFilename(request.getParameter("fileOrign"));
			}else {//파일교체 o
				File xx = new File(request.getRealPath("/resources/upload/")+request.getParameter("fileOrign"));//이거 인듯 path + 파일이름
				xx.delete();//이전 파일 삭제완료
				MultipartFile mf = request.getFile("filename");

				//저장경로 설정
				String path = request.getRealPath("/resources/upload/");
			
				String fileName = UUID.randomUUID()+mf.getOriginalFilename();
				log.info("file name : " + fileName);
				
				File file = new File(path + fileName);
				log.info("file path : " + file);
				
				try {
					mf.transferTo(file); //파일의 실제 저장을 위한거
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				vo.setFilename(fileName);
			}
			service.pdsModify(vo);//ㅋㅋㅋㅋ이부분 modify로 ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ
			}
			return "redirect:/Pds/pds_list?page=1";
		}
	
	//삭제
	@PostMapping("pds_delete")
	public String pds_delete(MultipartHttpServletRequest request,Model model) {
		PdsVO vo = new PdsVO();
		vo.setIdx(Integer.parseInt(request.getParameter("idx")));
		vo.setPass(request.getParameter("pass"));
		vo.setPath(request.getRealPath("/resources/upload/"));
		int row = service.pdsDelete(vo);
		model.addAttribute("row",row);
		log.info(""+row);
		return "redirect:pds_delete_pro";			
		
	}
	@GetMapping("pds_delete")
	public void pds_delete(@RequestParam("idx")int idx, Model model) {
		model.addAttribute("idx",idx);
	}
	
	@GetMapping("pds_delete_pro")
	public void pds_delete_pro(@RequestParam("row") int row, Model model) {
		model.addAttribute("row",row);
	}
	
	@GetMapping("pwcheck")
	@ResponseBody
	public PdsVO pwcheck(@RequestParam("pw") String pw, @RequestParam("idx") int idx) {
		log.info("pwchekc pw: "+pw);
		log.info("pwcheck idx: "+idx);
		PdsVO x = service.pdsView(idx);
		PdsVO y = new PdsVO();
		if(pw.equals(x.getPass())) {
			y.setIdx(1);
		}else {
			y.setIdx(0);
		}
		return y;
		
	}
}
