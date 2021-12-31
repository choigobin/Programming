package com.jslhrd.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jslhrd.domain.AttVO;
import com.jslhrd.domain.BoardVO;
import com.jslhrd.domain.CommentVO;
import com.jslhrd.domain.ILLJUNGVO;
import com.jslhrd.domain.MailVO;
import com.jslhrd.domain.MajorVO;
import com.jslhrd.domain.NoticeVO;
import com.jslhrd.domain.PageVO;
import com.jslhrd.domain.ProClassVO;
import com.jslhrd.domain.ProfessorVO;
import com.jslhrd.domain.StudentVO;
import com.jslhrd.domain.SubListVO;
import com.jslhrd.domain.Subject2VO;
import com.jslhrd.domain.SubjectVO;
import com.jslhrd.domain.ZipVO;
import com.jslhrd.service.TurkeyService;
import com.jslhrd.util.PageIndex;
import com.jslhrd.util.SqlMark;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequestMapping("/Turkey")
@AllArgsConstructor
@Log4j
@Controller
public class TurkeyController {
	
	private TurkeyService service;

	/*최문환------------------------------------------------------------------------------------------------------------------------------------------*/
	@GetMapping("main")
	public String main(Model model,HttpServletRequest request) {
		log.info("*******main()*******");
		
		HttpSession session = request.getSession();
		StudentVO stu_vo = null;
		ProfessorVO pro_vo = null;
		int mail_count = 0;
		
		List<SubjectVO> list2 = null;
		List<Subject2VO> list3 = null;
		
		if((StudentVO) session.getAttribute("stu_vo") != null) {
			stu_vo = (StudentVO) session.getAttribute("stu_vo");
			mail_count = service.mail_count(stu_vo.getStu_code());
			list2 = service.stuSubMain(stu_vo);
		}else if((ProfessorVO) session.getAttribute("pro_vo") != null) {
			pro_vo = (ProfessorVO) session.getAttribute("pro_vo");
			mail_count = service.mail_count(pro_vo.getPro_code());
			list3 = service.proSubMain(pro_vo);
			log.info(list3);
		}
		
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyyMMdd");
		SimpleDateFormat format2 = new SimpleDateFormat ( "yyyy년MM월dd일");
		Date time = new Date();					
		String time1 = format1.format(time);
		String time2 = format2.format(time);
		List<ILLJUNGVO> vo = service.IlljungSelect(time1);
		model.addAttribute("time", time2);
		model.addAttribute("list", vo);
		
		List<BoardVO> free_board_list = service.main_freeboard_list();
		List<NoticeVO> notice_board_list = service.main_noticeboard_list();
		
		
		List<MajorVO> major_list = service.majorList();
		
		
		model.addAttribute("major_list",major_list);
		model.addAttribute("mail_count",mail_count);
		model.addAttribute("list2", list2);				// 메인에 학생시간표 띄우기
		model.addAttribute("list3", list3);				// 메인에 교수시간표 띄우기
		model.addAttribute("free_board_list",free_board_list);
		model.addAttribute("notice_board_list",notice_board_list);

		log.info(service.stuSubMain(stu_vo));
		
		return "/main";
	}
	
	@PostMapping("main_1")
	public String main_1(Model model, HttpServletRequest request) {
		log.info("*******main()*******");

		HttpSession session = request.getSession();
		StudentVO stu_vo = null;
		ProfessorVO pro_vo = null;
		int mail_count = 0;

		List<SubjectVO> list2 = null;
		List<Subject2VO> list3 = null;

		if ((StudentVO) session.getAttribute("stu_vo") != null) {
			stu_vo = (StudentVO) session.getAttribute("stu_vo");
			mail_count = service.mail_count(stu_vo.getStu_code());
			list2 = service.stuSubMain(stu_vo);
		} else if ((ProfessorVO) session.getAttribute("pro_vo") != null) {
			pro_vo = (ProfessorVO) session.getAttribute("pro_vo");
			mail_count = service.mail_count(pro_vo.getPro_code());
			list3 = service.proSubMain(pro_vo);
			log.info(list3);
		}

		String day = request.getParameter("schedule_2");	
		
		String time2 = day.substring(0,4)+"년"+day.substring(4,6)+"월"+day.substring(6)+"일";
		List<ILLJUNGVO> vo = service.IlljungSelect(day);
		
		model.addAttribute("time1", day);
		model.addAttribute("time", time2);
		model.addAttribute("list", vo);
		
		List<BoardVO> free_board_list = service.main_freeboard_list();
		List<NoticeVO> notice_board_list = service.main_noticeboard_list();

		List<MajorVO> major_list = service.majorList();

		model.addAttribute("major_list", major_list);
		model.addAttribute("mail_count", mail_count);
		model.addAttribute("list2", list2);
		model.addAttribute("list3", list3);
		model.addAttribute("free_board_list",free_board_list);
		model.addAttribute("notice_board_list",notice_board_list);

		log.info(service.stuSubMain(stu_vo));

		return "/main";
	}

	@GetMapping("stu_login")
	public String stuLoginGet() {
		log.info("*******stuLoginGet()*******");
		return "/student/student_login";
	}
	
	@PostMapping("stu_login")
	public String stuLoginPost(StudentVO vo, Model model,HttpServletRequest request,HttpServletResponse response) {
		log.info("*******stuLoginPost()*******");
		request.getSession().invalidate();
		String pass = service.stuIdSearch(vo);
		
		StudentVO stu_vo = null;
		
		if(pass==null) {
			//아이디 없음
			model.addAttribute("isRow",-1);
			log.info("isRow : -1");
			return "/student/student_login";
		}else {
			if(pass.equals(vo.getStu_pw())) {
				stu_vo =  service.stuLogin(vo);
				String major_name = service.getMajorName(stu_vo.getMajor_code());
				stu_vo.setMajor_name(major_name);
				request.getSession().setAttribute("stu_vo", stu_vo);
				request.getSession().setMaxInactiveInterval(1800); //세션 유지 시간 설정
				log.info("isRow : 성공");
				return "redirect:/Turkey/main";
			}else {
				//비밀번호 틀림
				model.addAttribute("isRow",0);
				log.info("isRow : 0");
				return "/student/student_login";
			}
		}
		
	}
	
	@GetMapping("pro_login")
	public String proLoginGet() {
		log.info("*******proLoginGet()*******");
		return "/professor/professor_login";
	}
	
	@PostMapping("pro_login")
	public String proLoginPost(ProfessorVO vo, Model model,HttpServletRequest request,HttpServletResponse response) {
		log.info("*******proLoginPost()*******");
		request.getSession().invalidate();
		String pass = service.proIdSearch(vo);
		ProfessorVO pro_vo = null;
		
		if(pass==null) {
			//아이디 없음
			model.addAttribute("isRow",-1);
			log.info("isRow : -1");
			return "/professor/professor_login";
		}else {
			if(pass.equals(vo.getPro_pw())) {
				pro_vo =  service.proLogin(vo);
				String major_name = service.getMajorName(pro_vo.getMajor_code());
				pro_vo.setMajor_name(major_name);
				request.getSession().setAttribute("pro_vo", pro_vo);
				request.getSession().setMaxInactiveInterval(1800); //세션 유지 시간 설정
				log.info("isRow : 성공");
				return "redirect:/Turkey/main";
			}else {
				//비밀번호 틀림
				model.addAttribute("isRow",0);
				log.info("isRow : 0");
				return "/professor/professor_login";
			}
		}
		
	}
	
	@GetMapping("logout")
	   public String logout(HttpServletRequest request) {
	      log.info("*******userLogout()*******");
	      request.getSession().invalidate();
	      
	      return "/student/student_login";
	}
	
	@GetMapping("major_insert")
	public String majorInsertGet() {
		log.info("*******majorInsertGet()*******");
			
		return "admin/admin_major_insert";
	}
	
	@PostMapping("major_insert")
	public String majorInsertPost(MajorVO vo) {
		log.info("*******majorInsertPost()*******");
		service.majorInsert(vo);
		return "admin/admin_major_insert";
	}

	@GetMapping("major_list")
	public String mjaorListGet(Model model) {
		log.info("*******mjaorListGet()*******");
		List<MajorVO> major_list = service.majorList();
		
			
		model.addAttribute("major_list",major_list);
			
			
		return"admin/admin_major_list";
	}
		
	@GetMapping("subject_insert")
	public String subjectInsertGet(Model model) {
		log.info("*******subjectInsertGet()*******");
		List<MajorVO> major_list = service.majorList();
			
		model.addAttribute("major_list",major_list);
			
		return "admin/admin_sub_insert";
	}
		
	@PostMapping("subject_insert")
	public String subjectInsertPost(Model model,SubjectVO vo) {
		log.info("*******subjectInsertPost()*******");
		service.subInsert(vo);
		List<MajorVO> major_list = service.majorList();
			
		model.addAttribute("major_list",major_list);
		return "admin/admin_sub_insert";
	}
		
	@GetMapping("subject_list")
	public String subjectListGet(Model model) {
		log.info("*******subjectListGet()*******");
		
		List<MajorVO> major_list = service.majorList();
		
		model.addAttribute("major_list",major_list);
			
		return "admin/admin_sub_list";
	}
		
