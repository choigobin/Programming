package exam;

import java.util.*;

import model.*;

public class Exam_01 {
	public static void main(String[] args) {
		DataDAO dao = new DataDAO();
		List<EmpVO> list = dao.exam_01();
		if(list.isEmpty()) {
			System.out.println("검색결과가 없습니다");
		}else {
			System.out.println("ENAME\tSALARY\tSALARY+300");
			for(EmpVO vo : list) {
				System.out.print(vo.getEname()+"\t");
				System.out.print(vo.getSalary()+"\t");
				System.out.println(vo.getTemp());
			}
		}
		
	}
}
