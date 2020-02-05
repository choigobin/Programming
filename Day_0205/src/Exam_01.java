import java.util.ArrayList;

class List{
	ArrayList<Integer> list;
	static void index(ArrayList<Integer> list, int x){
		System.out.print(x+"의 인덱스는 ");
		for(int i=0; i<list.lastIndexOf(x); i++) {
			if(list.get(i)==x) {
				System.out.print(i+",");
			}
		}
		System.out.println(list.lastIndexOf(x)+" 입니다.");
	}
}

public class Exam_01 {
	public static void main(String[] args) {
		int[] x = {89,84,90,77,95,90,65,100,90,84};
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<x.length; i++) {
			list.add(x[i]);
		}
		List.index(list,90);
		
		
		
		
		
		
	}
}