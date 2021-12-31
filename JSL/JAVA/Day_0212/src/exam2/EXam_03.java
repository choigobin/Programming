package exam2;

import model.DDLDao;

/*	delete from 테이블명 where 조건식
 *	delete from aaa where dno = 1
 */
public class EXam_03 {
	public static void main(String[] args) {
		int dno = 10;
		DDLDao dao = new DDLDao();
		int row = dao.deleteAAA(dno);
		if(row==0) {
			System.out.println("삭제 실패");
		}else {
			System.out.println("삭제 성공");
		}
		
		
	}
}
