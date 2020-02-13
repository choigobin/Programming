package view;

import java.util.*;

import model.DeptaDAO;
import model.DeptaVO;

public class UI {
	DeptaDAO dao = new DeptaDAO();
	List<DeptaVO> list = null;
	//목록 리스트
	public void deptView() {
		System.out.println("DNO\tDNAME\t\tLOC");
		list = dao.selectAll();
		for(DeptaVO vo : list) {
			System.out.print(vo.getDno()+"\t");
			if(vo.getDname().length()>7) {
				System.out.print(vo.getDname()+"\t");
			}else {
				System.out.print(vo.getDname()+"\t\t");
			}
			System.out.println(vo.getLoc());
		}
	}
	//등록
	public void deptInsert(Scanner scn) {
		System.out.println("부서정보 등록");
		System.out.print("부서번호 : ");
		int dno = scn.nextInt();
		System.out.print("부서명 : ");
		String dname = scn.next();
		System.out.print("지역명 : ");
		String loc = scn.next();
		//db 등록 처리 메소드 호출
		dao.insert(dno, dname, loc);
		System.out.println("등록 완료");
	}
	//검색
	public void deptSelect(Scanner scn) {
		System.out.println("부서명 검색");
		System.out.print("부서번호 : ");
		int dno = scn.nextInt();
		DeptaVO vo = dao.select(dno);
		System.out.println("DNO\tDNAME\t\tLOC");
		System.out.print(vo.getDno()+"\t");
		if(vo.getDname().length()>7) {
			System.out.print(vo.getDname()+"\t");
		}else {
			System.out.print(vo.getDname()+"\t\t");
		}
		System.out.println(vo.getLoc());
	}
	//수정
	public void deptUpdate(Scanner scn) {
		System.out.println("부서정보 수정");
		System.out.print("해당 부서번호 : ");
		int dno = scn.nextInt();
		System.out.print("부서명 : ");
		String dname = scn.next();
		System.out.print("지역명 : ");
		String loc = scn.next();
		//db 등록 처리 메소드 호출
		dao.update(dno, dname, loc);
		System.out.println("수정 완료");
	}
	//삭제
	public void deptDelete(Scanner scn) {
		System.out.println("부서 삭제");
		System.out.print("부서번호 : ");
		int dno = scn.nextInt();
		dao.delete(dno);
		System.out.println("삭제 완료");
	}
}
