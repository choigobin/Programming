public class person {
 final String nation = "Korea";
 final String ssn;
 String name;
 
 public person(String ssn, String name) {
  this.ssn = ssn;
  this.name = name;
 }
 
 public static void main(String[] args) {
	  person p1 = new person("123456-1234567", "홍길동");
	  
	  System.out.println(p1.nation);
	  System.out.println(p1.ssn);
	  System.out.println(p1.name);
	  
	  //p1.nation = "usa";
	  //p1.ssn = "654321-7654321";
	  p1.name = "홍삼원";;
	  
	  System.out.println(p1.nation);
	  System.out.println(p1.ssn);
	  System.out.println(p1.name);
	 }
	
}


