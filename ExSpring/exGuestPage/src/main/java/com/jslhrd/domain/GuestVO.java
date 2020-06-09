package com.jslhrd.domain;

import lombok.Data;

@Data
public class GuestVO {
	private int idx;		//고유번호(기본키)
	private String name;	//작성자
	private String subject;	//제목
	private String contents;//내용
	private String regdate;	//등록일자
	private int readcnt;	//조회수
	
}
