
public class Exam_02 {
	public static void main(String[] args) {
		int bun[] = new int[5];
		String[] name = new String[5];
		bun[0]=1;
		bun[1]=10;
		bun[2]=100;
		bun[3]=1000;
		bun[4]=10000;
		name[0]="±èÀÚ¹Ù";
		name[1]="È«±æµ¿";
		name[2]="C/C++";
		name[3]="ÆÄÀÌ½ã";
		name[4]="¼­ºí¸´";
		
		for(int x=0; x<5; x++) {
			System.out.println(bun[x] + ":" + name[x]);
		}
		
	}
}
