package com.jslhrd.service;

import java.util.List;

import com.jslhrd.domain.MemberVO;

public interface MemberService {
	// 전체 회원정보 검색
	public List<MemberVO> memList();

	// id검색 비번 리턴(id, pass 유무)
	public String userIdSearch(MemberVO vo);
	
	// 로그인(id, pass)- 세션정보
	public MemberVO userLogin(MemberVO vo);
	
	// 로그인 성공시 마지막로그인한 날자 업데이트
	public void lastTimeUpdate(MemberVO vo);

}
