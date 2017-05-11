interface Addition
{
	int add(int v1,int v2);
}

interface Multiplication 
{
	int mul(int v1, int v2);
}


public interface Calculator extends Addition, Multiplication 
{
     void show();
}
