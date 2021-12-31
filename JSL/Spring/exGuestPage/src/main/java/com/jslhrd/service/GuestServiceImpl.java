/**
 * 
 */
package com.jslhrd.service;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.jslhrd.domain.GuestVO;
import com.jslhrd.domain.PageVO;
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
	public List<GuestVO> guestList(PageVO vo) {
		return mapper.guestList(vo);
	}

	@Override
	public GuestVO guestSelect(int idx) {
		return mapper.guestSelect(idx);
	}

	@Override
	public void guestHits(int idx,HttpServletRequest request, HttpServletResponse response) {
		boolean bool=false;
		Cookie info = null;
		Cookie[] cookies = request.getCookies();
		for(int i=0; i<cookies.length; i++) {
			info = cookies[i];
			if(info.getName().equals("guestCookie"+idx)) {
				bool = true;
				break;
			}
		}
		String str= ""+System.currentTimeMillis();
		if(!bool) {
			info=new Cookie("guestCookie"+idx, str);
			response.addCookie(info);
			mapper.guestHits(idx);
		}
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
