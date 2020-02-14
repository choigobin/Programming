package sawon.view;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import sawon.model.DAO;
import sawon.model.DTO;

public class UI {
	DAO dao = DAO.getInstance();

	private static DTO convert(DTO dto) {
		if (dto.getHiredate() != null) {
			String date = dto.getHiredate().substring(2, 4) + "/" + dto.getHiredate().substring(5, 7) + "/"
					+ dto.getHiredate().substring(8, 10);
			dto.setHiredate(date);
		}
		return dto;
	}

	// 사원 전체 목록
	public char select() throws IOException {
		System.out.println("***  사원  전체  목록  *** ");
		List<DTO> list = dao.select();
		System.out.println("사원번호\t이름\t업무명\t\t상사번호\t입사일자\t\t급여\t커미션\t부서명");
		for (DTO dto : list) {
			dto = UI.convert(dto);
			System.out.print(dto.getEno() + "\t");
			System.out.print(dto.getEname() + "\t");
			if (dto.getJob()!=null && dto.getJob().length() > 7) {
				System.out.print(dto.getJob() + "\t");
			} else {
				System.out.print(dto.getJob() + "\t\t");
			}
			if (dto.getManager() == 0) {
				System.out.print("\t");
			} else {
				System.out.print(dto.getManager() + "\t");
			}
			System.out.print(dto.getHiredate() + "\t");
			System.out.print(dto.getSalary() + "\t");
			if (dto.getCommission() == 0) {
				System.out.print("\t");
			} else {
				System.out.print(dto.getCommission() + "\t");
			}
			System.out.print(dto.getDname() + "\n");
		}
		System.out.println("메인메뉴로 이동합니다(Enter) ? ");
		char answer = (char) System.in.read();
		return answer;
	}

