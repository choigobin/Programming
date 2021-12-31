package com.jslhrd.domain;

import lombok.Data;

@Data
public class NoticeVO {
	private int idx;
	private String title;
	private String contents;
	private String regdate;
	private int readcnt;
	private String filename;
	private String ori_filename;	//file이 존재하지 않을 때 file.png를 보여주지 않기 위해
}
