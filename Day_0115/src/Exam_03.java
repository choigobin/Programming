import java.util.Scanner;

/*	키보드로 10진수, 변환할 진수 입력 다음과 같이 출력하는 클래스를 작성하시오.
 * 	1.[ 입력 예시 ]		2.[ 입력 예시 ]		3.[ 입력 예시 ]
 * 	  10진수 : 25		  10진수 : 45		  10진수 : 45
 *	    변환 : 2		    변환 : 8		     변환 : 16
 *  1.[ 입력 예시 ]		2.[ 입력 예시 ]		3.[ 입력 예시 ]
 * 	  10진수 : 25		  10진수 : 45		  10진수 : 25
 *	  2진수   : 11001	  8진수   : 55		  16진수 : 2D
 */
class ConvNumber{
	int dec;
	int conv;
	String x;
	ConvNumber(int dec,int conv){
		this.dec = dec;
		this.conv = conv;
	}
	void swap() {
		switch (dec%conv) {
		case 10:
			x="A";
			break;
		case 11:
			x="B";
			break;
		case 12:
			x="C";
			break;
		case 13:
			x="D";
			break;
		case 14:
			x="E";
			break;
		case 15:
			x="F";
			break;
		}
	}
	String coversion() {
		String jinsu = "";
		while(true) {
			if(dec/conv!=0) {
				if(dec%conv>9) {
					swap();
					jinsu=x+jinsu;
				}else {
					jinsu=dec%conv+jinsu;
				}
				dec=dec/conv;
			}else {
				if(dec%conv>9) {
					swap();
					jinsu=x+jinsu;
					break;
				}else {
					jinsu=dec+jinsu;
					break;
				}
			}
		}	
		return jinsu;
	}
}

public class Exam_03 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("10진수 : ");
		int dec = sc.nextInt();
		int conv =0;
		while(conv!=2 && conv!=8 && conv!=16) {
			System.out.print("변환 : ");
			conv = sc.nextInt();
		}
		sc.close();
		//입력
		
		ConvNumber con = new ConvNumber(dec, conv);
		System.out.println("10진수 : "+dec);
		System.out.println(conv+"진수 : "+con.coversion());
	}
	
}
