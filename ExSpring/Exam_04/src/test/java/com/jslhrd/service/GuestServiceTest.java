package com.jslhrd.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class GuestServiceTest {
	@Setter(onMethod_=@Autowired)
	private GuestService service;
	/*
	@Test
	public void testService() {
		log.info("GuestService : " + service);
		assertNotNull(service);
	}
	*/
	@Test
	public void testGuestList() {
		service.guestList().forEach(GuestVO -> log.info(GuestVO));
	}
	
}
