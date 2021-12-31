package model;

public class InsertBean {
	private String userid;
	private String name;
	private String email;
	private String regdate;
	private String[] season;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String[] getSeason() {
		return season;
	}
	public void setSeason(String[] season) {
		this.season = season;
	}
	public String getSeasonSTR() {
		String x = "없습니다.";
		if(season!=null) {
			x= season[0];
			for(int i = 1; i<season.length;i++) {
				x += ","+season[i];
			}
		}
		return x;
	}
	
}
