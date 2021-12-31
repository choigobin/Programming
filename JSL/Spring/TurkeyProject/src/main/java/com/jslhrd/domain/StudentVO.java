package com.jslhrd.domain;

import lombok.Data;

@Data
public class StudentVO {
	private String stu_code;
	private String major_code;
	private String pro_code;
	private String stu_pw;
	private String stu_name;
	private String stu_sex;
	private String stu_email;
	private int stu_birth;
	private String stu_phone;
	private String stu_condition;	
	private String stu_nt;
	private String stu_eng;
	private int stu_level;
	private int stu_jeon;
	private int stu_gyo;
	private String stu_img;
	private String stu_zip;
	private String stu_addr;
	
	private String major_name;
	
	private int list_semester;
	private int list_year;
	
	private int semester;
	private int year;
	
	private String gubun;
	private int credit;
}
