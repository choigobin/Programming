package student;

public class Student {
	int bun;
	String name;
	int[] data = new int[20];
	Student(String[] str){
		bun = Integer.parseInt(str[0]);
		name = str[1];
		for(int i=2; i<22;i++) {
			data[i-2] = Integer.parseInt(str[i]);
		}
	}
	
}
