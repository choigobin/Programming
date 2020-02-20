package view;

import java.util.Scanner;
import java.util.regex.Pattern;

import model.DAO;
import model.DTO;

public class UI {
	public void insert(Scanner sc) {
		while (true) {
			System.out.println("도서대출 정보 등록");
			DTO dto = new DTO();
			System.out.print("대출번호 : ");
			dto.setLentno(sc.nextInt());
			sc.nextLine();
			System.out.print("고객성명 : ");
			dto.setCustname(sc.nextLine());
			System.out.print("연락처 : ");
			dto.setPhone(sc.nextLine());
			System.out.print("도서코드 : ");
			dto.setBookno(sc.nextInt());
			sc.nextLine();
			System.out.print("대출일자 : ");
			String outdate = sc.nextLine();
			String[] str = outdate.split("-");
			outdate = "";
			for(String s : str) {
				outdate +=s;
			}
			dto.setOutdate(outdate);
			System.out.print("반납일자 :");
			String indate = sc.nextLine();
			String[] str2 = indate.split("-");
			indate = "";
			for(String s : str2) {
				indate +=s;
			}
			if(indate.length()!=0) {
				dto.setIndate(indate);
			}else {
				indate="00000000";
			}
			System.out.print("등록합니다(y/n) ? ");
			if (sc.nextLine().toUpperCase().equals("Y")) {
				if(dto.getLentno()<1000 || dto.getLentno()>9999) {
					System.out.println("대출번호 오류");
					System.out.println("처음부터 다시 입력합니다.");
					continue;
				}
				if(!Pattern.matches("010-\\d{4}-\\d{4}", dto.getPhone())) {
					System.out.println("연락처 오류");
					System.out.println("처음부터 다시 입력합니다.");
					continue;
				}
				if(dto.getBookno()<100 || dto.getBookno()>999) {
					System.out.println("도서코드 오류");
					System.out.println("처음부터 다시 입력합니다.");
					continue;
				}
				if(!Pattern.matches("\\d{8}", dto.getOutdate())) {
					System.out.println("대출일자 오류");
					System.out.println("처음부터 다시 입력합니다.");
					continue;
				}
				if(!Pattern.matches("\\d{8}", indate)) {
					System.out.println("반납일자 오류");
					System.out.println("처음부터 다시 입력합니다.");
					continue;
				}
				DAO.getInstance().insert(dto);
				System.out.println("도서대출 정보가 등록되었습니다.");
				select();
			} else {
				System.out.println("처음부터 다시 입력합니다.");
				continue;
			}
			break;
		}
	}
	public void select() {
		System.out.println("도서대출 현황 조회");
		System.out.println("대출번호\t고객성명\t전화번호\t\t도서코드\t대출일자\t\t반납일자\t\t대출상태");
		for(DTO dto : DAO.getInstance().select()) {
			System.out.print(dto.getLentno()+"\t");
			System.out.print(dto.getCustname()+"\t");
			System.out.print(dto.getPhone()+"\t");
			System.out.print(dto.getBookno()+"\t");
			System.out.print(dto.getOutdate()+"\t");
			if(dto.getIndate().equals("null")) {
				System.out.print("\t\t");
			}else {
				String[] str = dto.getIndate().split("-");
				System.out.print(str[0]+"년"+str[1]+"월"+str[2]+"일"+"\t");
			}
			if(dto.getStatus().equals("1")) {
				System.out.println("대출중");
			}else {
				System.out.println("반납완료");
			}

		}
	}
	public void update(Scanner sc,int x) {
		while (true) {
			DTO dto = DAO.getInstance().selectNO(x);
			if(dto.getCustname()==null) {
				System.out.println("검색결과가 없습니다.");
				break;
			}
			System.out.println("도서대출 정보 수정");
			System.out.print("고객성명("+dto.getCustname()+") :");
			String ss = sc.nextLine();
			if(ss.length()!=0) {
				dto.setCustname(ss);
			}
			System.out.print("연락처("+dto.getPhone()+") : ");
			ss = sc.nextLine();
			if(ss.length()!=0) {
				dto.setPhone(ss);
			}
			System.out.print("도서코드("+dto.getBookno()+") :");
			ss = sc.nextLine();
			if(ss.length()!=0) {
				dto.setBookno(Integer.parseInt(ss));
			}
			System.out.print("대출일자("+dto.getOutdate()+") :");
			String outdate = sc.nextLine();
			String[] str = outdate.split("-");
			outdate = "";
			for(String s : str) {
				outdate +=s;
			}
			if(outdate.length()!=0) {
				dto.setOutdate(outdate);
			}
			if(dto.getIndate().equals("null")) {
				System.out.print("반납일자() :");
			}else {
				System.out.print("반납일자("+dto.getIndate()+") :");
			}
			String indate = sc.nextLine();
			String[] str2 = indate.split("-");
			indate = "";
			for(String s : str2) {
				indate +=s;
			}
			if(indate.length()!=0) {
				dto.setIndate(indate);
			}else {
				indate="00000000";
			}
			System.out.print("수정합니다(y/n) ? ");
			if (sc.nextLine().toUpperCase().equals("Y")) {
				if(dto.getLentno()<1000 || dto.getLentno()>9999) {
					System.out.println("대출번호 오류");
					System.out.println("처음부터 다시 입력합니다.");
					continue;
				}
				if(!Pattern.matches("010-\\d{4}-\\d{4}", dto.getPhone())) {
					System.out.println("연락처 오류");
					System.out.println("처음부터 다시 입력합니다.");
					continue;
				}
				if(dto.getBookno()<100 || dto.getBookno()>999) {
					System.out.println("도서코드 오류");
					System.out.println("처음부터 다시 입력합니다.");
					continue;
				}
				if(!Pattern.matches("\\d{8}", dto.getOutdate())) {
					System.out.println("대출일자 오류");
					System.out.println("처음부터 다시 입력합니다.");
					continue;
				}
				if(!Pattern.matches("\\d{8}", indate)) {
					System.out.println("반납일자 오류");
					System.out.println("처음부터 다시 입력합니다.");
					continue;
				}
				System.out.println("도서대출 정보가 수정되었습니다.");
				DAO.getInstance().update(dto);
				select();
			} else {
				System.out.println("취소합니다.");
			}
			break;
		}
	}
	
