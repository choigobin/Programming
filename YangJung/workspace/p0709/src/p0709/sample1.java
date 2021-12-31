package p0709;

public class sample1 {

	public static void main(String[] args) {
		int num1;
		int num2;
		int result;//int num1,num2,result;
		num1=100;
		num2=200;
		result=num1+num2;
		System.out.print("Hello World!!\n");
		System.out.println(num1+"+"+num2+"="+result);
		System.out.printf("%d+%d=%d\n",num1,num2,result);
		result=num1-num2;
		System.out.printf("%d-%d=%d\n",num1,num2,result);
		result=num1*num2;
		System.out.printf("%d*%d=%d\n",num1,num2,result);
		num1=200;num2=100;
		result=num1/num2;
		System.out.printf("%d/%d=%d\n",num1,num2,result);
		num1=205;num2=100;result=num1%num2;
		System.out.printf("%d%%%d=%d\n",num1,num2,result);
float f1,f2,fresult;
f1=205.5f;f2=100.0f;
		char c;
		System.out.println("=== 실수형 게산기 ===");
		fresult=f1+f2;
		System.out.printf("%.2f+%.2f=%.2f\n", f1,f2,fresult);
		fresult=f1-f2;
		System.out.printf("%.2f-%.2f=%.2f\n", f1,f2,fresult);
		fresult=f1*f2;
		System.out.printf("%.2f*%.2f=%.2f\n", f1,f2,fresult);
		fresult=f1/f2;
		System.out.printf("%.2f/%.2f=%.2f\n", f1,f2,fresult);
String str;
		str="Hello World";
		System.out.printf("%s\n", str);
		c='c';
		System.out.printf("%c\n", c);
	
	}

}
