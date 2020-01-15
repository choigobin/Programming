public class Exam_04 {
	public static void main(String[] args) {
		
		int[][] hak = {{1,90,89,79},{2,55,69,76}
		,{3,40,79,72},{4,22,33,64}};
		
		String[] name = {"AAA","BBB","CCC","DDD"};
		
		System.out.println("¹øÈ£\tÀÌ¸§\t±¹¾î\t¿µ¾î\t¼öÇÐ");
		
		for(int x = 0; x < hak.length; x++) {
			System.out.print(hak[x][0]+"\t");
			System.out.print(name[x]+"\t");
			for(int y = 1; y < hak[x].length; y++) {
				System.out.print(hak[x][y]+"\t");
			}
			System.out.println();
		}
		
		
		
		
		
		
		
		
	}
}