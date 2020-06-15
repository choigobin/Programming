package com.jslhrd.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.domain.BoardVO;
import com.jslhrd.domain.PageVO;

public interface BoardService {
	// 전체 게시물 총 카운트
	public int boardCount();

	// 추가 : 검색조건 게시물 총 카운트
	public int boardSearchCount(PageVO vo);

	// 변경 : 전체게시물 목록 불러오기(list)
	public List<BoardVO> boardList(PageVO vo);

	// 게시물 조건에 맞는 전체 목록 불러오기(list)
	public List<BoardVO> boardListSearch(PageVO vo);

	// 특정 게시물 검색(view)
	public BoardVO boardSelect(int idx);

	// 특정 게시물 조회수 증가(컨트롤러에서 쿠키생성 시)
	// public void guestHits(int idx);

	// 특정 게시물 조회수 증가(서비스에서 쿠키생성 시)
	public void boardHits(int idx, HttpServletRequest request, HttpServletResponse response);
	
	// 게시물 등록
	public int boardWrite(BoardVO vo);
	
	// 게시물 수정
	public int boardModify(BoardVO vo);
	
	// 게시물 삭제
	public int boardDelete(BoardVO vo);

}
