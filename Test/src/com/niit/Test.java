package com.niit;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee emp1= new Employee();
		emp1.setId(101);
		emp1.setName("Rakesh");
		emp1.setSal(11_000);
		emp1.setGender('M');
		
		System.out.println(emp1.getId());
		System.out.println(emp1.getName());
		System.out.println(emp1.getSal());
		System.out.println(emp1.getGender());

	}

}
