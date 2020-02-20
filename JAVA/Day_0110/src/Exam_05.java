/*	Java : 90	67	78	89	xxx	xx.xx
 * 
 */
public class Exam_05 {
	public static void main(String[] args) {
		String name = "Java";
		int score[] = {90,67,78,89};
		aaa(name,score);
	}
	
	static void aaa(String n,int[] s) {
		System.out.print(n+" : ");
		int sum=0;
		for(int x=0;x<s.length;x++) {
			System.out.print(s[x]+"\t");
			sum += s[x];
		}
		System.out.print(sum+"\t");
		System.out.println(((int)(((double)sum/s.length)*100+0.5))/100.+"\n");
		
	}
	
}
