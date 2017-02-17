package com.myjava.string;

public class MyStringConcat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String b = "jump ";
        String c = "No jump";
        /**
           We can do string concatenation by two ways.
           One is by using '+' operator, shown below.
         **/
        String d = b+c;
        System.out.println(d);
        
        d = b.concat(c);
        System.out.println(d);
	}

}
