package p0919;
import java.util.Arrays;

public class array {

	public static void main(String[] args) {
	//int [] scores = {1,2,3,4,5,6,7,8,9,10};
	//System.out.println(Arrays.toString(scores));
	
	//String[] names= {"김수안무"};
	//System.out.println(names);
	
	//names= new String[] {"강감찬","홍길동"};
	//System.out.println(Arrays.deepToString(names));
	
	int sum = 0;
	int[] scores = {1,2,3,4,5};
	for(int score:scores) {
		sum +=score;
		}
	System.out.println(sum);
	}

}
