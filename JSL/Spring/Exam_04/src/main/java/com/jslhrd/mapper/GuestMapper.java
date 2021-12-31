package com.jslhrd.mapper;

import java.util.List;

import com.jslhrd.domain.GuestVO;

public interface GuestMapper {
	
	// 전체게시물 갯수
	// @Select("select count(*) from tbl_guest")
	public int guestCount();
	
	// 전체 게시물 검색(list)
	public List<GuestVO> guestList();
	
	// 특정 게시물 검색
	public GuestVO guestSelect(int idx);
	
	// 게시물 등록
	public int guestWrite(GuestVO vo);
	public int guestWriteKey(GuestVO vo);
	
	// 게시믈 수정
	public int guestModify(GuestVO vo);
	
	// 게시물 삭제
	public int guestDelete(int idx);
	
}
