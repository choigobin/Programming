package com.jslhrd.mapper;

import java.util.List;

import com.jslhrd.domain.BoardVO;
import com.jslhrd.domain.PageVO;

public interface BoardMapper {

	// 전체 게시물 총 카운트
	public int boardCount();
	
	// 검색조건에 맞는 게시물 카운트
	public int boardSearchCount(PageVO vo);
	
	// 전체게시물 목록 불러오기(list)
	public List<BoardVO> boardList(PageVO vo);
	
	// 조건에맞는 전체게시물 불러오기
	public List<BoardVO> boardListSearch(PageVO vo);
	
	// 특정 게시물 검색(view)
	public BoardVO boardSelect(int idx);
	
	// 특정 게시물 조회수 증가
	public void boardHits(int idx);
	
	// 게시물 등록
	public int boardWrite(BoardVO vo);
	
	// 게시물 수정
	public int boardModify(BoardVO vo);
	
	// 게시물 삭제
	public int boardDelete(BoardVO vo);
}
