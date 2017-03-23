
public class Product implements Comparable<Product>
{
	int prodid,price;
	String prodname,category;
	

public Product(int pid,int price,String pname,String cat)
{
	prodid=pid;
	this.price=price;
	prodname=pname;
	category=cat;
}

public String toString()
{
	return "Product ID:"+prodid+" Product Name:"+prodname+" Price:"+price+" Category:"+category;
}

//Logic written in this overridden method.

@Override
public int compareTo(Product nextobj) 
{
	if(this.prodid==nextobj.prodid)
	{
		return 0;
	}
	else if(this.prodid>nextobj.prodid)
	{
		return 1;
	}
	else
	{
		return -1;
	}
}
}
