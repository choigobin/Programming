package parking;

import java.util.Scanner;

public class ParkingExam {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt=0;
		Parking park[] = new Parking[100];
		while(cnt<100) {
			park[cnt] = new Parking();
			System.out.print("주차정보 : ");
			park[cnt].carNo = sc.next();
			if(park[cnt].carNo.equals("0000")) break;
			park[cnt].parkTime = sc.nextInt();
			sc.nextLine();
			ParkingData.calMoney(park[cnt]);
			cnt++;
		}
		sc.close();
		ParkingData.print(park, cnt);

	}

}
