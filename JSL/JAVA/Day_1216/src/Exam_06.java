/*		번호		이름		점수
 *  	01		홍길동	90
 */
public class Exam_06 {

	public static void main(String[] args) {
		System.out.print("번호\t이름\t점수\n");
		System.out.print("01\t");
		System.out.print("홍길동\t");
		System.out.print(90);
		System.out.println();
		System.out.printf("%10s\n",123); // 형식지정 출력 (%s 문자로 변환해라),(%10s 10자리를 잡아서 출력하라)
		System.out.printf("10진수 = %d\n",10); // %d 10진수로 바꿔서 출력하라
		System.out.printf("8진수 = %o\n",10); // %o 8진수로 바꿔서 출력하라
		System.out.printf("16진수 = %x\n",10); // %x 16진수로 바꿔서 출력하라

	}

}
