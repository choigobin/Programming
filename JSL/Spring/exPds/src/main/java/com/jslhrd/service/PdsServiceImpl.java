package com.jslhrd.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.jslhrd.domain.PageVO;
import com.jslhrd.domain.PdsVO;
import com.jslhrd.mapper.PdsMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PdsServiceImpl implements PdsService {
	private PdsMapper mapper;// 주입요청

	@Override
	public int pdsCount() {
		return mapper.pdsCount();
	}

	@Override
	public int pdsSearchCount(PageVO vo) {
		return mapper.pdsSearchCount(vo);
	}

	@Override
	public List<PdsVO> pdsList(PageVO vo) {
		return mapper.pdsList(vo);
	}

	@Override
	public List<PdsVO> pdsSearchList(PageVO vo) {
		return mapper.pdsSearchList(vo);
	}

	@Override
	public void pdsWrite(PdsVO vo) {
		mapper.pdsWrite(vo);
	}

	@Override
	public PdsVO pdsView(int idx) {
		return mapper.pdsView(idx);
	}

	@Override
	public void pdsHits(int idx, HttpServletRequest request, HttpServletResponse response) {
		boolean bool = false;
		Cookie info = null;
		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			info = cookies[i];
			if (info.getName().equals("pdsCookie" + idx)) {
				bool = true;
				break;
			}
		}
		String str = "" + System.currentTimeMillis();
		if (!bool) {
			info = new Cookie("pdsCookie" + idx, str);
			response.addCookie(info);
			mapper.pdsHits(idx);
		}
	}

	@Override
	public void pdsModify(PdsVO vo) {
		
		mapper.pdsModify(vo);
	}

	
	@Override
	public int pdsDelete(PdsVO vo) {
		PdsVO select = mapper.pdsView(vo.getIdx());
		
		if(select.getPass().equals(vo.getPass())) {
			File file = new File(vo.getPath() + select.getFilename());
			if(file.exists()) {
				file.delete();	
			}
		}
		
		int row = mapper.pdsDelete(vo);
		return row;
	}
	
	
	
}
