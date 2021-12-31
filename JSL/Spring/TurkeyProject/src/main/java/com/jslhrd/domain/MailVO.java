package com.jslhrd.domain;

import lombok.Data;

@Data
public class MailVO {
	private int idx;
	private String title;
	private String contents;
	private String mail_check;
	private String regdate;
	private String reception;
	private String sending;
	private String sending_name;
}
