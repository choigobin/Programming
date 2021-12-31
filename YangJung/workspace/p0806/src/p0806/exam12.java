package p0806;

public class exam12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i,j,sum;
		sum=1;
		
		for(i=1;i<=10;i++) {
			System.out.print("1");
			for(j=2;j<=i;j++) {
				System.out.print(" * "+j);
				sum=sum*j;
			}
			System.out.print(" = "+sum);
			sum=1;
			System.out.printf("\n");
		}
		
		
		
	}

}