	@PostMapping("subject_list")
	public String subejctListPost(Model model,SubjectVO vo) {
		log.info("*******subejctListPost()*******");
			
		List<MajorVO> major_list = service.majorList();
		List<SubjectVO> sub_list = service.subList(vo);
			
		model.addAttribute("major_list",major_list);
		model.addAttribute("sub_list",sub_list);
			
		return "admin/admin_sub_list";
	}

	@GetMapping("subject2_insert")
	public String sujbect2InsertGet(SubjectVO vo,Model model) {
		log.info("*******sujbect2InsertGet()*******");
		SubjectVO sub_vo = service.subjectOne(vo);
		model.addAttribute("sub_vo",sub_vo);
			
		return "admin/admin_sub2_insert";
	}
	
	@PostMapping("subject2_insert")
	public String sujbect2InsertPost(Model model,Subject2VO vo) {
		log.info("*******sujbect2InsertPost()*******");
		service.sub2Insert(vo);
			
		return "redirect:/Turkey/subject_list";
	}

	@GetMapping("subject2_list")
	public String subject2ListGet(Model model) {
		log.info("*******subject2ListGet()*******");
			
		List<MajorVO> major_list = service.majorList();
		model.addAttribute("major_list",major_list);
			
		return "admin/admin_sub2_list";
	}
		
	@PostMapping("subject2_list")
	public String subject2ListPost(Subject2VO vo,Model model) {
		log.info("*******subject2ListPost()*******");

		List<MajorVO> major_list = service.majorList();
		model.addAttribute("major_list",major_list);
			
		List<Subject2VO> sub2_list = service.sub2List(vo);
		model.addAttribute("sub2_list",sub2_list);
			
		return"admin/admin_sub2_list";
	}
		
	@GetMapping("student_apply")
	public String studentApplyGet(Model model) {
		log.info("*******studentApplyGet()*******");
		      
		List<MajorVO> major_list = service.majorList();
		model.addAttribute("major_list",major_list);
		      
		return"/student/student_apply";
	}
	
	@PostMapping("student_apply")
	public String studentApplyPost(Subject2VO vo,Model model) {
		log.info("*******studentApplyPost()*******");
		      
		List<MajorVO> major_list = service.majorList();
		model.addAttribute("major_list",major_list);
		      
		List<Subject2VO> sub2_list = service.sub2List(vo);
		model.addAttribute("sub2_list",sub2_list);
		model.addAttribute("year",vo.getYear());
		model.addAttribute("semester",vo.getSemester());
		model.addAttribute("major_code",vo.getMajor_code());
		      
		return"/student/student_apply";
	}
		   
	@GetMapping("student_apply_do")
	public String studentApplyDo(Subject2VO vo,@Param("stu_code")String stu_code,Model model) {
		log.info("*******studentApplyDo()*******");
		log.info("stu_code = "+stu_code);
		   
		Subject2VO sub2VO = service.findSubjectInfo(vo);
		log.info(sub2VO);
		sub2VO.setStu_code(stu_code);
		   
		SubListVO subCheck = service.subListCheck(sub2VO);
		if(subCheck == null) {

			service.applyDo(sub2VO);
			service.inwonUP(sub2VO);
	
			if(sub2VO.getTime_b() != null) {
				AttVO attVO = new AttVO();
				attVO.setStu_code(sub2VO.getStu_code());
				attVO.setSub_code(sub2VO.getSub_code());
				attVO.setMajor_code(sub2VO.getMajor_code());
				attVO.setPro_code(sub2VO.getPro_code());
				attVO.setYear(sub2VO.getYear());
				attVO.setSemester(sub2VO.getSemester());
				attVO.setAtt_time(sub2VO.getTime_a());
				
				service.insertATT(attVO);
	
				attVO.setAtt_time(sub2VO.getTime_b());
				service.insertATT(attVO);
			}else {
				AttVO attVO = new AttVO();
				attVO.setStu_code(sub2VO.getStu_code());
				attVO.setSub_code(sub2VO.getSub_code());
				attVO.setMajor_code(sub2VO.getMajor_code());
				attVO.setPro_code(sub2VO.getPro_code());
				attVO.setYear(sub2VO.getYear());
				attVO.setSemester(sub2VO.getSemester());
				attVO.setAtt_time(sub2VO.getTime_a());
				service.insertATT(attVO); 
			}
		   
				List<MajorVO> major_list = service.majorList();
				model.addAttribute("major_list",major_list);
				     
				List<Subject2VO> sub2_list = service.sub2List(vo);
				model.addAttribute("sub2_list",sub2_list);
				      
				      
				model.addAttribute("year",sub2VO.getYear());
				model.addAttribute("semester",sub2VO.getSemester());
				model.addAttribute("major_code",vo.getMajor_code());
				   
				model.addAttribute("alert", "alert('수강신청이 완료되었습니다.')");
			
			}else {
				List<MajorVO> major_list = service.majorList();
				model.addAttribute("major_list",major_list);
			      
				List<Subject2VO> sub2_list = service.sub2List(vo);
				model.addAttribute("sub2_list",sub2_list);
			   
				model.addAttribute("year",sub2VO.getYear());
				model.addAttribute("semester",sub2VO.getSemester());
				model.addAttribute("alert", "alert('이미 수강신청이 되었습니다.')");
			}   
		   
		return "/student/student_apply";
		      
		}

	@GetMapping("list_mail")
	public String listMail(HttpServletRequest request,Model model) {
		log.info("*******listMail()*******");
			
		StudentVO stu_vo = null;
		ProfessorVO pro_vo = null;
		List<MailVO> mail_list = null;
		
		HttpSession session = request.getSession();
			
		if((StudentVO) session.getAttribute("stu_vo") != null) {
			stu_vo = (StudentVO) session.getAttribute("stu_vo");
			mail_list = service.listMail(stu_vo.getStu_code());
		}else if((ProfessorVO) session.getAttribute("pro_vo") != null) {
			pro_vo = (ProfessorVO) session.getAttribute("pro_vo");
			mail_list = service.listMail(pro_vo.getPro_code());
		}
			
		model.addAttribute("mail_list",mail_list);
		
		return"/mail/list_mail";
	}

	@GetMapping("send_mail")
	public String sendMailGet() {
		log.info("*******sendMailGet()*******");
			
		return"/mail/send_mail";
	}

	@PostMapping("re_check")
	public String re_check(MailVO vo,Model model) {
		log.info("*******re_check()*******");
			
		String reception = vo.getReception();
		int row = 0;
			
		if(reception.length() == 5) {
			ProfessorVO proVO = service.proCodeCheck(reception);
			if(proVO != null) {
				row = 1;
			}else {
				row = 0;
			}
		}else if(reception.length() == 8){
			StudentVO stuVO = service.stuCodeCheck(reception);
			if(stuVO != null) {
				row = 1;
			}else {
				row = 0;
			}
		}
		
		model.addAttribute("row",row);
		model.addAttribute("reception",reception);
			
		return"/mail/send_mail";
	}

	@PostMapping("send_mail")
	public String sendMailPost(MailVO vo,HttpServletRequest request) {
		log.info("*******sendMailPost()*******");
			
		HttpSession session = request.getSession();
		StudentVO stu_vo = null;
		ProfessorVO pro_vo = null;
			
		if((StudentVO) session.getAttribute("stu_vo") != null) {
			stu_vo = (StudentVO) session.getAttribute("stu_vo");
			vo.setSending(stu_vo.getStu_code());
			vo.setSending_name(stu_vo.getStu_name());
		}else if((ProfessorVO) session.getAttribute("pro_vo") != null) {
			pro_vo = (ProfessorVO) session.getAttribute("pro_vo");
			vo.setSending(pro_vo.getPro_code());
			vo.setSending_name(pro_vo.getPro_name());
		}
			
		service.sendMail(vo);
			
		return"redirect:/Turkey/list_mail";
	}

	@GetMapping("list_send_mail")
	public String listSendMail(HttpServletRequest request,Model model) {
		log.info("*******listSendMail()*******");
			
		StudentVO stu_vo = null;
		ProfessorVO pro_vo = null;
		List<MailVO> send_mail_list = null;
			
		HttpSession session = request.getSession();
			
		if((StudentVO) session.getAttribute("stu_vo") != null) {
			stu_vo = (StudentVO) session.getAttribute("stu_vo");
			send_mail_list = service.sendMailList(stu_vo.getStu_code());
		}else if((ProfessorVO) session.getAttribute("pro_vo") != null) {
			pro_vo = (ProfessorVO) session.getAttribute("pro_vo");
			send_mail_list = service.sendMailList(pro_vo.getPro_code());
		}
			
		model.addAttribute("send_mail_list",send_mail_list);
			
		return"/mail/list_send_mail";
	}

	@GetMapping("view_mail")
	public String viewMail(@RequestParam("idx")int idx,Model model) {
		log.info("*******view_mail()*******");
			
		MailVO vo = service.viewMail(idx);;
		service.mail_check(idx);
			
		model.addAttribute("mailVO",vo);
		return"/mail/view_mail";
	}
		
