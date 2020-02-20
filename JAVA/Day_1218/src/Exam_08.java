/*	논리연산자(&&,||)
 * 	비트논리연산자(&,|)
 */
public class Exam_08 {

	public static void main(String[] args) {
		//System.out.println("7>8 && 7<9 = " + (7>8 && 7<9));//7>8이 F기 때문에 7<9는 필요없다고 노란줄
		System.out.println("7>8 & 7<9 = " + (7>8 & 7<9));//비트연산자도 논리연산자처럼 사용가능
		/*	하지만 위(&&)의 경우 7>8, 7<9중에서 7>8이 false이면 뒤는 계산하지 않음
		 * 	아래(&)의 경우 7>8, 7<9 둘다 판단한뒤 false가 나오므로 흐름(속도)에 차이가 있음
		 */
		
		//System.out.println("7&&8 = " + (7&&8)); //7이 true 인지 false인지 몰라서 에러
		System.out.println("7&8 = " + (7&8)); // 2진수로 바꿔서 연산됨

	}

}

