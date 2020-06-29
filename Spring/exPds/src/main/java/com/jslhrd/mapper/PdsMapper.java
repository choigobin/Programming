package com.jslhrd.mapper;

import java.util.List;

import com.jslhrd.domain.PageVO;
import com.jslhrd.domain.PdsVO;

public interface PdsMapper {
	//전체 카운트
	public int pdsCount();
	
	//검색 조건 게시물 카운트
	public int pdsSearchCount(PageVO vo);
	
	//전체목록
	public List<PdsVO> pdsList(PageVO vo);
	
	//검색 조건에 맞는 전체 게시물
	public List<PdsVO> pdsSearchList(PageVO vo);
	
	//등록처리
	public void pdsWrite(PdsVO vo);
	
	//뷰
	public PdsVO pdsView(int idx);
	
	//특정 게시물 조회수
	public void pdsHits(int idx);
	
	//수정
	public void pdsModify(PdsVO vo);
	
	//삭제
	public int pdsDelete (PdsVO vo);
	
	
}
