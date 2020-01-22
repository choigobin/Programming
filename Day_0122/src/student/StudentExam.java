package student;

import java.util.Scanner;
/*
6, 김육번, 95, 20, 40
1, 김일번, 50, 45, 60
5, 박오번, 95, 20, 40
4, 차사번, 25, 56, 20
7, 최칠번, 100, 95, 50
2, 송이번, 26, 26, 56
9, 박구번, 45, 59, 89
3, 강삼번, 89, 56, 12
10, 나십번, 56, 54, 23
8, 구팔번, 40, 65, 56
 */
public class StudentExam {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Student[] st = new Student[10];
		int cnt = 0;
		while(cnt<10) {
		while (cnt < 10) {
			System.out.print("입력 : ");
			String s = sc.nextLine();
			st[cnt] = new Student();
			char[] bun = s.split(",")[0].toCharArray();
			// 번호 검증
			if (bun.length == 1) {
				if (bun[0] > 48 && bun[0] < 58) {
					st[cnt].bun = Integer.parseInt(s.split(",")[0]);
				} else {
					System.out.println("번호 오류입니다.");
					break;
				}
			} else if (bun.length == 2) {
				if (bun[0] > 48 && bun[0] < 58) {
					if (bun[1] == 48) {
						st[cnt].bun = Integer.parseInt(s.split(",")[0]);
					} else {
						System.out.println("번호 오류입니다.");
						break;
					}
				} else {
					System.out.println("번호 오류입니다.");
					break;
				}
			} else {
				System.out.println("번호 오류입니다.");
				break;
			}
			// 이름 검증
			if (s.split(",")[1].trim().length() < 11) {
				st[cnt].name = s.split(",")[1].trim();
			} else {
				System.out.println("이름 오류입니다.");
				break;
			}
			// 국어점수 검증
			bun = s.split(",")[2].trim().toCharArray();
			if (bun.length == 1) {
				if (bun[0] > 47 && bun[0] < 58) {
					st[cnt].score[0] = Integer.parseInt(s.split(",")[2].trim());
				} else {
					System.out.println("점수 오류입니다.");
					break;
				}
			} else if (bun.length == 2) {
				if (bun[0] > 48 && bun[0] < 58) {
					if (bun[0] > 47 && bun[0] < 58) {
						st[cnt].score[0] = Integer.parseInt(s.split(",")[2].trim());
					} else {
						System.out.println("점수 오류입니다.");
						break;
					}
				} else {
					System.out.println("점수 오류입니다.");
					break;
				}
			} else if (s.split(",")[2].trim().equals("100")) {
				st[cnt].score[0] = Integer.parseInt(s.split(",")[2].trim());
			} else {
				System.out.println("점수 오류입니다.");
				break;
			}
			// 영어점수 검증
			bun = s.split(",")[3].trim().toCharArray();
			if (bun.length == 1) {
				if (bun[0] > 47 && bun[0] < 58) {
					st[cnt].score[1] = Integer.parseInt(s.split(",")[3].trim());
				} else {
					System.out.println("점수 오류입니다.");
					break;
				}
			} else if (bun.length == 2) {
				if (bun[0] > 48 && bun[0] < 58) {
					if (bun[0] > 47 && bun[0] < 58) {
						st[cnt].score[1] = Integer.parseInt(s.split(",")[3].trim());
					} else {
						System.out.println("점수 오류입니다.");
						break;
					}
				} else {
					System.out.println("점수 오류입니다.");
					break;
				}
			} else if (s.split(",")[3].trim().equals("100")) {
				st[cnt].score[1] = Integer.parseInt(s.split(",")[3].trim());
			} else {
				System.out.println("점수 오류입니다.");
				break;
			}
			// 수학점수 검증
			bun = s.split(",")[4].trim().toCharArray();
			if (bun.length == 1) {
				if (bun[0] > 47 && bun[0] < 58) {
					st[cnt].score[2] = Integer.parseInt(s.split(",")[4].trim());
				} else {
					System.out.println("점수 오류입니다.");
					break;
				}
			} else if (bun.length == 2) {
				if (bun[0] > 48 && bun[0] < 58) {
					if (bun[0] > 47 && bun[0] < 58) {
						st[cnt].score[2] = Integer.parseInt(s.split(",")[4].trim());
					} else {
						System.out.println("점수 오류입니다.");
						break;
					}
				} else {
					System.out.println("점수 오류입니다.");
					break;
				}
			} else if (s.split(",")[4].trim().equals("100")) {
				st[cnt].score[2] = Integer.parseInt(s.split(",")[4].trim());
			} else {
				System.out.println("점수 오류입니다.");
				break;
			}
			cnt++;

		}
		}
		sc.close();
		School sch = new School(st, cnt);
		sch.print();

	}

}
