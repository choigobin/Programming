package exam2;

import model.DDLDao;

/*	DDL(데이터 제어어) : CREATE, ALTER, DROP
 * 	DML(데이터 조작어) : CRUD(insert,select,update,delete)
 * 	DCL(데이터 제어어) : GRANT, REVOKE
 * 	TCL(트랜젝션 제어) : COMMIT, ROLLBACK, SAVEPOINT
 * 	CREATE DATABASE 데이터베이스명; -> 오라클은 설치할 때 DATABASE 생성 & 고정 -> CREATE DATABASE 불가!
 * 	오라클 -> CREATE TABLESPACE 테이블스페이스명; -> DB 대신 테이블스페이스 사용
 */
public class Exam_01 {
	public static void main(String[] args) {
		DDLDao dao = new DDLDao();
		//dao.tabCreate();
		if(dao.insertAAA(1, "최문환", "20200212", 18)==1) {
			System.out.println("등록에 성공하였습니다.");
		}else {
			System.out.println("등록 실패!");
		}
		
		
		
	}
}
