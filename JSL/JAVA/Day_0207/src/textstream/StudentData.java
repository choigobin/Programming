package textstream;

import java.util.Iterator;
import java.util.TreeSet;
public class StudentData {
	TreeSet<Student> list;
	StudentData(){}
	StudentData(TreeSet<Student> list){
		this.list = list;
	}
	String[] outPut() {
		String[] str = new String[list.size()];
		Iterator<Student> iter = list.iterator();
		for(int i=0; i<str.length; i++) {
			Student st=iter.next();
			int tot = st.kor+st.eng+st.mat;
			double ave = (int)(tot/3.*100+0.5)/100.;
			String gender="";
			switch (st.gender.toUpperCase()) {
			case "M":
				gender = "남자";
				break;
			case "F":
				gender = "여자";
				break;	
			default:
				break;
			}
			str[i] = st.bun+"\t"+st.name+"\t"+gender+"\t"+st.kor+"\t"+st.eng+"\t"+st.mat+"\t"+tot+"\t"+ave;
		}
		return str;
	}
	
}
