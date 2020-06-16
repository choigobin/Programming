package com.jslhrd.mappertest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jslhrd.domain.GuestVO;
import com.jslhrd.mapper.GuestMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j

public class GuestMapperTest {
	@Setter(onMethod_=@Autowired)
	private GuestMapper mapper;
/*	
	@Test
	public void guestCount() {
		log.info("guestCount() : " + mapper.guestCount());
	}
*/	
/*	
	// 게시물 전체 목록 검색
	@Test
	public void guestList() {
		mapper.guestList().forEach(guest->log.info(guest));
	}
*/
/*	
	// 특정 게시물 검색
	@Test
	public void guestSelect() {
		log.info("guestSelect() :" + mapper.guestSelect(21));
	}
*/
/*
	// 특정 게시물 조회수 증가
	@Test
	public void guestHits() {
		mapper.guestHits(21);
	}
*/
/*	
	// 게시물 등록
	@Test
	public void guestWrite() {
		GuestVO vo = new GuestVO();
		vo.setName("오미자");
		vo.setSubject("오미자 제목");
		vo.setContents("오미자 글 내용");
		
		log.info("guestWrite() :"  + mapper.guestWrite(vo));
	}
*/
/*	
	// 게시물 수정
	@Test
	public void guestModify() {
		GuestVO vo = new GuestVO();
		vo.setIdx(42);
		vo.setSubject("제목 수정");
		vo.setContents("내용 수정");
		
		log.info("guestWrite() :"  + mapper.guestModify(vo));
		
	}
*/
/*	
	// 게시물 삭제
	@Test
	public void guestDelete() {
		log.info("guestDelete() :"  + mapper.guestDelete(5));
	}
*/
	
}
