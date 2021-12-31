package oracle.exam3;

import java.util.Scanner;

import oracle.dao.SawonDAO;
import oracle.dto.EmpVO;

/*	AND 연산자
 * 	키보드로 부서번호, 직급을 입력
 * 	해당 사원정보 출력
 */
public class Exam_01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("부서번호 : ");
		String dno = sc.next();
		System.out.print("직급 : ");
		String job = sc.next().toUpperCase();
		sc.close();
		SawonDAO sdao = new SawonDAO();
		EmpVO vo = sdao.searchEmp(dno, job);
		if(vo==null) {
			System.out.println("검색 결과가 없습니다.");
		}else {
			System.out.print(vo.getEno()+"\t");
			System.out.print(vo.getEname()+"\t");
			System.out.print(vo.getJob()+"\t");
			System.out.print(vo.getManager()+"\t");
			System.out.print(vo.getHiredate()+"\t");
			System.out.print(vo.getSalary()+"\t");
			System.out.print(vo.getCommission()+"\t");
			System.out.print(vo.getDno()+"\n");
		}
		
		
	}
}
