package oracle.exam3;

import java.util.*;

import oracle.dao.SawonDAO;
import oracle.dto.EmpVO;

/*	OR 연산자
 * 	부서번호 또는 직급(JOB)이 같은 사원 정보 출력
 */
public class Exam_02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("부서번호 : ");
		String dno = sc.next();
		System.out.print("직급 : ");
		String job = sc.next().toUpperCase();
		sc.close();
		SawonDAO sdao = new SawonDAO();
		List<EmpVO> list = sdao.searchEmpO(dno, job);
		if(list.isEmpty()) {
			System.out.println("검색 결과가 없습니다.");
		}else {
			for(EmpVO vo : list) {
				System.out.print(vo.getEno()+"\t");
				System.out.print(vo.getEname()+"\t");
				if(vo.getJob().length()>7) {
					System.out.print(vo.getJob()+"\t");
				}else {
					System.out.print(vo.getJob()+"\t\t");
				}
				System.out.print(vo.getManager()+"\t");
				System.out.print(vo.getHiredate()+"\t");
				System.out.print(vo.getSalary()+"\t");
				System.out.print(vo.getCommission()+"\t");
				System.out.print(vo.getDno()+"\n");
			}
		}
		
		
		
	}
}
