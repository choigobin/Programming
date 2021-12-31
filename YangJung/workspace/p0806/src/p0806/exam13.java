package p0806;

public class exam13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n,sum=0;
		System.out.println("1부터 n까지의 합중에서 5000을 넘지 않는 가장 큰 합은?");
		for(n=1;sum+n<=5000;n++) {
			sum=sum+n;
		}
		System.out.println("1부터"+n+"까지의 합이 "+sum+"입니다.");
	
	
	}
}
