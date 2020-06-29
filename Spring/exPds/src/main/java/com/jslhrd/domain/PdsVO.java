package com.jslhrd.domain;

import lombok.Data;

@Data
public class PdsVO {
	private int idx;
	private String name,pass,email,subject,contents,regdate,readcnt,filename,path;
	/*
	 * IDX	NUMBER
	NAME	VARCHAR2(20 BYTE)
	PASS	VARCHAR2(20 BYTE)
	EMAIL	VARCHAR2(100 BYTE)
	SUBJECT	VARCHAR2(100 BYTE)
	CONTENTS	VARCHAR2(2000 BYTE)
	REGDATE	DATE
	READCNT	NUMBER(2,0)
	FILENAME	VARCHAR2(255 BYTE)
	 */
}

