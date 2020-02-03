package member;

public class Member {
	String userid;
	String name;
	int age;
	Member(){}
	Member(String userid,String name,int age){
		this.userid = userid;
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return userid+"\t"+name+"\t"+age;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member m = (Member)obj;
			return m.userid.equalsIgnoreCase(userid);
		}else {
			return false;
		}
	}
}
