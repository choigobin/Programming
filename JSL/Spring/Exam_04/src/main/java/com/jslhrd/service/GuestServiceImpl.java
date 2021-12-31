package com.jslhrd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jslhrd.domain.GuestVO;
import com.jslhrd.mapper.GuestMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class GuestServiceImpl implements GuestService {
	@Setter(onMethod_=@Autowired)
	private GuestMapper mapper;
	
	@Override
	public List<GuestVO> guestList() {
		
		log.info("guestList().......");
		
		return mapper.guestList();
	}

}
