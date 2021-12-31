package com.jslhrd.domain;

import lombok.Data;

@Data
public class ProfessorVO {
	private String pro_code;
	private String major_code;
	private String pro_pw;
	private String pro_name;
	private String pro_sex;
	private String pro_email;
	private int pro_birth;
	private String pro_phone;
	private int pro_grade;
	private String pro_nt;
	private String pro_eng;
	private String pro_img;
	
	private String major_name;
}
