package com.jslhrd.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

public interface TurkeyService {
	
	/*최문환-----------------------------------------------------------------------------------------*/
	//ID검색 후 비밀번호 리턴 - ID,비번 맞는지 체크용
	public String stuIdSearch(StudentVO vo);
	
	//로그인(id,pass) - Session추가용
	public StudentVO stuLogin(StudentVO vo);
	
	//ID검색 후 비밀번호 리턴 - ID,비번 맞는지 체크용
	public String proIdSearch(ProfessorVO vo);
	
	//로그인(id,pass) - Session추가용
	public ProfessorVO proLogin(ProfessorVO vo);
	
	//전공코드로 전공이름 가져오기
	public String getMajorName(String major_code);

	//학과등록
	public void majorInsert(MajorVO vo);
	
	//학과리스트
	public List<MajorVO> majorList();
	
	//과목등록
	public void subInsert(SubjectVO vo);
		
	//과목리스트
	public List<SubjectVO> subList(SubjectVO vo);
		
	//과목코드로 정보 가져오기
	public SubjectVO subjectOne(SubjectVO vo);
		
	//학기별 과목 등록
	public void sub2Insert(Subject2VO vo);
		
	//학기별 개설과목 조회
	public List<Subject2VO> sub2List(Subject2VO vo);
	
	//과목코드로 과목정보 불러오기
	public Subject2VO findSubjectInfo(Subject2VO vo);
	
	//수강신청시 등록된 과목이 있나 검사
	public SubListVO subListCheck(Subject2VO vo);
	   
	//시간표에 과목등록
	public void applyDo(Subject2VO sub2VO);
	
	//수강인원 증가
	public void inwonUP(Subject2VO sub2VO);
	
	//수강신청시 출석부 생성
	public void insertATT(AttVO vo);
	
	//우편번호 검색
	public List<ZipVO> zipCodeList(String addr);
	
	//쪽지리스트 불러오기
	public List<MailVO> listMail(String code);
	
	//학생학번검색
	public StudentVO stuCodeCheck(String reception);
	
	//교수학번검색
	public ProfessorVO proCodeCheck(String reception);
	
	//쪽지 보내기
	public void sendMail(MailVO vo);
	
	//보낸 쪽지 리스트 불러오기
	public List<MailVO> sendMailList(String code);
	
	//쪽지 보기
	public MailVO viewMail(int idx);
	
	//쪽지 수신체크
	public void mail_check(int idx);
	
	//미확인 쪽지 갯수 체크
	public int mail_count(String code);
	
	//자게글 5개 불러오기
	public List<BoardVO> main_freeboard_list();

	//공지글 5개 불러오기
	public List<NoticeVO> main_noticeboard_list();

	//일정등록
	public void illjung_insert(ILLJUNGVO vo);
	
	//일정삭제
	public void illjung_delete(int idx);
	
	//전체 일정 리스트
	public List<ILLJUNGVO> illjung_list();
	
	//연도별 일정 리스트
	public List<ILLJUNGVO> illjung_list_year(String year);
	
	/*노주리-----------------------------------------------------------------------------------------*/
	//Notice - 게시물 총 개수 카운트
	public int noticeCount();
	
	//Notice - 검색 조건에 맞는 게시물 총 개수 카운트
	public int noticeSearchCount(PageVO vo);
	
	//Notice - 전체 게시물 조회(List)
	public List<NoticeVO> noticeList(PageVO vo);
	
	//Notice - 검색 조건에 맞는 게시물 조회(List)
	public List<NoticeVO> noticeSearchList(PageVO vo);
	
	//Notice - 게시물 등록
	public void noticeInsert(NoticeVO vo);
	
	//Notice - 게시물 조회수 증가
	public void noticeReadcnt(int idx, HttpServletRequest request, HttpServletResponse response);

	//Notice - 특정 게시물 선택
	public NoticeVO noticeSelect(int idx);
	
	//Notice - 게시물 수정
	public void noticeModify(NoticeVO vo);
	
	//Notice - 게시물 삭제
	public int noticeDelete(int idx);
	
	//Board - 게시물 총 개수 카운트
	public int boardCount();
			
	//Board - 검색 조건에 맞는 게시물 총 개수 카운트
	public int boardSearchCount(PageVO vo);
			
	//Board - 전체 게시물 조회(List)
	public List<BoardVO> boardList(PageVO vo);
			
	//Board - 검색 조건에 맞는 게시물 조회(List)
	public List<BoardVO> boardSearchList(PageVO vo);
			
	//Board - 게시물 등록
	public int boardWrite(BoardVO vo);
			
	//Board - 게시물 조회수 증가
	public void boardReadcnt(int idx, HttpServletRequest request, HttpServletResponse response);
				
