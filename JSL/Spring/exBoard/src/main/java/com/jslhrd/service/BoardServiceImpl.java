package com.jslhrd.service;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.jslhrd.domain.BoardVO;
import com.jslhrd.domain.PageVO;
import com.jslhrd.mapper.BoardMapper;

import lombok.AllArgsConstructor;

@Service // service에서 가장중요함
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

	private BoardMapper mapper;

	@Override
	public int boardCount() {

		return mapper.boardCount();
	}

	@Override
	public int boardSearchCount(PageVO vo) {

		return mapper.boardSearchCount(vo);
	}

	@Override
	public List<BoardVO> boardList(PageVO vo) {

		return mapper.boardList(vo);
	}

	@Override
	public List<BoardVO> boardListSearch(PageVO vo) {

		return mapper.boardListSearch(vo);
	}

	@Override
	public BoardVO boardSelect(int idx) {

		return mapper.boardSelect(idx);
	}

	@Override
	public void boardHits(int idx, HttpServletRequest request, HttpServletResponse response) {

		boolean bool = false;
		Cookie info = null;
		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			info = cookies[i];
			if (info.getName().equals("boardCookie" + idx)) {
				bool = true;
				break;
			}
		}
		String str = "" + System.currentTimeMillis();
		if (!bool) {
			info = new Cookie("boardCookie" + idx, str);
			response.addCookie(info);
			mapper.boardHits(idx);
		}
	}

	@Override
	public int boardWrite(BoardVO vo) {

		return mapper.boardWrite(vo);
	}

	@Override
	public int boardModify(BoardVO vo) {

		return mapper.boardModify(vo);
	}

	@Override
	public int boardDelete(BoardVO vo) {

		return mapper.boardDelete(vo);
	}

}
