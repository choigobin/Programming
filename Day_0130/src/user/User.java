package user;
public class User {
	String name;
	String userid;
	String email;
	int bun;
	
	@Override
	public boolean equals(Object obj) {
		User x = (User)obj;
		if(userid.equals(x.userid)) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		StringBuffer data = new StringBuffer();
		data.append(bun+"\t");
		data.append(name+"\t");
		data.append(userid+"\t");
		data.append(email);
		return data.toString();
	}
	
}
