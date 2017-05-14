package com.niit.shoppingcartbackend.dao;

import java.util.List;

import com.niit.shoppingcartbackend.domain.Mycart;
import com.niit.shoppingcartbackend.domain.User;

public interface MycartDAO {
	//1)create/register -save
		public boolean save(Mycart mycart);
		
		//2)update the mycart details -update
		public boolean update(Mycart mycart);
		
		//3)validate the credentials -validate
		public boolean validate(String mycartid, String userid);
		
		//4)get all mycart-list
		public List<Mycart> list();
		
		//5)get user details based on MycartID
		public Mycart get(String mycartid);

		//6)
		public List<Mycart> list(String userID);

		//7)
		public double getTotalAmount(String userID);

}