	//Board - 특정 게시물 선택
	public BoardVO boardSelect(int idx);
				
	//Board - 게시물 수정
	public void boardModify(BoardVO vo);
				
	//Board - 게시물 삭제
	public int boardDelete(int idx);
	
	//Comment - 댓글 등록
	public int commentWrite(CommentVO vo);
	
	//Comment - 댓글 조회(List)
	public List<CommentVO> commentList(int idx);
	
	//Comment - 댓글 삭제
	public void commentDelete(int c_idx);
	
	//Comment - 특정 댓글 선택
	public CommentVO commentSelect(int c_idx);
		
	//Board - 게시물 수정
	public void commentModify(CommentVO vo);
	
	//학생번호 찾기
	public StudentVO find_code(StudentVO vo);
		   
	//학생 비밀번호 찾기
	public StudentVO find_pass(StudentVO vo);
		   
	//학생 비밀번호 수정
	public void updatePass(StudentVO vo);
		
	/*박준배-----------------------------------------------------------------------------------------*/
	//학생 입력
	public void stdinsert(StudentVO vo);
	
	//교수 입력
	public void proinsert(ProfessorVO vo);
		
	//전공 코드, 이름 받아옴
	public List<MajorVO> MajorView(MajorVO vo);
		
	//학생 정보(전원)
	public List<StudentVO> StuSelect(StudentVO vo);
		
	//학생 정보 수정(관리자)
	public StudentVO StuAdModi(int stu_code);
		
	//학생 정보 수정 업데이트(관리자)
	public void StuAdModify(StudentVO vo);

	//교수 정보(전원)
	public List<ProfessorVO> ProSelect(ProfessorVO vo);
		
	//교수 정보(학과별)
	public List<ProfessorVO> ProSelectSearch(String major_code);
		
	//교수 정보 수정(관리자)
	public ProfessorVO ProAdModi(int pro_code);
		
	//교수 정보 수정 업데이트(관리자)
	public void ProAdModify(ProfessorVO vo);
	
	//교수 정보 수정 업데이트(교수)
	public void ProModify(ProfessorVO vo);

	//교수 비빌번호 수정(교수)
	public void ProModiPass(ProfessorVO vo);
	
	// 학사일정 보기(main)
	public List<ILLJUNGVO> IlljungSelect(String day);
	   
	/*최강민-----------------------------------------------------------------------------------------*/
	//교수 수업검색
	public List<ProClassVO> proClassSearch(ProClassVO vo);
		
	//강의별 출석검색
	public List<AttVO> classAtt(AttVO vo);
		
	//강의 정보검색
	public ProClassVO proclassSearchOne(ProClassVO vo);
		
	//출석 정보변경
	public int attUpdate(AttVO vo);
		
	//담당 학생조회
	public List<StudentVO> proStudentSearch(ProfessorVO vo);
		
	//강의별 성적검색
	public List<SubListVO> proStuGradeSearch(SubListVO vo);
		
	//강의 성적부여
	public int subListUpdate(SubListVO vo);
		
	//이수 처리
	public int isuUpdate(SubListVO vo);
		
	//이수 확인
	public String isuCheck(SubListVO vo);
		
	//강의 이수 구분확인
	public String gubunCheck(SubListVO vo);
		
	//학점 이수 부여
	public int stuisuup(StudentVO vo);
	
	/*박설화-----------------------------------------------------------------------------------------*/
	//학생정보조회
	public StudentVO studentSelecet(String stu_code);

	//학생정보수정
	public int studentModify(StudentVO vo);

	//학생비번수정
	public int studentModifyPass(StudentVO vo);

	//성적 하나조회
	public StudentVO studentScoreSelecet(String stu_code);

	//성적조회
	public List<SubListVO> studentScoreSearch(StudentVO vo);

	//년도자동
	public List<SubListVO> listYearCode(StudentVO vo);

	//출결조회
	public List<AttVO> studentAttSearch(StudentVO vo);
	
	//조회 셀렉트박스 년도 자동갱신
	public List<AttVO> attYearCode(StudentVO vo);
	
	/*안은별-----------------------------------------------------------------------------------------*/
	//시간표조회
	public List<SubjectVO> stuSub(StudentVO vo);

	//시간표 조회 셀렉트박스 년도 자동갱신
	public List<SubjectVO> listYearCode2(StudentVO vo);
	
	//메인에 시간표 띄우는 용(학생)
	public List<SubjectVO> stuSubMain(StudentVO vo);
	
	//메인 교수 띄우기용 (임시)
	public List<Subject2VO> proSubMain(ProfessorVO vo);
	
}
