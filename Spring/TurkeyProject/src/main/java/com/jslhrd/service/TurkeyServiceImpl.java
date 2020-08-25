package com.jslhrd.service;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import com.jslhrd.mapper.TurkeyMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Service
@AllArgsConstructor
public class TurkeyServiceImpl implements TurkeyService {
	
	/*최문환-----------------------------------------------------------------------------------------*/
	@Setter(onMethod_=@Autowired)
	private TurkeyMapper mapper;
	
	@Override
	public String stuIdSearch(StudentVO vo) {
		return mapper.stuIdSearch(vo);
	}
	@Override
	public StudentVO stuLogin(StudentVO vo) {
		return mapper.stuLogin(vo);
	}

	@Override
	public String proIdSearch(ProfessorVO vo) {
		return mapper.proIdSearch(vo);
	}
	
	@Override
	public ProfessorVO proLogin(ProfessorVO vo) {
		return mapper.proLogin(vo);
	}
	@Override
	public String getMajorName(String major_code) {
		return mapper.getMajorName(major_code);
	}

	@Override
	public void majorInsert(MajorVO vo) {
		mapper.majorInsert(vo);
	}
	
	@Override
	public List<MajorVO> majorList() {
		return mapper.majorList();
	}
	
	@Override
	public void subInsert(SubjectVO vo) {
		mapper.subInsert(vo);
	}
	
	@Override
	public List<SubjectVO> subList(SubjectVO vo) {
		System.out.println("At servcie major_code = " + vo.getMajor_code());
		return mapper.subList(vo);
	}
	
	@Override
	public SubjectVO subjectOne(SubjectVO vo) {
		return mapper.subjectOne(vo);
	}
	
	@Override
	public void sub2Insert(Subject2VO vo) {
		mapper.sub2Insert(vo);
	}
	
	@Override
	public List<Subject2VO> sub2List(Subject2VO vo) {
		return mapper.sub2List(vo);
	}
	
	@Override
	public Subject2VO findSubjectInfo(Subject2VO vo) {
	   return mapper.findSubjectInfo(vo);
	}
	
	@Override
	public SubListVO subListCheck(Subject2VO vo) {
		return mapper.subListCheck(vo);
	}
	
	@Override
	public void applyDo(Subject2VO sub2VO) {
	
	   mapper.applyDo(sub2VO);
	}
	
	@Override
	public void inwonUP(Subject2VO sub2VO) {
		mapper.inwonUP(sub2VO);
	}

	@Override
	public void insertATT(AttVO vo) {
		mapper.insertATT(vo);
	}
	
	@Override
	public List<ZipVO> zipCodeList(String addr) {
		return mapper.zipCodeList(addr);
	}
	
	@Override
	public List<MailVO> listMail(String code) {
		return mapper.listMail(code);
	}
	
	@Override
	public ProfessorVO proCodeCheck(String reception) {
		return mapper.proCodeCheck(reception);
	}
	
	@Override
	public StudentVO stuCodeCheck(String reception) {
		return mapper.stuCodeCheck(reception);
	}
	
	@Override
	public void sendMail(MailVO vo) {
		mapper.sendMail(vo);
	}
	
	@Override
	public List<MailVO> sendMailList(String code) {
		return mapper.sendMailList(code);
	}
	
	@Override
	public MailVO viewMail(int idx) {
		return mapper.viewMail(idx);
	}
	
	@Override
	public void mail_check(int idx) {
		mapper.mail_check(idx);
	}
	
	@Override
	public int mail_count(String code) {
		return mapper.mail_count(code);
	}
	
	@Override
	public List<BoardVO> main_freeboard_list() {
		return mapper.main_freeboard_list();
	}

	@Override
	public List<NoticeVO> main_noticeboard_list() {
		return mapper.main_noticeboard_list();
	}

	@Override
	public void illjung_insert(ILLJUNGVO vo) {
		mapper.illjung_insert(vo);
	}
	
