package com.jslhrd.mapper;

import java.util.List;

import com.jslhrd.domain.MemberVO;

public interface MemberMapper {
	// 전체 회원정보 검색
	public List<MemberVO> memList();
	
}
