package student;

public class StudentHak extends Student{
	int cnt;
	public StudentHak(int bun, String name, int[] jum, int cnt) {
		super(bun, name, jum);
		this.cnt = cnt;
	}
	@Override
	public void account() {// 총점,평균(소수점2자리)를 계산 후 출력하는 메소드
		tot=0;
		for(int i=0; i<cnt; i++) {
			tot+=jum[i];
		}
		ave = (int)((double)tot/cnt*100+0.5)/100.;
		title();
		System.out.println(bun+"\t"+name+"\t"+tot+"\t"+ave+"\n");	
	}
	@Override
	public void scoreMax() {// 점수 최대,최소를 구하여 출력하는 메소드
		int max= jum[0];
		int min= jum[0];
		for(int i=1; i<cnt; i++) {
			if(max<jum[i]) {
				max=jum[i];
			}
			if(min>jum[i]) {
				min=jum[i];
			}
		}
		System.out.println("최대 : "+max+"     최소 : "+min);
	}
	@Override
	public void scoreSelection() {// 선택정렬을 이용하여 점수 오름차순
		int[] selection = jum;
		for(int i=0; i<cnt-1; i++) {
			for(int j=i+1; j<cnt; j++) {
				if(selection[i]>selection[j]) {
					int temp = selection[i];
					selection[i] = selection[j];
					selection[j] = temp;
				}
			}
		}
		System.out.print("점수(선택,오름) : ");
		for(int i=0; i<cnt; i++) {
			System.out.print(selection[i]+"\t");
		}
		System.out.println();
	}
	@Override
	public void scoreBubble() {// 버블정렬을 이용하여 점수 내림차순
		int[] bubble = jum;
		for(int i=0;i<cnt;i++) {
			for(int j=cnt-1;j>i;j--) {
				if(bubble[j]>bubble[j-1]) {
					int temp = bubble[j];
					bubble[j] = bubble[j-1];
					bubble[j-1] = temp;
				}
			}
		}
		System.out.print("점수(버블,내림) : ");
		for(int i=0; i<cnt; i++) {
			System.out.print(bubble[i]+"\t");
		}
		System.out.println();
	}
	
}
