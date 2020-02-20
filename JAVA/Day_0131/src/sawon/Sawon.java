package sawon;

import java.text.DecimalFormat;

public class Sawon {
	int bun;
	String name;
	int pay;
	static int sum;
	static DecimalFormat df = new DecimalFormat("'￦'#,###");
	@Override
	public String toString() {
		StringBuilder data = new StringBuilder();
		data.append(bun+"\t");
		data.append(name+"\t");
		data.append(df.format(pay));
		return data.toString();
	}
}
