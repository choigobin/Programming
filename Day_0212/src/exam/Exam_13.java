package exam;

import java.util.*;

import model.*;

public class Exam_13 {
	public static void main(String[] args) {
		DataDAO dao = new DataDAO();
		List<EmpVO> list = dao.exam_13();
		if(list.isEmpty()) {
			System.out.println("검색결과가 없습니다");
		}else {
			System.out.println("ENAME\t");
			for(EmpVO vo : list) {
				System.out.print(vo.getEname()+"\n");
			}
		}
		
	}
}
