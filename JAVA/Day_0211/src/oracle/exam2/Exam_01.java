package oracle.exam2;

import java.util.*;
import oracle.dao.SawonDAO;
import oracle.dto.DeptVO;

public class Exam_01 {
	public static void main(String[] args) {
		SawonDAO dao = new SawonDAO();
		List<DeptVO> list = dao.deptList();
		if(list.size() == 0) {
			System.out.println("등록된 자료가 없음");
		}else {
			for(int x=0; x<list.size(); x++) {
				System.out.print(list.get(x).getDno()+"\t");
				if(list.get(x).getDname().length()<8) {
					System.out.print(list.get(x).getDname()+"\t\t");
				}else {
					System.out.print(list.get(x).getDname()+"\t");
				}
				System.out.print(list.get(x).getLoc()+"\n");
			}
		}
		
	}
}
