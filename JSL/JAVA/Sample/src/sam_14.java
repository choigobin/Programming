import java.util.Scanner;
/*	순서도에서 반복문1 안의 반복문2 에서
 * 	모든 반복문을 빠져나가게 설계되어있음 
 * 	outerLoop : 라는 것을 써서 break;을 해야지 최상위 반복문 까지 탈출할 수 있다.
 *  ps) n==0 일 때 이미 반복문2 를 빠져나가는 것이다. 여기서 break;을 주고
 *  반복문 2 바깥에서 다음 식을 전개하면 된다. 그러면 outerLoop : 가 필요없다.
 *  !!!반복문2 에서 화살표가 이어진다고해서 반복문2안에서 전개되는 것이 아니라는 점!
 *  순서도 볼 때 반복문을 나가는 포인트를 잘 찾자!!
 */
public class sam_14 {
	
	public static void main(String[] args) {
		int i=2,k=0;
		Scanner sc = new Scanner(System.in);
		System.out.print("입력 : ");
		int m = sc.nextInt();
		sc.close();
		outerLoop :
		while(true) {
			int j = 2;
			while(true) {
				int n = i-(int)(i/j)*j;
				if(n==0) {
					if(i==j) {
						k++;
					}
					if(i==m) {
						System.out.println("2 ~ "+m+"까지 소수 갯수 = "+k);
						break outerLoop;	
					}
					i++;
					break;
				}else {
					j++;
				}
			}
		}
		//outerLoop 없이 하는법!
		i=2;
		k=0;
		while(true) {
			int j = 2;
			while(true) {
				int n = i-(int)(i/j)*j;
				if(n==0) {
					break;
				}else {
					j++;
				}	
			}
			if(i==j) {
				k++;
			}
			if(i==m) {
				System.out.println("2 ~ "+m+"까지 소수 갯수 = "+k);
				break;
			}
			i++;
			
		}
		
	}

}