	@GetMapping("post_check")
	public String post_check_get() {
		log.info("*******post_check_get()*******");
			
		return "/admin/admin_stu_insert_post";
	}
	
	@PostMapping("post_check")
	public String post_check_post(@RequestParam("addr") String addr,Model model) {
		log.info("*******post_check_post()*******");
		log.info("입력한 주소 : " + addr);
		List<ZipVO> post_list = service.zipCodeList(addr);
		model.addAttribute("post_list",post_list);
		log.info(post_list);
		return"/admin/admin_stu_insert_post";
	}
	   
	@GetMapping("illjung_insert")
	public String illjungInsertGet() {
		log.info("*******illjungInsertGet()*******");
		   
		return"/admin/admin_illjung_insert";
	}
	 
	@PostMapping("illjung_insert")
	public String illjungInsertPost(ILLJUNGVO vo) {
		log.info("*******illjungInsertPost()*******");
		service.illjung_insert(vo);
		return"/admin/admin_illjung_insert";
	}

	@GetMapping("illjung_delete")
	public String illjungDelete(@RequestParam("idx")int idx) {
		log.info("*******illjungDelete()*******");
		service.illjung_delete(idx);
		return"redirect:/Turkey/illjung_list";
	}
	
	@GetMapping("illjung_list")
	public String illjungListGet(Model model) {
		log.info("*******illjungListGet()*******");
		List<ILLJUNGVO> ill_list = service.illjung_list();
		model.addAttribute("ill_list",ill_list);
		return"/admin/admin_illjung_list";
	}
	
	@PostMapping("illjung_list")
	public String illjungListPost(@RequestParam("year")String year,Model model) {
		log.info("*******illjungListPost()*******");
		List<ILLJUNGVO> ill_list = service.illjung_list_year(year);
		
		model.addAttribute("ill_list",ill_list);
		return"/admin/admin_illjung_list";
	}
	

	@GetMapping("illjung_list2")
	public String illjungList2Get(Model model,HttpServletRequest request) {
		log.info("*******illjungListGet()*******");
		
		StudentVO stu_vo = null;
		ProfessorVO pro_vo = null;
		HttpSession session = request.getSession();
		
		List<ILLJUNGVO> ill_list = service.illjung_list();
		
		model.addAttribute("ill_list",ill_list);

		if((StudentVO) session.getAttribute("stu_vo") != null) {
			stu_vo = (StudentVO) session.getAttribute("stu_vo");
			return"/student/student_illjung_list";
		}else{
			pro_vo = (ProfessorVO) session.getAttribute("pro_vo");
			return"/professor/professor_illjung_list";
		}
	}
	
	   
	@PostMapping("illjung_list2")
	 
	public String illjungLis2tPost(@RequestParam("year")String year,Model model,HttpServletRequest request) {
	
		log.info("*******illjungListPost()*******");

		StudentVO stu_vo = null;
		ProfessorVO pro_vo = null;
		HttpSession session = request.getSession();
		
		List<ILLJUNGVO> ill_list = service.illjung_list_year(year);
		
		model.addAttribute("ill_list",ill_list);
		if((StudentVO) session.getAttribute("stu_vo") != null) {
			stu_vo = (StudentVO) session.getAttribute("stu_vo");
			return"/student/student_illjung_list";
		}else{
			pro_vo = (ProfessorVO) session.getAttribute("pro_vo");
			return"/professor/professor_illjung_list";
		}
	}
	
	
	
	/*노주리------------------------------------------------------------------------------------------------------------------------------------------*/
	@GetMapping("notice_list")
	public String noticeList(Model model, PageVO vo, @RequestParam("page") int page) {
		log.info("*******noticeList()*******");
		
		String url="notice_list";
		
		int nowpage = 1;
		int maxlist = 15;
		int totpage = 1;
		int totcount = 0;
		
		if(vo.getKey() == null) {
			totcount = service.noticeCount();
		}else {
			totcount = service.noticeSearchCount(vo);
		}
		
		if(totcount % maxlist == 0) {
			totpage = totcount/maxlist;
		}else {
			totpage = (totcount/maxlist)+1;
		}
		
		if(totpage == 0) {
			totpage=1;
		}
		
		if(page != 0) {
			nowpage = page;
		}
		
		if(nowpage>totpage) {
			nowpage=totpage;
		}
		
		int startpage = (nowpage-1)*maxlist+1;
		int endpage = nowpage*maxlist;
		int listcount = totcount-((nowpage-1)*maxlist);
		
		vo.setStartpage(startpage);
		vo.setEndpage(endpage);
		
		
		if(vo.getKey() == null) {
			model.addAttribute("list",service.noticeList(vo));
		}else {
			model.addAttribute("list",service.noticeSearchList(vo));
		}
		
		model.addAttribute("page",nowpage);
		model.addAttribute("totpage",totpage);
		model.addAttribute("totcount",totcount);
		model.addAttribute("listcount",listcount);
		
		if(vo.getKey() == null) {
			model.addAttribute("pagelist" , PageIndex.pageList(nowpage, totpage, url, ""));
		}else {
			model.addAttribute("pagelist" , PageIndex.pageListHan(nowpage, totpage, url, vo.getSearch(),vo.getKey()));
		}
		
		return "/notice/notice_list";
	}
	
	@PostMapping("notice_list")
	public String noticeSearchList(Model model, PageVO vo, @RequestParam("page") int page) {
		log.info("*******noticeSearchList()*******");
		
		String url="notice_list";
		
		int nowpage = 1;
		int maxlist = 15;
		int totpage = 1;
		int totcount = service.noticeSearchCount(vo);
		
		if(totcount % maxlist == 0) {
			totpage = totcount/maxlist;
		}else {
			totpage = (totcount/maxlist)+1;
		}
		
		if(totpage == 0) {
			totpage=1;
		}
		
		if(page != 0) {
			nowpage = page;
		}
		
		if(nowpage>totpage) {
			nowpage=totpage;
		}
		
		int startpage = (nowpage-1)*maxlist+1;
		int endpage = nowpage*maxlist;
		int listcount = totcount-((nowpage-1)*maxlist);
		
		vo.setStartpage(startpage);
		vo.setEndpage(endpage);
		
		model.addAttribute("list", service.noticeSearchList(vo));
		model.addAttribute("page",nowpage);
		model.addAttribute("totpage",totpage);
		model.addAttribute("totcount",totcount);
		model.addAttribute("listcount",listcount);
		model.addAttribute("pagelist" , PageIndex.pageListHan(nowpage, totpage, url, vo.getSearch(), vo.getKey()));
		
		return "/notice/notice_list";
	}
	
	@GetMapping("notice_insert")
	public String noticeInsert(@RequestParam("page") int page, Model model) {
		log.info("*******noticeInsertGet()*******");
		model.addAttribute("page",page);
		return "/notice/notice_insert";
	}
	
