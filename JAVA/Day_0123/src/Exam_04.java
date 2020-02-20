/* 
 * 
 */
public class Exam_04 {
	public static void main(String[] args) {
//		char c=''; // 이게 에러가 나는 이유는, 1개의 문자를 받아야 하는데 공백은 인식할 수 없다.
		System.out.println("int가 가질 수 있는 최대 값 : "+Integer.MAX_VALUE);
		System.out.println("size (bit): "+Integer.SIZE);
		
		int a=25;
		String bin = Integer.toBinaryString(a);
		String oct = Integer.toOctalString(a);
		String hex = Integer.toHexString(a);
		
		System.out.println("10진수 "+a+"-> 2진수 변환 :"+bin);
		System.out.println("10진수 "+a+"-> 8진수 변환 :"+oct);
		System.out.println("10진수 "+a+"-> 16진수 변환 :"+hex);
		System.out.println();
		
		int dec1= Integer.parseInt(bin, 2);
		System.out.println("2진수 "+bin+"-> 10진수 변환 :"+dec1);
		int dec2= Integer.parseInt(oct, 8);
		System.out.println("8진수 "+oct+"-> 10진수 변환 :"+dec2);
		int dec3= Integer.parseInt(hex, 16);
		System.out.println("16진수 "+hex+"-> 10진수 변환 :"+dec3);
	}

}