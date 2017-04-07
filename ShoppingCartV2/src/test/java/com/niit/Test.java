package com.niit;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[]= {10, 20, 30};
		int B[];
		//B= A;//Shallow copy
		B= A.clone();//Deep copy
		B[1]= 200;
		for(int i=0; i<3; i++)
		{
			System.out.println(A[i]);
		}

	}

}
