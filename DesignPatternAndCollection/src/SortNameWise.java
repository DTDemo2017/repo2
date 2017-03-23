import java.util.*;
public class SortNameWise implements Comparator<Product> {
	@Override
	public int compare(Product arg0, Product arg1) 
	{
		return arg0.prodname.compareTo(arg1.prodname);

    }
}
