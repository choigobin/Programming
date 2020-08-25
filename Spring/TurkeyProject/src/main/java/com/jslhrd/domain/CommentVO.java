package com.jslhrd.domain;

import lombok.Data;

@Data
public class CommentVO {

	private int c_idx;
	private int idx;
	private int stu_code;
	private String comments;
	private String stu_name;
}
