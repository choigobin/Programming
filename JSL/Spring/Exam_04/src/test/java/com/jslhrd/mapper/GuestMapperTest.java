package com.jslhrd.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jslhrd.domain.GuestVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class GuestMapperTest {
	@Setter(onMethod_=@Autowired)
	private GuestMapper mapper;
	
	@Test
	public void testGuestCount() {
		log.info(mapper.guestCount());
	}
	
	
	@Test
	public void testGuestList() {
		//log.info(mapper.guestList());
		mapper.guestList().forEach(guest->log.info(guest));
	}
	
	/*
	@Test
	public void testGuestWrite() {
		GuestVO vo = new GuestVO();
		vo.setName("홍길동");
		vo.setSubject("아버지를아버지라..");
		vo.setContents("부르지못하지롱");
		log.info("guestWrite() : " + mapper.guestWrite(vo));
	}
	*/
	/*
	@Test
	public void testGuestWriteKey() {
		GuestVO vo = new GuestVO();
		vo.setName("홍길동");
		vo.setSubject("아버지를아버지라..");
		vo.setContents("부르지못하지롱");
		mapper.guestWriteKey(vo);
		log.info(vo);
	}
	*/
	/*
	@Test
	public void testGuestSelect() {
		GuestVO vo = mapper.guestSelect(1);
		log.info(vo);
	}
	*/
	/*
	@Test
	public void testGuestModify() {
		GuestVO vo = new GuestVO();
		vo.setIdx(1);
		vo.setName("JAVA");
		vo.setSubject("제목을 수정합니다.");
		vo.setContents("내용을 수정합니다.");
		
		int row = mapper.guestModify(vo);
		log.info("update count : " + row);
	}
	*/
	/*
	@Test
	public void testGuestDelete() {
		log.info("delete count : " + mapper.guestDelete(3));
	}
	*/
	
}
