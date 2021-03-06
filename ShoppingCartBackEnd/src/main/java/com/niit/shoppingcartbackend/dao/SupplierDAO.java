package com.niit.shoppingcartbackend.dao;

import java.util.List;

import com.niit.shoppingcartbackend.domain.Supplier;


public interface SupplierDAO {
	//1)create/register -save
		public boolean save(Supplier supplier);
		
		//2)update the supplier details -update
		public boolean update(Supplier supplier);
		
		//3)validate the credentials -validate
		public boolean validate(String supplierid, String suppliername);
		
		//4)get all supplier-list
		public List<Supplier> list();
		
		//5)get supplier details based on userID
		public Supplier get(String supplierid);

		//6)
		public Supplier getSupplierBySupplierName(String suppliername);
		
		//7)
		public Supplier getSupplierBySupplierID(String supplierid);

		//8)
		public boolean delete(String supplierid);


}
