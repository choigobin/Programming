package com.jslhrd.domain;

import lombok.Data;

@Data
public class SubListVO {
	private String stu_code;
	private String sub_code;
	private String sub_name;
	private String major_code;
	private String pro_code;
	private int list_year;
	private int list_semester;
	private int year;
	private int semester;
	private int sub_credit;
	private String list_pyung;
	private int list_pyung_score;
	private Double list_mid;
	private Double list_last;
	private Double list_score;
	private String gubun;
	private String time_a;
	private String time_b;
	private int inwon;
	private int max_inwon;
	private String isu;
	private String stu_name;
}
