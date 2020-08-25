package com.jslhrd.domain;

import lombok.Data;

@Data
public class BoardVO {
	private int idx;
	private int stu_code;
	private String title;
	private String contents;
	private String regdate;
	private int readcnt;
}
