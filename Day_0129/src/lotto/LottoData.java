package lotto;

public class LottoData {
	private Lotto[] lotto;
	int[] answer = new int[7];
	private String[] result;

	LottoData(Lotto[] lotto) {
		this.lotto = lotto;
		this.result = new String[lotto.length];
	}

	void makeAnser() {
		Lotto x = new Lotto();
		for (int i = 0; i < 6; i++) {
			answer[i] = x.bun[i];
		}
		int check = 0;
		while (check < 6) {
			answer[6] = (int) (Math.random() * 45 + 1);
			for (int i = 0; i < 6; i++) {
				if (answer[6] == answer[i]) {
					break;
				} else {
					check++;
				}
			}
		}
	}

	void calResult() {
		for (int i = 0; i < lotto.length; i++) {
			int point = 0;
			for (int g = 0; g < 6; g++) {
				for (int g1 = 0; g1 < 6; g1++) {
					if (lotto[i].bun[g] == answer[g1]) {
						point++;
					}
				}
			}
			switch (point) {
			case 6:
				result[i] = "1등";
				break;
			case 5:
				result[i] = "3등";
				for (int z = 0; z < 6; z++) {
					if (lotto[i].bun[z] == answer[6]) {
						result[i] = "2등";
					}
				}
				break;
			case 4:
				result[i] = "4등";
				break;
			case 3:
				result[i] = "5등";
				break;
			default:
				result[i] = "꽝";
				break;
			}
		}
	}

	void printLotto() {
		calResult();
		System.out.print("당첨번호 : ");
		for (int i = 0; i < 5; i++) {
			System.out.print(answer[i] + ",");
		}
		System.out.println(answer[5] + " - 보너스 " + answer[6]);
		for (int i = 0; i < lotto.length; i++) {
			System.out.print((i + 1) + ": ");
			for (int z = 0; z < 5; z++) {
				System.out.print(lotto[i].bun[z] + ",");
			}
			System.out.println(lotto[i].bun[5] + " -- " + result[i]);
		}
	}

}