	public void update2(Scanner sc,int x) {
		DTO dto = DAO.getInstance().selectNO(x);
		while (true) {
			if(dto.getCustname()==null) {
				System.out.println("검색결과가 없습니다.");
				break;
			}
			if(!dto.getStatus().equals("1")) {
				System.out.println("이미 반납 처리된 도서대출입니다.");
				break;
			}
			System.out.println("도서대출 반납 등록");
			System.out.println("고객성명("+dto.getCustname()+")");
			System.out.println("연락처("+dto.getPhone()+")");
			System.out.println("도서코드("+dto.getBookno()+")");
			System.out.println("대출일자("+dto.getOutdate()+")");
			System.out.print("반납일자() : ");
			String indate = sc.nextLine();
			String[] str2 = indate.split("-");
			indate = "";
			for(String s : str2) {
				indate +=s;
			}
			if(indate.length()!=0) {
				dto.setIndate(indate);
			}else {
				indate="00000000";
			}
			System.out.print("도서반납을 합니다(y/n) ? ");
			if (sc.nextLine().toUpperCase().equals("Y")) {
				if(!Pattern.matches("\\d{8}", indate)) {
					System.out.println("반납일자 오류");
					System.out.println("처음부터 다시 입력합니다.");
					continue;
				}
				DAO.getInstance().update2(dto);
				System.out.println("도서반납 처리가 완료되었습니다.");
				select();
			} else {
				System.out.println("취소합니다.");
			}
			break;
		}
	}
	
}
