package customer.view;

import java.io.IOException;
import java.util.*;

import customer.model.DAO;
import customer.model.DTO;

public class UI {
	DAO dao = new DAO();
	// 고객 전체 목록
	public char select() throws IOException {
		System.out.println("***  고객  전체  목록  *** ");
		List<DTO> list = dao.select();
		System.out.println("고객번호\t이름\t연락처\t\t직장명\t생년월일\t\t성별\t등록일자");
		for(DTO dto : list) {
			System.out.print(dto.getNum()+"\t");
			System.out.print(dto.getName()+"\t");
			System.out.print(dto.getTel()+"\t");
			System.out.print(dto.getOffice()+"\t");
			System.out.print(dto.getBirthday()+"\t");
			System.out.print(dto.getSex()+"\t");
			System.out.print(dto.getIndate()+"\n");
		}
		System.out.println("메인메뉴로 이동합니다(Enter) ? ");
		char answer = (char) System.in.read();
		return answer;
	}
	// 신규 고객 등록
	public void insert(Scanner scn) throws IOException {
		System.out.println("***  신규  고객  정보  등록  *** ");
		DTO dto = new DTO();
		dto.setNum(dao.count());
		System.out.print("고 객 명  : ");
		dto.setName(scn.next());
		System.out.print("연 락 처  : ");
		dto.setTel(scn.next());
		System.out.print("주     소  : ");
		dto.setAddr(scn.next());
		System.out.print("직 장 명  : ");
		dto.setOffice(scn.next());
		System.out.print("생년월일 : ");
		dto.setBirthday(scn.next());
		System.out.print("성     별  : ");
		dto.setSex(scn.next());
		System.out.println("등록하시겠습니까(y/n) ? ");
		char answer = (char) System.in.read();
		if(answer=='y' || answer=='Y') dao.insert(dto);
	}
	// 고객 정보 검색
	public char select(Scanner scn) throws IOException {
		System.out.println("***  고객  정보  검색  *** ");
		System.out.print("원하는 고객의 이름을 입력하세요 ? ");
		String name = scn.next();
		DTO dto = dao.select(name);
		if(dto!=null) {
			System.out.println("고 객 명  : "+dto.getName());
			System.out.println("연 락 처  : "+dto.getTel());
			System.out.println("주     소  : "+dto.getAddr());
			System.out.println("직 장 명  : "+dto.getOffice());
			System.out.println("생년월일 : "+dto.getBirthday());
			System.out.println("성     별  : "+dto.getSex());
			System.out.println("등록일자 : "+dto.getIndate());
		}else {
			System.out.println("등록된 고객이 없습니다");
		}
		System.out.println("메인메뉴로 이동합니다(Enter) ? ");
		char answer = (char) System.in.read();
		return answer;
	}
	// 고객 정보 수정
		public void update(Scanner scn) throws IOException {
			System.out.println("***  고객  정보  수정  *** ");
			System.out.print("수정을 원하는 고객의 번호를 입력하세요 ? ");
			int num = scn.nextInt();
			DTO dto = dao.select(num);
			if(dto!=null) {
				System.out.println("고 객 명  : "+dto.getName());
				System.out.print("연 락 처  : ");
				dto.setTel(scn.next());
				System.out.print("직 장 명  : ");
				dto.setOffice(scn.next());
				System.out.println("수정 하시겠습니까(y/n) ? ");
				char answer = (char) System.in.read();
				if(answer=='y' || answer=='Y') dao.update(dto);
			}else {
				System.out.println("등록된 고객이 없습니다.");
			}
		}
	// 고객 정보 삭제
		public void delete(Scanner scn) throws IOException {
			System.out.println("***  고객  정보  삭제  *** ");
			System.out.print("삭제를 원하는 고객의 번호를 입력하세요 ? ");
			int num = scn.nextInt();
			DTO dto = dao.select(num);
			if(dto!=null) {
				System.out.println("고 객 명  : "+dto.getName());
				System.out.println("연 락 처  : "+dto.getTel());
				System.out.println("주     소  : "+dto.getAddr());
				System.out.println("직 장 명  : "+dto.getOffice());
				System.out.println("생년월일 : "+dto.getBirthday());
				System.out.println("성     별  : "+dto.getSex());
				System.out.println("등록일자 : "+dto.getIndate());
				System.out.println("삭제 하시겠습니까(y/n) ? ");
				char answer = (char) System.in.read();
				if(answer=='y' || answer=='Y') dao.delete(dto);
			}else {
				System.out.println("등록된 고객이 없습니다.");
			}
		}
}
