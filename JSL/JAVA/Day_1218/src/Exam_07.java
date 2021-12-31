/*	비트 연산자 
 * 	<<, >>, &(and), |(or), ^(xor), ~((보수, not)- 단항연산자)
 * 	<<, >> =(이동연산자)
 */
public class Exam_07 {
	public static void main(String[] args) {
		// 10 << 2, 10>>2, 10&5, 10|5, 10^5, ~10
		// byte(1), char(2), int(4) -> 1byte=8bit -> bit(0,1)
		
		/* 
		 Bit(Binary Digit)->최소단위(1,0),2진수 => 1bit = 2가지(0 or 1)
		 nBit -> 종료 2의n승 -> 최대값 2의n승-1
		 Bit -> Byte = 1문자,8Bit, 2의8승 => 256가지(0~255), 최대값 255
		 Byte -> word = 4Byte(Full word),32Bit
		 Double word = 64bit
		 byte = 1Byte
		 char = 2Byte
		 int  = 4Byte
		 ex) int a=5 --> 00000000000000000000000000000101
		 				 x
		 				 부호비트[양(0),음(1) 구분] - 움직이지않음, 가장첫번쨰자리
		 				 
		 				 10<<1 -> 20 { *2의n승 }
		 				 0~~01010 -> 0~~010100
		 				     8 2        16 8
		 				 10>>1 -> 5 { /2의n승 } 5>>1 -> 2
		 				 0~~01010 -> 00~~0101
		 				     8 2          4 1
		 	
		 	2개다 1	1개만1	2개서로다름
		 	&		|	    ^ 
		 	1001	1001	1001
		 	0101	0101	0101
		 	----	----	----
		 	0001	1101	1100
		 	----	----	----
		 	1		13		12
		*/
		System.out.println("10<<1 =" +(10<<1));
		System.out.println("10>>1 =" +(10>>1));
		System.out.println("5>>1 =" +(5>>1));
		System.out.println((9&5));
	}

}

