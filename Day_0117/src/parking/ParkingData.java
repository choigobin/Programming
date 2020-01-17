package parking;

public class ParkingData {
	
	static void calMoney(Parking park) {
		int x = park.parkTime;
		park.money = 500;
		if(park.parkTime>1440) {
			park.parkTime = 1440;
			park.money = 30000;
		}else if(park.parkTime>30) {
			x-=30;
			park.money += (x/10)*500;
			park.money += ((x%10+9)/10)*500;
		}
		if(park.money>30000) {
			park.money=30000;
		}
		
	}
	
	static void print(Parking[] park, int cnt) {
		int x = 0;
		System.out.println("자동차번호\t주차시간\t주차요금");
		for(int i=0; i<cnt; i++) {
			System.out.print(park[i].carNo+"\t"+park[i].parkTime+"\t");
			System.out.printf("%,d",park[i].money);
			System.out.println();
			x += park[i].money;
		}
		System.out.println("총 이용대수 : "+cnt+"\t총 수입 : "+String.format("%,d", x));
	}
	
}
