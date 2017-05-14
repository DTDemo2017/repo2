package com.niit.shoppingcartfrontend.util;

public class Util {
	public static String removeComman(String field)
	{
		return field.replace(",", "");
	}
	
	
	public static void main(String[] args) {
		
		String categoryid = ",mobile_category";
		
		System.out.println("categoryid before remove commaa" +categoryid);
	
	System.out.println("categoryid after remove commaa" +removeComman(categoryid));
	
	
	}

}
