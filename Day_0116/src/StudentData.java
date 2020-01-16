class StudentData{
	void rank(Student[] stu, int cnt) {
		for(int i=0;i<cnt;i++) {
			for(int j=0;j<cnt;j++) {
				if(stu[i].data[4]<stu[j].data[4]) {
					stu[i].data[6]++;
				}
			}
		}
	}
	
	void sort(Student[] stu, int cnt) {
		for(int i=0;i<cnt-1;i++) {
			for(int j=i+1;j<cnt;j++) {
				if(stu[i].data[6]>stu[j].data[6]) {
					Student temp = new Student();
					temp = stu[i];
					stu[i] = stu[j];
					stu[j] = temp;
				}
			}
		}
	}
	
	void sortPrint(Student[] stu, int cnt) {
		rank(stu,cnt);
		sort(stu,cnt);
		System.out.print("번호\t이름\t국어\t영어\t수학\t총점\t평균\t석차\n");
		for(int i=0; i<cnt; i++) {
			System.out.print((int)stu[i].data[0]+"\t");
			System.out.print(stu[i].name+"\t");
			for(int j=1; j<6; j++) {
				if(stu[i].data[j]%1==0) {
					System.out.print((int)stu[i].data[j]+"\t");
				}else {
					System.out.print(stu[i].data[j]+"\t");
				}	
			}
			System.out.print((int)stu[i].data[6]+"\n");
		}
	}
}