	@Override
	public void illjung_delete(int idx) {
		mapper.illjung_delete(idx);
	}
	
	@Override
	public List<ILLJUNGVO> illjung_list() {
		return mapper.illjung_list();
	}
	
	@Override
	public List<ILLJUNGVO> illjung_list_year(String year) {
		return mapper.illjung_list_year(year);
	}
	
	/*노주리-----------------------------------------------------------------------------------------*/
	@Override
	public int noticeCount() {
		return mapper.noticeCount();
	}
	
	@Override
	public int noticeSearchCount(PageVO vo) {
		return mapper.noticeSearchCount(vo);
	}
	
	@Override
	public List<NoticeVO> noticeList(PageVO vo) {
		return mapper.noticeList(vo);
	}
	
	@Override
	public List<NoticeVO> noticeSearchList(PageVO vo) {
		return mapper.noticeSearchList(vo);
	}
	
	@Override
	public void noticeInsert(NoticeVO vo) {
		mapper.noticeInsert(vo);
	}
	
	@Override
	public void noticeReadcnt(int idx, HttpServletRequest request, HttpServletResponse response) {
		boolean bool = false;
		Cookie info = null;
		Cookie[] cookies = request.getCookies();
		
		HttpSession session = request.getSession();
		StudentVO stu_vo = null;
		ProfessorVO pro_vo = null;
		
		if((StudentVO) session.getAttribute("stu_vo") != null) {
			stu_vo = (StudentVO) session.getAttribute("stu_vo");
			for(int i = 0; i <cookies.length; i++) {
				info = cookies[i];
				if(info.getName().equals(stu_vo.getStu_code()+"noticeCookie" + idx)) {
					bool = true;
					break;
				}
			}
			 
			String str = "" + System.currentTimeMillis();
			 
			if(!bool) {
				info = new Cookie(stu_vo.getStu_code()+"noticeCookie" + idx, str);
				response.addCookie(info);
				mapper.noticeReadcnt(idx);
			}
		}else if((ProfessorVO) session.getAttribute("pro_vo") != null) {
			pro_vo = (ProfessorVO) session.getAttribute("pro_vo");
			for(int i = 0; i <cookies.length; i++) {
				info = cookies[i];
				if(info.getName().equals(pro_vo.getPro_code()+"noticeCookie" + idx)) {
					bool = true;
					break;
				}
			}
			 
			String str = "" + System.currentTimeMillis();
			 
			if(!bool) {
				info = new Cookie(pro_vo.getPro_code()+"noticeCookie" + idx, str);
				response.addCookie(info);
				mapper.noticeReadcnt(idx);
			}
		}
		 

	}
	
	@Override
	public NoticeVO noticeSelect(int idx) {
		return mapper.noticeSelect(idx);
	}
	
	@Override
	public void noticeModify(NoticeVO vo) {
		mapper.noticeModify(vo);
	}
	
	@Override
	public int noticeDelete(int idx) {
		return mapper.noticeDelete(idx);
	}
	
	@Override
	public int boardCount() {
		return mapper.boardCount();
	}
	
	@Override
	public int boardSearchCount(PageVO vo) {
		return mapper.boardSearchCount(vo);
	}
	
	@Override
	public List<BoardVO> boardList(PageVO vo) {
		return mapper.boardList(vo);
	}
	
	@Override
	public List<BoardVO> boardSearchList(PageVO vo) {
		return mapper.boardSearchList(vo);
	}
	
	@Override
	public int boardWrite(BoardVO vo) {
		return mapper.boardWrite(vo);
		
	}
	
