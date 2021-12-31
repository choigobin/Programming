package lotto;

import java.util.Random;

public class Lotto {
	int[] bun = new int[6];
	Random r = new Random();
	Lotto() {
		for(int i=0; i<6; i++) {
			bun[i] = r.nextInt(45)+1;
			for(int j=i-1;j>=0;j--) {//중복체크
				if(bun[i]==bun[j]) {
					i--;
					break;
				}
			}
			
		}
		sort();
	}
	void sort() {
		for(int s=0;s<6;s++) {
			for(int s2=s+1;s2<6;s2++) {
				if(bun[s]>bun[s2]) {
					int temp = bun[s];
					bun[s] = bun[s2];
					bun[s2] = temp;
				}
			}
		}
	}
}
