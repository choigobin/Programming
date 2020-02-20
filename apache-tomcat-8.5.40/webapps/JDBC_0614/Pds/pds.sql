CREATE TABLE pds (
  num number NOT NULL ,					-- 게시글번호 자동증가
  name varchar2(20) NOT NULL ,			-- 작성자
  pass varchar2(20) NOT NULL ,			-- 비번
  email varchar2(100) NOT NULL ,		-- 이메일 
  subject varchar2(100) NOT NULL,		-- 제목
  contents varchar2(2000) NOT NULL,		-- 내용
  indate date default sysdate ,			-- 등록일자
  readcnt number default 0 ,			-- 조회수
  filename varchar2(255) null,			-- 첨부파일명
  PRIMARY KEY  (num)
);
create sequence pds_seq_num;