	@PostMapping("notice_insert_pro")
	public String noticeInsert(MultipartHttpServletRequest request) {
		log.info("*******noticeInsertPost()*******");
		
		int page = Integer.parseInt(request.getParameter("page"));
		
		NoticeVO vo = new NoticeVO();
		vo.setTitle(request.getParameter("title"));
		vo.setContents(request.getParameter("contents"));
		
		MultipartFile mf = request.getFile("filename");
		String path = request.getRealPath("/resources/upload/");
		
		String filename = UUID.randomUUID()+mf.getOriginalFilename();
		log.info("file name : " + filename);
		
		File file = new File(path + filename);
		log.info("file path : " + file);
		
		try {
			mf.transferTo(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		vo.setFilename(filename);
		vo.setOri_filename(mf.getOriginalFilename());
		log.info("ori_filename : " + mf.getOriginalFilename());
		service.noticeInsert(vo);
		
		return "redirect:/Turkey/notice_list?page=" + page;
	}
	
	@GetMapping("notice_readcnt")
	public String noticeReadcnt(PageVO vo,@RequestParam("page") int page, @RequestParam("idx") int idx, HttpServletRequest request, HttpServletResponse response) {
		log.info("*******noticeReadcnt()*******");
		 
		if(vo.getKey() == "") {
			log.info("1");
			service.noticeReadcnt(idx, request, response);
			return "redirect:/Turkey/notice_view?idx=" + idx + "&page=" + page + "&search=" + vo.getSearch() + "&key=" + vo.getKey();
		}else {
			log.info("2");
			service.noticeReadcnt(idx, request, response);
			return "redirect:/Turkey/notice_view?idx=" + idx + "&page=" + page + "&search=" + vo.getSearch() + "&key=" + vo.getKey();
		}
	}
	 
	@GetMapping("notice_view")
	public String noticeView(@RequestParam("search") String search, @RequestParam("key") String key, @RequestParam("idx") int idx,Model model,@RequestParam("page") int page) {
		log.info("*******noticeView()*******");
		 
		log.info("key = " + key);
		log.info("search = " + search);
		 
		NoticeVO vo = service.noticeSelect(idx);//idx에 해당하는 글 가져오기
		vo.setContents(SqlMark.lineBreak(vo.getContents()));
		 
		model.addAttribute("notice",vo);
		model.addAttribute("page",page);
		model.addAttribute("search",search);
		model.addAttribute("key",key);
		 
		return "/notice/notice_view";
	}
	 
	@GetMapping("notice_modify")
	public String noticeModify(@RequestParam("idx") int idx, @RequestParam("page") int page ,Model model) {
		log.info("*******noticeModify()Get*******");
		 
		NoticeVO vo = service.noticeSelect(idx);
		
		model.addAttribute("notice", vo);
		model.addAttribute("page", page);
		
		return "/notice/notice_modify";
	}
	 
	@PostMapping("notice_modify")
	public String noticeModify(MultipartHttpServletRequest request) {
		log.info("*******noticeModify()Post*******");
			
		NoticeVO vo = new NoticeVO();

		vo.setIdx(Integer.parseInt(request.getParameter("idx")));
		vo.setTitle(request.getParameter("title"));
		vo.setContents(request.getParameter("contents"));
		
		if(request.getFile("filename").getName().equals(request.getParameter("file_old")) || request.getFile("filename").getOriginalFilename().isEmpty() || request.getFile("filename").getOriginalFilename().contentEquals("")) {
			vo.setFilename(request.getParameter("file_old"));
			vo.setOri_filename(request.getParameter("ori_file_old"));
		}else {
			File newf = new File(request.getRealPath("/resources/upload/") + request.getParameter("file_old"));
			newf.delete();
			MultipartFile mf = request.getFile("filename");
			 
			String path = request.getRealPath("/resources/upload/");
			
			String filename = UUID.randomUUID()+mf.getOriginalFilename();
			log.info("file name : " + filename);

			File file = new File(path + filename);
			log.info("file path : " + file);

			try {
				mf.transferTo(file);
			}catch (Exception e) {
				e.printStackTrace();
			}
			 
			vo.setFilename(filename);
			vo.setOri_filename(mf.getOriginalFilename());
		}
			
		service.noticeModify(vo);
		
		return "redirect:/Turkey/notice_list?page=1";
	}
	 
	@GetMapping("notice_delete")
	public String noticeDelete(@RequestParam("idx") int idx, @RequestParam("page") int page) {
		service.noticeDelete(idx);
		return "redirect:/Turkey/notice_list?page=" + page;
	}

	@GetMapping("board_list")
	public String boardList(Model model, PageVO vo, @RequestParam("page") int page) {
		log.info("*******boardList()*******");
		
		String url="board_list";
		
		int nowpage = 1;
		int maxlist = 15;
		int totpage = 1;
		int totcount = 0;
		
		if(vo.getKey() == null) {
			totcount = service.boardCount();
		}else {
			totcount = service.boardSearchCount(vo);
		}
		
		if(totcount % maxlist == 0) {
			totpage = totcount/maxlist;
		}else {
			totpage = (totcount/maxlist)+1;
		}
		
		if(totpage == 0) {
			totpage=1;
		}
		
		if(page != 0) {
			nowpage = page;
		}
		
		if(nowpage>totpage) {
			nowpage=totpage;
		}
		
		int startpage = (nowpage-1)*maxlist+1;
		int endpage = nowpage*maxlist;
		int listcount = totcount-((nowpage-1)*maxlist);
		
		vo.setStartpage(startpage);
		vo.setEndpage(endpage);
		
		
		if(vo.getKey() == null) {
			model.addAttribute("list",service.boardList(vo));
		}else {
			model.addAttribute("list",service.boardSearchList(vo));
		}
		
		model.addAttribute("page",nowpage);
		model.addAttribute("totpage",totpage);
		model.addAttribute("totcount",totcount);
		model.addAttribute("listcount",listcount);
		
		if(vo.getKey() == null) {
			model.addAttribute("pagelist" , PageIndex.pageList(nowpage, totpage, url, ""));
		}else {
			model.addAttribute("pagelist" , PageIndex.pageListHan(nowpage, totpage, url, vo.getSearch(),vo.getKey()));
		}
		
		return "/board/board_list";
	}
	
	@PostMapping("board_list")
	public String boardSearchList(Model model, PageVO vo, @RequestParam("page") int page) {
		log.info("*******boardSearchList()*******");
		
		String url="board_list";
		
		int nowpage = 1;
		int maxlist = 15;
		int totpage = 1;
		int totcount = service.boardSearchCount(vo);
		
		if(totcount % maxlist == 0) {
			totpage = totcount/maxlist;
		}else {
			totpage = (totcount/maxlist)+1;
		}
		
		if(totpage == 0) {
			totpage=1;
		}
		
		if(page != 0) {
			nowpage = page;
		}
		
		if(nowpage>totpage) {
			nowpage=totpage;
		}
		
		int startpage = (nowpage-1)*maxlist+1;
		int endpage = nowpage*maxlist;
		int listcount = totcount-((nowpage-1)*maxlist);
		
		vo.setStartpage(startpage);
		vo.setEndpage(endpage);
		
		model.addAttribute("list", service.boardSearchList(vo));
		model.addAttribute("page",nowpage);
		model.addAttribute("totpage",totpage);
		model.addAttribute("totcount",totcount);
		model.addAttribute("listcount",listcount);
		model.addAttribute("pagelist" , PageIndex.pageListHan(nowpage, totpage, url, vo.getSearch(), vo.getKey()));
		
		return "/board/board_list";
	}
	
	@GetMapping("board_write")
	public String boardWrite(@RequestParam("page") int page, Model model) {
		log.info("*******boardWriteGet()*******");
		model.addAttribute("page",page);
		return "/board/board_write";
	}
	
	@PostMapping("board_write_pro")
	public String boardWrite(HttpServletRequest request) {
		log.info("*******boardWritePost()*******");
		
		int page = Integer.parseInt(request.getParameter("page"));
		
		BoardVO vo = new BoardVO();
		vo.setStu_code(Integer.parseInt(request.getParameter("stu_code")));
		vo.setTitle(request.getParameter("title"));
		vo.setContents(request.getParameter("contents"));

		service.boardWrite(vo);
		
		return "redirect:/Turkey/board_list?page=" + page;
	}
	
	@GetMapping("board_readcnt")
	public String boardReadcnt(PageVO vo, @RequestParam("page") int page, @RequestParam("idx") int idx, HttpServletRequest request, HttpServletResponse response) {
		log.info("*******boardReadcnt()*******");
		 
		if(vo.getKey() == "") {
			log.info("1");
			service.boardReadcnt(idx, request, response);
			return "redirect:/Turkey/board_view?idx=" + idx + "&page=" + page + "&search=" + vo.getSearch() + "&key=" + vo.getKey();
		}else {
			log.info("2");
			service.boardReadcnt(idx, request, response);
			return "redirect:/Turkey/board_view?idx=" + idx + "&page=" + page + "&search=" + vo.getSearch() + "&key=" + vo.getKey();
		}
	}
	
	@GetMapping("board_view")
	public String boardView(@RequestParam("search") String search, @RequestParam("key") String key, @RequestParam("idx") int idx, Model model, @RequestParam("page") int page) {
		log.info("*******boardView()*******");
		 
		log.info("key = " + key);
		log.info("search = " + search);
		 
		BoardVO vo = service.boardSelect(idx);//idx에 해당하는 글 가져오기
		vo.setContents(SqlMark.lineBreak(vo.getContents()));
		 
		model.addAttribute("board",vo);
		model.addAttribute("page",page);
		model.addAttribute("search",search);
		model.addAttribute("key",key);
		
		model.addAttribute("list", service.commentList(idx));
		
		
		return "/board/board_view";
	}
	
	@GetMapping("board_modify")
	public String boardModify(@RequestParam("idx") int idx, @RequestParam("page") int page, Model model) {
		log.info("*******boardModify()Get*******");
		 
		BoardVO vo = service.boardSelect(idx);
		 
		model.addAttribute("board", vo);
		model.addAttribute("page", page);
		 
		return "/board/board_modify";
	}
	 
	@PostMapping("board_modify")
	public String boardModify(HttpServletRequest request) {
		log.info("*******boardModify()Post*******");
			
		BoardVO vo = new BoardVO();//넘어오는객체 확인용

		vo.setIdx(Integer.parseInt(request.getParameter("idx")));
		vo.setTitle(request.getParameter("title"));
		vo.setContents(request.getParameter("contents"));
		
		service.boardModify(vo);
		
		return "redirect:/Turkey/board_list?page=1";
	}
	 
	@GetMapping("board_delete")
	public String boardDelete(@RequestParam("idx") int idx, @RequestParam("page") int page) {
		service.boardDelete(idx);
		return "redirect:/Turkey/board_list?page=" + page;
	}
	
	@PostMapping("comment_write")
	public String commentWrite(HttpServletRequest request) {
		log.info("*******commentWrite()*******");
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		String search = request.getParameter("search");
		String key = request.getParameter("key");
		
		CommentVO vo = new CommentVO();
		vo.setIdx(idx);
		vo.setStu_code(Integer.parseInt(request.getParameter("stu_code")));
		vo.setComments(request.getParameter("comments"));

		service.commentWrite(vo);
		
		return "redirect:/Turkey/board_readcnt?idx=" + idx + "&page=" + page + "&search=" + search + "&key=" + key;
	}

	@GetMapping("comment_delete")
	public String commentDelete(HttpServletRequest request) {
		log.info("*******commentDelete()*******");
		   
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		String search = request.getParameter("search");
		String key = request.getParameter("key");
			
		int c_idx = Integer.parseInt(request.getParameter("c_idx"));
			
		  service.commentDelete(c_idx);
		   
		  return "redirect:/Turkey/board_readcnt?idx=" + idx + "&page=" + page + "&search=" + search + "&key=" + key;
	}
	   
	@GetMapping("comment_modify")
	public String commentModify(@RequestParam("c_idx") int c_idx, Model model, HttpServletRequest request) {
		log.info("*******commentModify()Get*******");
			 
		CommentVO vo = service.commentSelect(c_idx);
			 
		model.addAttribute("comment", vo);
			
		if(request.getParameter("check_num") != null) {
			model.addAttribute("check_num", 1);
		}
			
		return "/board/comment_modify";
	}
		 
	@PostMapping("comment_modify")
	public String commentModify(HttpServletRequest request) {
		log.info("*******commentModify()Post*******");
			
		CommentVO vo = new CommentVO();//넘어오는객체 확인용

		vo.setC_idx(Integer.parseInt(request.getParameter("c_idx")));
		vo.setComments(request.getParameter("comments"));
			
		service.commentModify(vo);
			
		return "redirect:/Turkey/comment_modify?c_idx=" + request.getParameter("c_idx") + "&check_num=1";
	}
	
	@GetMapping("stu_find_code")
	public String stuFindCode() {
		log.info("*******stuFindCodeGet*******");
	    return "/student/student_find_code";
	}
	   
	@PostMapping("stu_find_code")
	public String stuFindCode(StudentVO vo, Model model) {
	      
	   log.info("*******stuFindCodePost*******");
	      
	   StudentVO find_stu = service.find_code(vo);
	     
	   if(find_stu == null) {
	      model.addAttribute("isRow", 0);
	      return"/student/student_find_code";
	   }else {
		  model.addAttribute("isRow", 1);
	      model.addAttribute("vo", find_stu);
	      return"/student/student_find_code";
	      }
	}
	   
	@GetMapping("stu_find_pass")
	public String stuFindPass() {
	   log.info("*******stuFindPassGet*******");
	   return "/student/student_find_pass";
	}
	   
	@PostMapping("stu_find_pass")
	public String stuFindPass(StudentVO vo, Model model) {
	      
	   log.info("*******stuFindPassPost*******");
	      
	   StudentVO find_stu = service.find_pass(vo);
	      
	   if(find_stu == null) {
		   model.addAttribute("isRow", -1);
	       return"/student/student_find_pass";
	   }else {
		   model.addAttribute("isRow", 0);
	       model.addAttribute("vo", find_stu);
	       return"/student/student_find_pass";
	   }
	}
	   
	@PostMapping("stu_up_pass")
	public String stuUpdatePass(StudentVO vo, Model model, @RequestParam ("stu_code") String stu_code) {
	   log.info("*******stuUpdatePassPost*******");
	      
	   vo.setStu_code(stu_code);
	      
	   service.updatePass(vo);
	      
	   model.addAttribute("isRow", 1);
	      
	   return"/student/student_find_pass";
	}
	
	/*박준배------------------------------------------------------------------------------------------------------------------------------------------*/
	@GetMapping("admin_stu_insert")
	public String StuInsert(Model model, MajorVO vo) { 
		model.addAttribute("list", service.MajorView(vo));
		return "/admin/admin_stu_insert"; 
	}
	
	@PostMapping("admin_stu_insert")
	public String StuInsert(MultipartHttpServletRequest request) {
		log.info("\n*******stuInsert()*******");
		StudentVO vo = new StudentVO();
		vo.setStu_code(request.getParameter("stu_code"));	
		vo.setPro_code(request.getParameter("pro_code"));	
		log.info("file name : " + Integer.parseInt(request.getParameter("stu_code")));
		vo.setMajor_code(request.getParameter("major_code"));
		vo.setStu_name(request.getParameter("stu_name"));
		vo.setStu_sex(request.getParameter("stu_sex"));
		vo.setStu_addr(request.getParameter("stu_addr"));
		vo.setStu_zip(request.getParameter("stu_zip"));
		if(request.getParameter("email_3").equals("0"))
		{
			String email = request.getParameter("email_1")+"@"+request.getParameter("email_2");
			vo.setStu_email(email);				
		}
		else
		{
			String email = request.getParameter("email_1")+"@"+request.getParameter("email_3");
			vo.setStu_email(email);
		}			
		vo.setStu_birth(Integer.parseInt(request.getParameter("stu_birth")));			
		vo.setStu_pw(request.getParameter("stu_birth")); // 초기 비밀번호는 생년월일
		String stu_phone = request.getParameter("tel_1")+"-"+request.getParameter("tel_2")+"-"+request.getParameter("tel_3");
		vo.setStu_phone(stu_phone);
		vo.setStu_nt(request.getParameter("stu_nt"));
		vo.setStu_eng(request.getParameter("stu_eng"));
		vo.setStu_level(Integer.parseInt(request.getParameter("stu_level")));
		vo.setStu_condition(request.getParameter("stu_condition"));
			
		MultipartFile mf = request.getFile("filename");			
		String path = request.getSession().getServletContext().getRealPath("");	// 절대 경로 구하는 메소드
		
		int idx1 = path.indexOf(".metadata"); 		// 절대 경로 자르기
		int idx2 = path.indexOf("TurkeyProject"); 	// ()안에는 프로젝트명 적기 이거 틀리면 이미지 제대로 저장 안됨
	    String path2 = path.substring(0, idx1);
	    String path3 = path.substring(idx2);
	       
	    String test = path2+path3+"src\\main\\webapp\\resources\\stu_img\\";	// path3 뒤로는 내부 경로 // 이미지는 내부 경로에 있어야 간단하게 불러오기 가능	        	       
	        
	    String test3 = "../../resources/stu_img"; // db에 들어가는 경로 // 이미지 불러올 때 사용함
	    log.info("경로 "+  test);
		File dir = new File(test);	// test 경로 없을시 폴더 만듦
		if (!dir.exists()){
			dir.mkdirs();
		}			 
		String code = request.getParameter("stu_code");	// 식별 위해 파일명 앞에 학생 코드 추가			
		String filename = code+"_"+mf.getOriginalFilename(); 
		String fileFullPath = test+"/"+filename;
		String img = test3+"/"+filename;
		try {mf.transferTo(new File(fileFullPath));}
		catch (Exception e) {e.printStackTrace();}			
		vo.setStu_img(img);			
		service.stdinsert(vo);
			
		return "redirect:admin_stu_insert";
	}
	
	@GetMapping("admin_pro_insert")
	public String ProInsert(Model model, MajorVO vo) { 
		model.addAttribute("list", service.MajorView(vo));
		return "/admin/admin_pro_insert"; 
	}
	
	@PostMapping("admin_pro_insert")
	public String ProInsert(MultipartHttpServletRequest request) {
		log.info("\n*******ProInsert()*******");
		ProfessorVO vo = new ProfessorVO();		
			
		vo.setPro_code(request.getParameter("pro_code"));
		vo.setPro_name(request.getParameter("pro_name"));			
		vo.setPro_birth(Integer.parseInt(request.getParameter("pro_birth")));			
		vo.setPro_pw(request.getParameter("pro_birth")); // 초기 비밀번호는 생년월일
		vo.setPro_sex(request.getParameter("pro_sex"));
		vo.setMajor_code(request.getParameter("major_code"));
		String pro_phone = request.getParameter("tel_1")+"-"+request.getParameter("tel_2")+"-"+request.getParameter("tel_3");
		vo.setPro_phone(pro_phone);
		vo.setPro_nt(request.getParameter("pro_nt"));
		vo.setPro_eng(request.getParameter("pro_eng"));			
		vo.setPro_grade(Integer.parseInt(request.getParameter("pro_grade")));
			
		if(request.getParameter("email_3").equals("0"))
		{
			String email = request.getParameter("email_1")+"@"+request.getParameter("email_2");
			vo.setPro_email(email);				
		}
		else
		{
			String email = request.getParameter("email_1")+"@"+request.getParameter("email_3");
			vo.setPro_email(email);
		}
		
		MultipartFile mf = request.getFile("filename");			
		String path = request.getSession().getServletContext().getRealPath("");	// 절대 경로 구하는 메소드
		int idx1 = path.indexOf(".metadata"); 		// 절대 경로 자르기
		int idx2 = path.indexOf("TurkeyProject"); 	// ()안에는 프로젝트명 적기 이거 틀리면 이미지 제대로 저장 안됨
	    String path2 = path.substring(0, idx1);
	    String path3 = path.substring(idx2);
	        
	    String test = path2+path3+"src\\main\\webapp\\resources\\pro_img\\";	// path3 뒤로는 내부 경로 // 이미지는 내부 경로에 있어야 간단하게 불러오기 가능	        	       
	        
	    String test3 = "../../resources/pro_img"; // db에 들어가는 경로 // 이미지 불러올 때 사용함
	        
		File dir = new File(test);	// 위 경로 없을시 폴더 만듦
		if (!dir.exists())
		{
			dir.mkdirs();
		}			 
		String code = request.getParameter("pro_code");	// 식별 위해 파일명 앞에 교수 코드 추가
		String filename = code+"_"+mf.getOriginalFilename(); 
		String fileFullPath = test+"/"+filename;
		String img = test3+"/"+filename;
		try {mf.transferTo(new File(fileFullPath));}
		catch (Exception e) {e.printStackTrace();}					
		vo.setPro_img(img);
						
		service.proinsert(vo);
			
		return "redirect:admin_pro_insert";
	}

	@GetMapping("admin_stu_view")
	public String StuView(Model model, MajorVO vo,StudentVO vo1) {		

		model.addAttribute("list", service.MajorView(vo));
		model.addAttribute("list1", service.StuSelect(vo1));
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("major", "0");
		map.put("grade", "0");
		map.put("condition", "0");
		model.addAttribute("map", map);
		
		return "/admin/admin_stu_view";
	}
	
	@PostMapping("admin_stu_view2")
	public String StuView(Model model, MajorVO vo,StudentVO vo1,  MultipartHttpServletRequest request) {		
			
		String major = request.getParameter("major");
		String grade = request.getParameter("grade");
		String condition = request.getParameter("condition");

		Map<String, String> map = new HashMap<String, String>();
		map.put("major", major);
		map.put("grade", grade);
		map.put("condition", condition);
		model.addAttribute("map", map);
		model.addAttribute("list", service.MajorView(vo));
		model.addAttribute("list1", service.StuSelect(vo1));
		
		return "/admin/admin_stu_view";
	}
	
	@GetMapping("admin_stu_modi")
	public String StuAdModi(Model model, MajorVO vo,@RequestParam("stu_code") int stu_code) {		

		StudentVO vo1 = service.StuAdModi(stu_code);
		int sex = Integer.parseInt(vo1.getStu_sex());
		if(sex==0)
		{
			model.addAttribute("man", "checked");			
		}
		else
		{
			model.addAttribute("woman", "checked");
		}

		model.addAttribute("list", service.MajorView(vo));
		model.addAttribute("stu", vo1);

		
		return "/admin/admin_stu_modify";
	}
	
	@PostMapping("admin_stu_modi")
	public String StuAdModi(MultipartHttpServletRequest request) {
		
		StudentVO vo = new StudentVO();
		vo.setStu_code(request.getParameter("stu_code"));	
		vo.setPro_code(request.getParameter("pro_code"));	
		log.info("file name : " + Integer.parseInt(request.getParameter("stu_code")));
		vo.setMajor_code(request.getParameter("major_code"));
		vo.setStu_name(request.getParameter("stu_name"));
		vo.setStu_sex(request.getParameter("stu_sex"));
		if(request.getParameter("email_3").equals("0"))
		{
			String email = request.getParameter("email_1")+"@"+request.getParameter("email_2");
			vo.setStu_email(email);				
		}
		else
		{
			String email = request.getParameter("email_1")+"@"+request.getParameter("email_3");
			vo.setStu_email(email);
		}
		vo.setStu_birth(Integer.parseInt(request.getParameter("stu_birth")));
		String stu_phone = request.getParameter("tel_1")+"-"+request.getParameter("tel_2")+"-"+request.getParameter("tel_3");
		vo.setStu_phone(stu_phone);
		vo.setStu_nt(request.getParameter("stu_nt"));
		vo.setStu_eng(request.getParameter("stu_eng"));
		vo.setStu_level(Integer.parseInt(request.getParameter("stu_level")));
		vo.setStu_condition(request.getParameter("stu_condition"));
		vo.setStu_addr(request.getParameter("stu_addr"));
		vo.setStu_zip(request.getParameter("stu_zip"));
		
		MultipartFile mf = request.getFile("filename");			
		String path = request.getSession().getServletContext().getRealPath("");	// 절대 경로 구하는 메소드
		int idx1 = path.indexOf(".metadata"); 		// 절대 경로 자르기
		int idx2 = path.indexOf("TurkeyProject"); 	// ()안에는 프로젝트명 적기 이거 틀리면 이미지 제대로 저장 안됨
	    String path2 = path.substring(0, idx1);
	    String path3 = path.substring(idx2);
	      
	    String test = path2+path3+"src\\main\\webapp\\resources\\stu_img\\";	// path3 뒤로는 내부 경로 // 이미지는 내부 경로에 있어야 간단하게 불러오기 가능	        	       
	       
	    String test3 = "../../resources/stu_img"; // db에 들어가는 경로 // 이미지 불러올 때 사용함
	        
		File dir = new File(test);	// 위 경로 없을시 폴더 만듦
		if (!dir.exists())
		{
			dir.mkdirs();
		}			 
		String code = request.getParameter("stu_code");	// 식별 위해 파일명 앞에 학생 코드 추가			
		String filename = code+"_"+mf.getOriginalFilename(); 
		String fileFullPath = test+"/"+filename;
		String img = test3+"/"+filename;
		    
		try {mf.transferTo(new File(fileFullPath));}
		catch (Exception e) {e.printStackTrace();}
		if(img.contains(".jpg")||img.contains(".JPG"))	//  이미지 재등록시 전에 있던 파일 삭제
		   {
			StudentVO stu = service.StuAdModi(Integer.parseInt(code));
			String del = stu.getStu_img();
			int del2 = del.indexOf(code);
			String del3 = del.substring(del2);
			File file = new File(test+del3);
			file.delete();
			vo.setStu_img(img);
		   }
		else
		{
			StudentVO stu = service.StuAdModi(Integer.parseInt(code));
			vo.setStu_img(stu.getStu_img());
		}	
				
		service.StuAdModify(vo);
		
		return "redirect:admin_stu_view";
	}
	
	@GetMapping("admin_pro_view")
	public String ProView(Model model, MajorVO vo,ProfessorVO vo1) {		

		model.addAttribute("list", service.MajorView(vo));
		model.addAttribute("list1", service.ProSelect(vo1));
		
		return "/admin/admin_pro_view";
	}
	
	@PostMapping("admin_pro_view2")
	public String ProView(Model model, MajorVO vo, ProfessorVO vo2, MultipartHttpServletRequest request) {		

		model.addAttribute("list", service.MajorView(vo));			

		String major = request.getParameter("major");
		Map<String, String> map = new HashMap<String, String>();
		map.put("major", major);		
		model.addAttribute("map", map);
				
		if(major.equals("0"))
		{
			
			model.addAttribute("list1", service.ProSelect(vo2));
			return "/admin/admin_pro_view";
		}
		else
		{			
			List<ProfessorVO> vo1 = service.ProSelectSearch(major);
			model.addAttribute("list1", vo1);
			return "/admin/admin_pro_view";
		}					
	}	
	
	@GetMapping("admin_pro_modi")
	public String PtuAdModi(Model model, MajorVO vo,@RequestParam("pro_code") int pro_code) {		

		ProfessorVO vo1 = service.ProAdModi(pro_code);
		int sex = Integer.parseInt(vo1.getPro_sex());
		if(sex==0)
		{
			model.addAttribute("man", "checked");			
		}
		else
		{
			model.addAttribute("woman", "checked");
		}
		
		model.addAttribute("list", service.MajorView(vo));
		model.addAttribute("pro", vo1);
		
		
		return "/admin/admin_pro_modify";
	}
	
	@PostMapping("admin_pro_modi")
	public String ProAdModi(MultipartHttpServletRequest request) {
		log.info("\n*******ProInsert()*******");
		ProfessorVO vo = new ProfessorVO();		
			
		vo.setPro_code(request.getParameter("pro_code"));
		vo.setPro_name(request.getParameter("pro_name"));			
		vo.setPro_birth(Integer.parseInt(request.getParameter("pro_birth")));			
		vo.setPro_sex(request.getParameter("pro_sex"));
		vo.setMajor_code(request.getParameter("major_code"));
		String pro_phone = request.getParameter("tel_1")+"-"+request.getParameter("tel_2")+"-"+request.getParameter("tel_3");
		vo.setPro_phone(pro_phone);
		vo.setPro_nt(request.getParameter("pro_nt"));
		vo.setPro_eng(request.getParameter("pro_eng"));
		vo.setPro_grade(Integer.parseInt(request.getParameter("pro_grade")));
		
		if(request.getParameter("email_3").equals("0"))
		{
			String email = request.getParameter("email_1")+"@"+request.getParameter("email_2");
			vo.setPro_email(email);				
		}
		else
		{
			String email = request.getParameter("email_1")+"@"+request.getParameter("email_3");
			vo.setPro_email(email);
		}
		
		MultipartFile mf = request.getFile("filename");			
		String path = request.getSession().getServletContext().getRealPath("");	// 절대 경로 구하는 메소드
		int idx1 = path.indexOf(".metadata"); 		// 절대 경로 자르기
		int idx2 = path.indexOf("TurkeyProject"); 	// ()안에는 프로젝트명 적기 이거 틀리면 이미지 제대로 저장 안됨
	    String path2 = path.substring(0, idx1);
	    String path3 = path.substring(idx2);
	        
	    String test = path2+path3+"src\\main\\webapp\\resources\\pro_img\\";	// path3 뒤로는 내부 경로 // 이미지는 내부 경로에 있어야 간단하게 불러오기 가능	        	       
	        
	    String test3 = "../../resources/pro_img"; // db에 들어가는 경로 // 이미지 불러올 때 사용함
	        
		File dir = new File(test);	// 위 경로 없을시 폴더 만듦
		if (!dir.exists())
		{
			dir.mkdirs();
		}			 
		String code = request.getParameter("pro_code");	// 식별 위해 파일명 앞에 교수 코드 추가
		String filename = code+"_"+mf.getOriginalFilename(); 
		String fileFullPath = test+"/"+filename;
		String img = test3+"/"+filename;			    
		try {mf.transferTo(new File(fileFullPath));}
		catch (Exception e) {e.printStackTrace();}
		if(img.contains(".jpg")||img.contains(".JPG"))	//  이미지 재등록시 전에 있던 파일 삭제)
		{
			ProfessorVO pro = service.ProAdModi(Integer.parseInt(code));
			String del = pro.getPro_img();
			int del2 = del.indexOf(code);
			String del3 = del.substring(del2);
			File file = new File(test+del3);
			file.delete();
			vo.setPro_img(img);
		}
		else
		{
			ProfessorVO pro = service.ProAdModi(Integer.parseInt(code));
			vo.setPro_img(pro.getPro_img());
		}	
		service.ProAdModify(vo);
		
		return "redirect:admin_pro_view";
	}

	@GetMapping("pro_pass")
	public String ProModifyPass(Model model,HttpSession session,HttpServletRequest request) {

		session = request.getSession(true);
		ProfessorVO vo = (ProfessorVO) session.getAttribute("pro_vo");
		ProfessorVO vo2 = service.ProAdModi(Integer.parseInt(vo.getPro_code()));
		model.addAttribute("pro", vo2);

		return "/professor/professor_pass";
	}
	
	@PostMapping("pro_modi_pass")
	public String student_modifyPassword(HttpSession session,HttpServletRequest request,MultipartHttpServletRequest request2) {
			
		session = request.getSession(true);
		ProfessorVO vo = (ProfessorVO) session.getAttribute("pro_vo");
		ProfessorVO vo3 = new ProfessorVO();
		vo3.setPro_code(vo.getPro_code());
		vo3.setPro_pw(request2.getParameter("pro_pw"));
		service.ProModiPass(vo3);
	
		return "redirect:pro_view";
	}
	
	@GetMapping("pro_view")
	public String pro_view(HttpSession session,Model model, HttpServletRequest request,HttpServletResponse response) {

		session = request.getSession(true);
		ProfessorVO vo2 = (ProfessorVO) session.getAttribute("pro_vo");   
		ProfessorVO vo3 = service.ProAdModi(Integer.parseInt(vo2.getPro_code()));
		model.addAttribute("pro", vo3);

		return "/professor/professor_view";
	}
	
	@PostMapping("pro_view")
	public String ProMoify(MultipartHttpServletRequest request) {

		ProfessorVO vo = new ProfessorVO();
	      
		vo.setPro_code(request.getParameter("pro_code"));
		String pro_phone = request.getParameter("tel_1")+"-"+request.getParameter("tel_2")+"-"+request.getParameter("tel_3");
		vo.setPro_phone(pro_phone);
		if(request.getParameter("email_3").equals("0"))
		{
			String email = request.getParameter("email_1")+"@"+request.getParameter("email_2");
			vo.setPro_email(email);            
		}
		else
		{
			String email = request.getParameter("email_1")+"@"+request.getParameter("email_3");
			vo.setPro_email(email);
		}
		
		service.ProModify(vo);
	      
		return "redirect:pro_view";
	}
	
	/*최강민------------------------------------------------------------------------------------------------------------------------------------------*/
	@GetMapping("pro_main")
	public String proMainGet() {
		log.info("*******proMainGet()*******");
		return "/main";
	}
	
	@GetMapping("pro_class")
	public String proClassGet() {
		log.info("*******proClassGet()*******");
		return "/professor/professor_class";
	}
	
	@ResponseBody
	@RequestMapping(value="/pro_classSe", method=RequestMethod.POST)
	public List<ProClassVO> proClassSearch(@RequestBody Map<String, Integer> map,HttpServletRequest request){
		ProfessorVO pvo = (ProfessorVO) request.getSession().getAttribute("pro_vo");
		log.info("*******proClassSearch*******");
		ProClassVO vo = new ProClassVO();
		vo.setPro_code(pvo.getPro_code());
		vo.setYear(map.get("year"));
		vo.setSemester(map.get("semester"));
		List<ProClassVO> list = service.proClassSearch(vo);
		return list;
	}
	
	@GetMapping("pro_att")
	public String proAttGet(Model model,HttpServletRequest request,
			@RequestParam(value = "time") String time, @RequestParam(value = "year") int year, @RequestParam(value = "semester") int semester)  {
		ProfessorVO pvo = (ProfessorVO) request.getSession().getAttribute("pro_vo");
		log.info("*******proAttGet()*******");
		AttVO vo = new AttVO();
		vo.setPro_code(pvo.getPro_code());
		vo.setAtt_time(time);
		vo.setYear(year);
		vo.setSemester(semester);
		List<AttVO> list = new ArrayList<AttVO>();
		list = service.classAtt(vo);
		ProClassVO sub = new ProClassVO();
		sub.setMajor_code(list.get(0).getMajor_code());
		sub.setSub_code(list.get(0).getSub_code());
		sub.setYear(year);
		sub.setSemester(semester);
		sub.setPro_code(list.get(0).getPro_code());
		String day = "";
		switch (list.get(0).getAtt_time().substring(0, 1)) {
		case "A":
			day = "월";
			break;
		case "B":
			day = "화";
			break;
		case "C":
			day = "수";
			break;
		case "D":
			day = "목";
			break;
		case "E":
			day = "금";
			break;
		}
		model.addAttribute("sub", service.proclassSearchOne(sub));
		model.addAttribute("day", day);
		model.addAttribute("list", list);
		return "/professor/professor_att";
	}
	
	@ResponseBody
	@RequestMapping(value="/attCheck", method=RequestMethod.POST)
	public List<ProClassVO> attCheck(@RequestBody Map<String, String> map,HttpServletRequest request){
		log.info("*******attCheck*******");
		ProfessorVO pvo = (ProfessorVO) request.getSession().getAttribute("pro_vo");
		AttVO vo = new AttVO();
		vo.setStu_code(map.get("stu_code"));
		vo.setSub_code(map.get("sub_code"));
		vo.setMajor_code(map.get("major_code"));
		vo.setPro_code(pvo.getPro_code());
		vo.setYear(Integer.parseInt(map.get("year")));
		vo.setSemester(Integer.parseInt(map.get("semester")));
		vo.setAtt_time(map.get("att_time"));
		for(int i=1; i<16; i++) {
			if(map.get("week"+i)==null) {
				map.put("week"+i, "");
			}
		}
		vo.setWeek1(map.get("week1"));
		vo.setWeek2(map.get("week2"));
		vo.setWeek3(map.get("week3"));
		vo.setWeek4(map.get("week4"));
		vo.setWeek5(map.get("week5"));
		vo.setWeek6(map.get("week6"));
		vo.setWeek7(map.get("week7"));
		vo.setWeek8(map.get("week8"));
		vo.setWeek9(map.get("week9"));
		vo.setWeek10(map.get("week10"));
		vo.setWeek11(map.get("week11"));
		vo.setWeek12(map.get("week12"));
		vo.setWeek13(map.get("week13"));
		vo.setWeek14(map.get("week14"));
		vo.setWeek15(map.get("week15"));
		log.info(vo);
		log.info("attUpdate 성공 : "+ service.attUpdate(vo));
		return null;
	}
	
	@GetMapping("pro_stugrade")
	public String proStuGradeGet(Model model,HttpServletRequest request,
			@RequestParam(value = "major_code") String major_code,@RequestParam(value = "sub_code") String sub_code, 
			@RequestParam(value = "year") int year, @RequestParam(value = "semester") int semester)  {
		log.info("*******proStuGradeGet()*******");
		SubListVO vo = new SubListVO();
		vo.setMajor_code(major_code);
		vo.setSub_code(sub_code);
		vo.setList_year(year);
		vo.setList_semester(semester);
		List<SubListVO> list = new ArrayList<SubListVO>();
		list = service.proStuGradeSearch(vo);
		model.addAttribute("list", list);
		
		ProClassVO sub = new ProClassVO();
		sub.setMajor_code(list.get(0).getMajor_code());
		sub.setSub_code(list.get(0).getSub_code());
		sub.setYear(year);
		sub.setSemester(semester);
		sub.setPro_code(list.get(0).getPro_code());
		
		model.addAttribute("sub", service.proclassSearchOne(sub));
		
		return "/professor/professor_grade";
	}
	
	@ResponseBody
	@RequestMapping(value="/proStuGrade", method=RequestMethod.POST)
	public List<ProClassVO> proStuGrade(@RequestBody Map<String, String> map,HttpServletRequest request){
		log.info("*******proStuGrade*******");
		ProfessorVO pvo = (ProfessorVO) request.getSession().getAttribute("pro_vo");
		SubListVO vo = new SubListVO();
		vo.setStu_code(map.get("stu_code"));
		vo.setSub_code(map.get("sub_code"));
		vo.setMajor_code(map.get("major_code"));
		vo.setPro_code(pvo.getPro_code());
		vo.setYear(Integer.parseInt(map.get("year")));
		vo.setSemester(Integer.parseInt(map.get("semester")));
		vo.setSub_credit(Integer.parseInt(map.get("sub_credit")));
		vo.setIsu(map.get("isu"));
		
		if(map.get("list_mid") != null) {
			vo.setList_mid(Double.parseDouble(map.get("list_mid")));
		}else {
			vo.setList_mid(0.0);
		}
		if(map.get("list_last") != null) {
			vo.setList_last(Double.parseDouble(map.get("list_last")));
		}else {
			vo.setList_last(0.0);
		}
		
		if(map.get("list_score") != null) {
			vo.setList_score(Double.parseDouble(map.get("list_score")));
		}else {
			vo.setList_score(0.0);
		}
		
		//성적부여
		log.info("성적부여 성공 : "+ service.subListUpdate(vo));
		log.info(vo);
		//이수확인절차
		if(service.isuCheck(vo).equals("N") && vo.getList_score() >= 1) {
			//이수변경
			log.info("이수처리 성공 : " + service.isuUpdate(vo));
			//이수학점부여
			String gubun = service.gubunCheck(vo);
			log.info(gubun);
			StudentVO stu = new StudentVO();
			stu.setStu_code(map.get("stu_code"));
			stu.setGubun(gubun);
			log.info("stu : " + stu);
			log.info(stu);
			if(gubun != null) {
				stu.setCredit(Integer.parseInt(map.get("sub_credit")));
				log.info("이수학점 부여 성공 : " + service.stuisuup(stu));
			}
			
		}
		return null;
	}
	
	@GetMapping("pro_student")
	public String proStudentGet(Model model,HttpServletRequest request) {
		log.info("*******proStudentGet()*******");
		ProfessorVO vo = (ProfessorVO) request.getSession().getAttribute("pro_vo");
		List<StudentVO> list = service.proStudentSearch(vo);
		model.addAttribute("list", list);
		return "/professor/professor_stu";
	}
	
	/*박설화------------------------------------------------------------------------------------------------------------------------------------------*/
	@GetMapping("student_view")
	public String student_view(HttpSession session, Model model, HttpServletRequest request,
		HttpServletResponse response) {
		log.info("*******stuView()*******");
		session = request.getSession(true);

		StudentVO vo2 = (StudentVO) session.getAttribute("stu_vo");
		log.info(vo2.getStu_code());
		StudentVO vo3 = service.studentSelecet(vo2.getStu_code());
		log.info(vo3.toString());
		model.addAttribute("stu_vo", vo3);

		return "/student/student_view";
	}

	@PostMapping("student_view")
	public String studentMoify(MultipartHttpServletRequest request) {
		int row = 0;
		StudentVO stu = new StudentVO();
		stu.setStu_code(request.getParameter("stu_code"));
		 String stu_phone = request.getParameter("tel_1")+"-"+request.getParameter("tel_2")+"-"+request.getParameter("tel_3");
	        stu.setStu_phone(stu_phone);
	        if(request.getParameter("email_3").equals("0"))
	        {
	           String email = request.getParameter("email_1")+"@"+request.getParameter("email_2");
	           stu.setStu_email(email);            
	        }
	        else
	        {
	           String email = request.getParameter("email_1")+"@"+request.getParameter("email_3");
	           stu.setStu_email(email);
	        }
	        stu.setStu_addr(request.getParameter("stu_addr"));
	        stu.setStu_zip(request.getParameter("stu_zip"));
	        row = service.studentModify(stu);
	    return "redirect:/Turkey/student_view";
	}

	@GetMapping("student_modify")
	public String studentModifyPass(HttpSession session, Model model) {
		log.info("*******stuView()*******");

		StudentVO vo2 = (StudentVO) session.getAttribute("stu_vo");
		StudentVO vo3 = service.studentSelecet(vo2.getStu_code());
		log.info(vo3.toString());

		model.addAttribute("stu_vo", vo3);

		return "/student/student_modify";
	}

	@PostMapping("student_modify")
	public String student_modifyPassword(HttpSession session, Model model, RedirectAttributes rttr, StudentVO stu,
			@RequestParam("stu_pw") String stu_pw) {

		stu = (StudentVO) session.getAttribute("stu_vo");
		stu.setStu_pw(stu_pw);

		int row = 0;
		try {
			row = service.studentModifyPass(stu);

		} catch (Exception e) {
			e.printStackTrace();
		}
		rttr.addFlashAttribute("row", row);

		return "redirect:/Turkey/student_modify";
	}

	@GetMapping("student_score")
	public String student_score(HttpSession session, Model model) {
		log.info("*******student_score()*******");

		StudentVO vo2 = (StudentVO) session.getAttribute("stu_vo");
		StudentVO vo3 = service.studentSelecet(vo2.getStu_code());
		
		model.addAttribute("stu_vo", vo3);
		model.addAttribute("list", service.listYearCode(vo3));
		model.addAttribute("list2", service.studentScoreSelecet(vo2.getStu_code()));

		return "/student/student_score";
	}

	@PostMapping("student_score")
	public String student_score_post(HttpSession session, Model model, HttpServletRequest request) {
		
		log.info("*******student_score_post post*******");
		
		StudentVO vo2 = (StudentVO) session.getAttribute("stu_vo");
		log.info(Integer.parseInt(request.getParameter("list_semester")));
		log.info(Integer.parseInt(request.getParameter("list_year")));
		vo2.setList_semester(Integer.parseInt(request.getParameter("list_semester")));
		vo2.setList_year(Integer.parseInt(request.getParameter("list_year")));
		log.info(vo2);
		model.addAttribute("list", service.listYearCode(vo2));
		log.info(service.studentScoreSearch(vo2));
		model.addAttribute("list2", service.studentScoreSearch(vo2));

		return "/student/student_score";
	}

	@GetMapping("student_attendance")
	public String student_attendance(HttpSession session, Model model) {
		log.info("*******student_attendance*******"); 
		
		StudentVO vo2 = (StudentVO)session.getAttribute("stu_vo"); 
		StudentVO vo3 = service.studentSelecet(vo2.getStu_code()); 
		
		model.addAttribute("stu_vo", vo3); 
		model.addAttribute("list",service.attYearCode(vo3));
		
		return "/student/student_attendance";
	}
	
	@PostMapping("student_attendance")
	public String student_attendance_pro(HttpSession session, Model model, HttpServletRequest request) {
		log.info("*******student_attendance pro*******"); 
		
		StudentVO vo2 = (StudentVO)session.getAttribute("stu_vo"); 
		AttVO vo = new AttVO();
		vo2.setYear(Integer.parseInt(request.getParameter("year")));
		vo2.setSemester(Integer.parseInt(request.getParameter("semester")));
		
		model.addAttribute("list", service.attYearCode(vo2));
		model.addAttribute("list2", service.studentAttSearch(vo2));
		return "/student/student_attendance";
	}
	
	/*안은별------------------------------------------------------------------------------------------------------------------------------------------*/
	@GetMapping("student_sub_cal")
	public String stuSub(Model model, HttpServletRequest request, HttpServletResponse response) {
		log.info("****student_sub_cal()****");

		HttpSession httpSession = request.getSession(true);
		StudentVO vo2 = (StudentVO) httpSession.getAttribute("stu_vo");

		StudentVO vo3 = service.studentSelecet(vo2.getStu_code());
		log.info(vo3.toString());

		model.addAttribute("list", service.listYearCode2(vo3));
		model.addAttribute("list2", service.stuSub(vo2));

		log.info(service.stuSub(vo2));
		log.info(service.listYearCode2(vo3));

		return "/student/student_sub_cal";

	}

	@PostMapping("student_sub_cal")
	public String stuSub_post(HttpSession session, Model model, HttpServletRequest request) {

		log.info("****student_sub_cal_post()****");

		HttpSession httpSession = request.getSession(true);
		StudentVO vo2 = (StudentVO) httpSession.getAttribute("stu_vo");

		vo2.setSemester(Integer.parseInt(request.getParameter("semester")));
		vo2.setYear(Integer.parseInt(request.getParameter("year")));

		model.addAttribute("list", service.listYearCode2(vo2));
		model.addAttribute("list2", service.stuSub(vo2));

		return "/student/student_sub_cal";
	}
	   
}
