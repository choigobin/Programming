/**
 * 
 */
package com.jslhrd.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jslhrd.domain.GuestVO;
import com.jslhrd.mapper.GuestMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GuestServiceImpl implements GuestService {
	
	private GuestMapper mapper;
	
	@Override
	public int guestCount() {
		return mapper.guestCount();
	}

	@Override
	public List<GuestVO> guestList() {
		return mapper.guestList();
	}

	@Override
	public GuestVO guestSelect(int idx) {
		return mapper.guestSelect(idx);
	}

	@Override
	public void guestHits(int idx) {
		mapper.guestCount();
	}

	@Override
	public int guestWrite(GuestVO vo) {
		return mapper.guestWrite(vo);
	}

	@Override
	public int guestModify(GuestVO vo) {
		return mapper.guestModify(vo);
	}

	@Override
	public int guestDelete(int idx) {
		return mapper.guestDelete(idx);
	}

}