	// 사원 등록
	public void insert(Scanner scn) throws IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(new Date());
		List<DTO> list = DAO.getInstance().selectDept();
		System.out.println("*** 신규 사원 정보 등록 ***");
		DTO dto = new DTO();
		System.out.print("사원이름 : ");
		dto.setEname(scn.next());
		System.out.print("업 무 명  : ");
		dto.setJob(scn.next());
		System.out.print("상사번호 : ");
		dto.setManager(scn.nextInt());
		scn.nextLine();
		System.out.print("입사일자(" + date + ") : ");
		String str = scn.nextLine();
		if (str.equals("")) {
			dto.setHiredate(date);
		} else {
			dto.setHiredate(str);
		}
		System.out.print("급      여 : ");
		dto.setSalary(scn.nextInt());
		System.out.print("커 미 션  : ");
		dto.setCommission(scn.nextInt());
		System.out.print("부서정보(");
		List<Integer> check = new ArrayList<Integer>();
		for (int x = 0; x < list.size(); x++) {
			check.add(list.get(x).getDno());
			if (x == list.size() - 1) {
				System.out.print(list.get(x).getDno() + ":" + list.get(x).getDname());
			} else {
				System.out.print(list.get(x).getDno() + ":" + list.get(x).getDname());
				System.out.print(", ");
			}
		}
		System.out.println(")");
		System.out.print("부서번호 : ");
		int dno = scn.nextInt();
		scn.nextLine();
		if (check.contains(dno)) {
			dto.setDno(dno);
		} else {
			System.out.println("부서번호 오류");
			return;
		}
		System.out.print("등록하시겠습니까(y/n) ? ");
		if (scn.nextLine().toUpperCase().equals("Y")) {
			dao.insert(dto);
			System.out.println("등록 완료");
		} else {
			System.out.println("등록 취소");
		}
	}

	// 사원검색
	public String selectEMP(Scanner scn) {
		DTO dto = new DTO();
		System.out.println("*** 사원 정보 검색 ***");
		System.out.println("검색할 사원 이름을 입력하세요 ? ");
		System.out.print("사원번호 : ");
		dto.setEno(scn.nextInt());
		scn.nextLine();
		System.out.print("사원이름 : ");
		dto.setEname(scn.nextLine());
		dto = dao.select(dto);
		if (dto.getJob() == null) {
			System.out.println("등록된 사원이 없습니다.");
		} else {
			System.out.println("업 무 명  : " + dto.getJob());
			System.out.println("상사이름 : " + dto.getEname());
			System.out.println("입사일자 : " + dto.getHiredate());
			System.out.println("급     여  : " + dto.getSalary());
			System.out.println("커 미 션  : " + dto.getCommission());
			System.out.println("부 서 명  : " + dto.getDname());
		}
		System.out.print("검색을 계속 할까요?(y/n) ?");
		String answer = scn.nextLine().toUpperCase();
		return answer;
	}

	// 사원 수정
	public void update(Scanner scn) {
		System.out.println("*** 사원 정보 수정 ***");
		System.out.println("수정할 사원 이름을 입력하세요 ? ");
		System.out.print("사원번호 : ");
		DTO dto = dao.select(scn.nextInt());
		scn.nextLine();
		String str;
		if (dto.getEno()==0) {
			System.out.println("해당 사원이 없습니다.");
		} else {
			System.out.print("사원이름(" + dto.getEname() + ") : ");
			str = scn.nextLine();
			if (str.length() != 0)
				dto.setEname(str);
			str = null;
			System.out.print("업 무 명 (" + dto.getJob() + ") : ");
			str = scn.nextLine();
			if (str.length() != 0)
				dto.setJob(str);
			str = null;
			System.out.print("상사번호(" + dto.getManager() + ") : ");
			str = scn.nextLine();
			if (str.length() != 0)
				dto.setManager(Integer.parseInt(str));
			str = null;
			System.out.print("입사일자(" + dto.getHiredate() + ") : ");
			str = scn.nextLine();
			if (str.length() != 0)
				dto.setHiredate(str);
			str = null;
			System.out.print("급      여(" + dto.getSalary() + ") : ");
			str = scn.nextLine();
			if (str.length() != 0)
				dto.setSalary(Integer.parseInt(str));
			str = null;
			System.out.print("커 미 션 (" + dto.getCommission() + ") : ");
			str = scn.nextLine();
			if (str.length() != 0)
				dto.setCommission(Integer.parseInt(str));
			str = null;
			System.out.print("부서정보(");
			List<DTO> list = DAO.getInstance().selectDept();
			List<Integer> check = new ArrayList<Integer>();
			for (int x = 0; x < list.size(); x++) {
				check.add(list.get(x).getDno());
				if (x == list.size() - 1) {
					System.out.print(list.get(x).getDno() + ":" + list.get(x).getDname());
				} else {
					System.out.print(list.get(x).getDno() + ":" + list.get(x).getDname());
					System.out.print(", ");
				}
			}
			System.out.println(")");
			System.out.print("부서번호(" + dto.getDno() + ") : ");
			str = scn.nextLine();
			if (str.length() != 0)
				dto.setDno(Integer.parseInt(str));
			str = null;
			System.out.print("수정하시겠습니까?(y/n) ?");
			if (scn.nextLine().toUpperCase().equals("Y")) {
				dao.update(dto);
			}
		}
	}
	//삭제 
	public void delete(Scanner scn) {
		DTO dto = new DTO();
		System.out.println("*** 사원 정보 검색 ***");
		System.out.println("삭제할 사원 이름을 입력하세요 ? ");
		System.out.print("사원번호 : ");
		dto.setEno(scn.nextInt());
		scn.nextLine();
		System.out.print("사원이름 : ");
		dto.setEname(scn.nextLine());
		dto = dao.select(dto);
		if (dto.getEno()==0) {
			System.out.println("등록된 사원이 없습니다.");
		} else {
			System.out.println("업 무 명  : " + dto.getJob());
			System.out.println("상사이름 : " + dto.getEname());
			System.out.println("입사일자 : " + dto.getHiredate());
			System.out.println("급     여  : " + dto.getSalary());
			System.out.println("커 미 션  : " + dto.getCommission());
			System.out.println("부 서 명  : " + dto.getDname());
		}
		System.out.print("삭제 할까요?(y/n) ?");
		if(scn.nextLine().toUpperCase().equals("Y")) {
			dao.delete(dto);
		}
	}
}
