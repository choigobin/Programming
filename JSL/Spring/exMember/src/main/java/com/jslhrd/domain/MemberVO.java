package com.jslhrd.domain;

import lombok.Data;

@Data
public class MemberVO {
	private String name;
	private String userid;
	private String passwd;
	private String gubun;
	private String zipcode;
	private String addr1;
	private String addr2;
	private String tel;
	private String email;
	private String job;
	private String intro;
	private String favorite;
	private String first_time;
	private String last_time;

}