	@Override
	public void boardReadcnt(int idx, HttpServletRequest request, HttpServletResponse response) {
		boolean bool = false;
		Cookie info = null;
		Cookie[] cookies = request.getCookies();
		
		HttpSession session = request.getSession();
		StudentVO stu_vo = null;
		ProfessorVO pro_vo = null;
		
		if((StudentVO) session.getAttribute("stu_vo") != null) {
			stu_vo = (StudentVO) session.getAttribute("stu_vo");
			for(int i=0; i <cookies.length; i++) {
				info = cookies[i];
				if(info.getName().equals(stu_vo.getStu_code()+"boardCookie" + idx)) {
					bool = true;
					break;
				}
			}
			 
			String str = "" + System.currentTimeMillis();
			 
			if(!bool) {
				info = new Cookie(stu_vo.getStu_code()+"boardCookie" + idx, str);
				response.addCookie(info);
				mapper.boardReadcnt(idx);
			}
		}else if((ProfessorVO) session.getAttribute("pro_vo") != null) {
			pro_vo = (ProfessorVO) session.getAttribute("pro_vo");
			for(int i=0; i <cookies.length; i++) {
				info = cookies[i];
				if(info.getName().equals(pro_vo.getPro_code()+"boardCookie" + idx)) {
					bool = true;
					break;
				}
			}
			 
			String str = "" + System.currentTimeMillis();
			 
			if(!bool) {
				info = new Cookie(pro_vo.getPro_code()+"boardCookie" + idx, str);
				response.addCookie(info);
				mapper.boardReadcnt(idx);
			}
		}
		
		

	}
	
	@Override
	public BoardVO boardSelect(int idx) {
		return mapper.boardSelect(idx);
	}
	
	@Override
	public void boardModify(BoardVO vo) {
		mapper.boardModify(vo);
		
	}
	
	@Override
	public int boardDelete(int idx) {
		return mapper.boardDelete(idx);
	}
	
	@Override
	public int commentWrite(CommentVO vo) {
		return mapper.commentWrite(vo);
	}
	
	@Override
	public List<CommentVO> commentList(int idx) {
		return mapper.commentList(idx);
	}
	
	@Override
	public void commentDelete(int c_idx) {
		mapper.commentDelete(c_idx);
	}
	
	@Override
	public CommentVO commentSelect(int c_idx) {
		return mapper.commentSelect(c_idx);
	}
	
	@Override
	public void commentModify(CommentVO vo) {
		mapper.commentModify(vo);
	}
	
	@Override
	public StudentVO find_code(StudentVO vo) {
	   return mapper.find_code(vo);
	}
	   
	@Override
	public StudentVO find_pass(StudentVO vo) {
	   return mapper.find_pass(vo);
	}
	   
	@Override
	public void updatePass(StudentVO vo) {
	   mapper.updatePass(vo);
	}
	/*박준배-----------------------------------------------------------------------------------------*/
	@Override
	public void stdinsert(StudentVO vo) {
		mapper.stdinsert(vo);
	}
	@Override
	public void proinsert(ProfessorVO vo) {
		mapper.proinsert(vo);		
	}

	@Override
	public List<MajorVO> MajorView(MajorVO vo) {
		return mapper.MajorView(vo);
	}
	
	@Override
	public List<StudentVO> StuSelect(StudentVO vo) {
		return mapper.StuSelect(vo);
	}
	
	@Override
	public StudentVO StuAdModi(int stu_code) {
		return mapper.StuAdModi(stu_code);
	}
	
	@Override
	public void StuAdModify(StudentVO vo) {
		mapper.StuAdModify(vo);		
	}
	
	@Override
	public List<ProfessorVO> ProSelect(ProfessorVO vo) {
		return mapper.ProSelect(vo);
	}
	
	@Override
	public ProfessorVO ProAdModi(int pro_code) {
		return mapper.ProAdModi(pro_code);
	}
	
	@Override
	public void ProAdModify(ProfessorVO vo) {
		mapper.ProAdModify(vo);	
	}
	
	@Override
	public List<ProfessorVO> ProSelectSearch(String major_code) {
		return mapper.ProSelectSearch(major_code);
	}
	
	@Override
	   public void ProModify(ProfessorVO vo) {
	      mapper.ProModify(vo);      
	   }
	
	@Override
	public void ProModiPass(ProfessorVO vo) {
		mapper.ProModiPass(vo);		
	}
	
