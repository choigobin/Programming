package sawon;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*	사번		이름		급여
 * 	1101	최문환	345,890
 * 		.	.	.
 * 	합계				4,234,560
 */
public class SawonExam {
	public static void main(String[] args) throws FileNotFoundException {
		int cnt = 0;
		Scanner scf = new Scanner(new File("sawon.txt"));
		while(scf.hasNextLine()) {
			scf.nextLine();
			cnt++;
		}
		Sawon[] sa = new Sawon[cnt];
		cnt =0;
		scf = new Scanner(new File("sawon.txt"));
		System.out.println("사번\t이름\t급여");
		while(scf.hasNextLine()) {
			String[] str = scf.nextLine().split(",");
			sa[cnt] = new Sawon();
			sa[cnt].bun = Integer.parseInt(str[0]);
			sa[cnt].name = str[1];
			sa[cnt].pay = Integer.parseInt(str[2]);
			Sawon.sum += sa[cnt].pay;
			System.out.println(sa[cnt]);
		}
		scf.close();
		System.out.println("합계\t\t"+Sawon.df.format(Sawon.sum));
		
	}
}
