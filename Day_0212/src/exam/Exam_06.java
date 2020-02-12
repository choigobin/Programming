package exam;

import java.util.*;

import model.*;

public class Exam_06 {
	public static void main(String[] args) {
		DataDAO dao = new DataDAO();
		List<EmpVO> list = dao.exam_06();
		if(list.isEmpty()) {
			System.out.println("검색결과가 없습니다");
		}else {
			System.out.println("ENAME\tJOB\t\tHIREDATE");
			for(EmpVO vo : list) {
				System.out.print(vo.getEname()+"\t");
				if(vo.getJob().length()>7) {
					System.out.print(vo.getJob()+"\t");
				}else {
					System.out.print(vo.getJob()+"\t\t");
				}
				System.out.print(vo.getHiredate()+"\n");
			}
		}
		
	}
}
