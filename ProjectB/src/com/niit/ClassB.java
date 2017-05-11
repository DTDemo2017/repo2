package com.niit;

public class ClassB {
	
	public void methodB()
	{
		System.out.println("This is from methodB of ClassB of ProjectB.");
		ClassA a= new ClassA();
		a.methodA();
	}

	public static void main(String[] args) {
		ClassB b= new ClassB();
		b.methodB();

	}

}