	@Override
	public List<ILLJUNGVO> IlljungSelect(String day) {
		return mapper.IlljungSelect(day);
	}
	
	/*최강민-----------------------------------------------------------------------------------------*/
	@Override
	public List<ProClassVO> proClassSearch(ProClassVO vo) {
		return mapper.proClassSearch(vo);
	}
	
	@Override
	public List<AttVO> classAtt(AttVO vo) {
		return mapper.classAtt(vo);
	}
	
	@Override
	public ProClassVO proclassSearchOne(ProClassVO vo) {
		return mapper.proclassSearchOne(vo);
	}
	
	@Override
	public int attUpdate(AttVO vo) {
		return mapper.attUpdate(vo);
	}
	
	@Override
	public List<StudentVO> proStudentSearch(ProfessorVO vo) {
		return mapper.proStudentSearch(vo);
	}
	
	@Override
	public List<SubListVO> proStuGradeSearch(SubListVO vo) {
		return mapper.proStuGradeSearch(vo);
	}
	
	@Override
	public int subListUpdate(SubListVO vo) {
		return mapper.subListUpdate(vo);
	}
	
	@Override
	public int isuUpdate(SubListVO vo) {
		return mapper.isuUpdate(vo);
	}
	
	@Override
	public String isuCheck(SubListVO vo) {
		return mapper.isuCheck(vo);
	}
	
	@Override
	public String gubunCheck(SubListVO vo) {
		return mapper.gubunCheck(vo);
	}
	
	@Override
	public int stuisuup(StudentVO vo) {
		return mapper.stuisuup(vo);
	}
	
	/*박설화-----------------------------------------------------------------------------------------*/
	@Override
	public StudentVO studentScoreSelecet(String stu_code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int studentModify(StudentVO vo) {
		return mapper.studentModify(vo);
	}

	@Override
	public int studentModifyPass(StudentVO vo) {
		return mapper.studentModifyPass(vo);
	}

	@Override
	public StudentVO studentSelecet(String stu_code) {
		return mapper.studentSelecet(stu_code);
	}

	@Override
	public List<SubListVO> studentScoreSearch(StudentVO vo) {
		if (vo.getList_semester() == 0 && vo.getList_year() == 0) {
			return mapper.studentScoreSearchNo(vo);

		} else if (vo.getList_semester() == 0 && vo.getList_year() != 0) {
			return mapper.studentScoreSearchYear(vo);
			
		} else if (vo.getList_semester() != 0 && vo.getList_year() == 0) {
			return mapper.studentScoreSearchSemester(vo);
		}
		return mapper.studentScoreSearch(vo);
	}

	@Override
	public List<SubListVO> listYearCode(StudentVO vo) {
		return mapper.listYearCode(vo);
	}
	
	@Override
	public List<AttVO> studentAttSearch(StudentVO vo) {
		if(vo.getSemester() == 0 && vo.getYear() == 0) {
			return mapper.studentAttSearchNo(vo);
		}else if(vo.getSemester() == 0 && vo.getYear() != 0) {
			return mapper.studentAttSearchYear(vo);
		}else if(vo.getSemester() != 0 && vo.getYear() == 0) {
			return mapper.studentAttSearchSemester(vo);
		}
		return mapper.studentAttSearch(vo);
	}
	
	@Override
	public List<AttVO> attYearCode(StudentVO vo) {
		return mapper.attYearCode(vo);
	}
	
	/*안은별-----------------------------------------------------------------------------------------*/
	@Override
	public List<SubjectVO> stuSub(StudentVO vo) {
		return mapper.stuSub(vo);
	}
	
	@Override
	public List<SubjectVO> listYearCode2(StudentVO vo) {
		return mapper.listYearCode2(vo);
	}

	@Override
	public List<SubjectVO> stuSubMain(StudentVO vo) {
		return mapper.stuSubMain(vo);
	}
	
	@Override
	public List<Subject2VO> proSubMain(ProfessorVO vo) {
		return mapper.proSubMain(vo);
	}
	
}
