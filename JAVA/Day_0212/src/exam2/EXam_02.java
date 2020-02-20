package exam2;

import model.DDLDao;

/*	update 테이블명 set 항목=값, 항목=값, where 조건식
 * 	update aaa set dname='dddd', score=100 where dno = 1;
 */
public class EXam_02 {
	public static void main(String[] args) {
		int dno = 1;
		String dname = "dddd";
		int score = 100;
		DDLDao dao = new DDLDao();
		int row = dao.updateAAA(dno, dname, score);
		if(row==0) {
			System.out.println("업데이트 실패");
		}else {
			System.out.println("업데이트 성공");
		}
		
		
	}
}
