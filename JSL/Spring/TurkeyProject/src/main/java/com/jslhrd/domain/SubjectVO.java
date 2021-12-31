package com.jslhrd.domain;

import lombok.Data;

@Data
public class SubjectVO {
	private String sub_code;
	private String major_code;
	private String sub_name;
	private int sub_credit;
	
	//은별
	private String stu_code;
	private String pro_code;
	private String time_a;
	private String time_b;
	private int inwon;
	private int max_inwon;
	private int year;
	private String gubun;
	private int semester;
}
