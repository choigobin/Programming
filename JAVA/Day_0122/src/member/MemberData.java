package member;

public class MemberData {
	int cnt;
	Member[] list;
	String[] sex;
	int[] age;
	MemberData(Member[] list,int cnt){
		this.list = list;
		this.cnt = cnt;
		this.sex = new String[cnt];
		this.age = new int[cnt];
	}
	void calSex() {
		for(int i=0;i<cnt;i++) {
			switch (Integer.parseInt(list[i].sex)) {
			case 1:
				sex[i] = "남자";
				break;
			case 2:
				sex[i] = "여자";
				break;
			case 3:
				sex[i] = "남자";
				break;
			case 4:
				sex[i] = "여자";
				break;
			case 5:
				sex[i] = "남자";
				break;
			case 6:
				sex[i] = "여자";
				break;
			case 7:
				sex[i] = "남자";
				break;
			case 8:
				sex[i] = "여자";
				break;
			default:
				break;
			}
		}
	}
	void calAge() {
		for(int i=0;i<cnt;i++) {
			int x = Integer.parseInt(list[i].sex);
			int age = Integer.parseInt(list[i].birth.substring(0,2));
			if(x==1||x==2||x==5||x==6) {
				age+=1900;
			}else {
				age+=2000;
			}
			this.age[i] = 2020-age;
		}
	}
	void print(){
		calSex();
		calAge();
		System.out.println("입력\t전화\t\t성별\t나이");
		for(int i=0;i<cnt;i++) {
			System.out.print(list[i].name+"\t");
			System.out.print(list[i].tel+"\t");
			System.out.print(sex[i]+"\t");
			System.out.print(age[i]+"\n");
		}	
	}
	
	
}
