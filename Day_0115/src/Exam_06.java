public class Exam_06 {
	public static void main(String[] args) {
		Hak[] stu = new Hak[5];
		Hak h1 = new Hak();
		h1.bun = 1;
		h1.name = "홍길동";
		h1.score = 99;
		Hak h2 = new Hak(2,"최문환",8);
		stu[0] = h1;
		stu[1] = h2;
		stu[2] = new Hak(3,"최문구",18);
		stu[3] = new Hak(4,"최구환",28);
		stu[4] = new Hak(5,"문구라",38);
		
		for(int i=0; i<stu.length; i++) {
			stu[i].print();
		}
		System.out.println("-------------------");
		HakData data = new HakData(stu);
		data.print();
		
	}

}
