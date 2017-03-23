
public class StringDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String str="Hello";
		
		System.out.println("Length of the String:"+str.length());
		
		System.out.println("CloudCampus".length());
		
		System.out.println("Upper Case of String:"+str.toUpperCase());
		
		String substring=str.substring(0, 3);
		
		System.out.println(substring);
		
		String record="E1001,Gagan,Programmer,9888117771";
		
		String empdet[]=record.split(",");
		
		System.out.println("Employee ID:"+empdet[0]);
		System.out.println("Employee Name:"+empdet[1]);
		System.out.println("Employee Designation:"+empdet[2]);
		System.out.println("Employee Mobile:"+empdet[3]);
		
		char arr[]={'K','I','R','A','N'};
		String str1=new String(arr);
		System.out.println("String Object:"+str1);
		
		byte arr2[]={65,66,67,68,69};
		String str2=new String(arr2);
		System.out.println("String object using Byte Array:"+str2);
		
		//========================================
		
		String s1="Hello";
		s1.concat(" Avinash");
		System.out.println(s1);
		
		s1=s1.concat(" Avinash");
		System.out.println(s1);
		

	}

}
