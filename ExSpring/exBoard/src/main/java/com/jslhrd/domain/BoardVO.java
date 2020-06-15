package com.jslhrd.domain;

import lombok.Data;

@Data
public class BoardVO {
	
	private int idx;  //게시물 고유번호
	private String pass; //패스워드
	private String name; //작성자
	private String email;  //이메일
	private String regdate; //작성일
	private String subject; //제목
	private String contents; //내용
	private int readcnt; //조회수
	private String ip; //IP주소
	private int comments; //댓글수
	
}
