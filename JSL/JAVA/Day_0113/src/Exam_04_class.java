class Hak{
	int number;
	String name;
	int kor;
	int eng;
	int mat;
	
}


public class Exam_04_class { // Exam_04를 클래스화 한것임 이전과 어떤 차이가 있는지 숙지해라
	public static void main(String[] args) {
		
		Hak[] h1 = new Hak[4]; // 클래스 배열 ( 클래스도 배열로 만들수 있음, 결국 클래스도 하나의 자료형이니까!)
		//h1[0] = 10; //이거 안됨
		h1[0] = new Hak();
		h1[1] = new Hak();
		h1[2] = new Hak();
		h1[3] = new Hak();
		
		h1[0].number = 1;
		h1[0].name = "AAA";
		h1[0].kor = 90;
		h1[0].eng = 89;
		h1[0].mat = 79;

		h1[1].number = 2;
		h1[1].name = "BBB";
		h1[1].kor = 55;
		h1[1].eng = 69;
		h1[1].mat = 76;
		
		h1[2].number = 3;
		h1[2].name = "CCC";
		h1[2].kor = 40;
		h1[2].eng = 79;
		h1[2].mat = 76;
		
		h1[3].number = 4;
		h1[3].name = "DDD";
		h1[3].kor = 22;
		h1[3].eng = 33;
		h1[3].mat = 64;
		
		int[] a = new int[4];

		
		System.out.println("번호\t이름\t국어\t영어\t수학");
		for(int x = 0; x < h1.length; x++) {
			System.out.print(h1[x].number+"\t");
			System.out.print(h1[x].name+"\t");
			System.out.print(h1[x].kor+"\t");
			System.out.print(h1[x].eng+"\t");
			System.out.print(h1[x].mat+"\n");
		}
		//이전과 비교 했을 출력부분이 간단해진다.
		//앞에는 몇번째에 뭐가 들어간다 이런걸 기억해야 하지만 여기서는 직관적으로 number가오고 뭐가오고 알수있음
		
		
		
		
		
		
		
		
	}
}