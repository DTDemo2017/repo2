
public class ProgramDemoo3 {
	P1.ProgramDemo1 obj= new P1.ProgramDemo1();
	
	public ProgramDemoo3()
	{
		//x=10;//Private variable can't be accessed.
		//y=20;//As package scope(P1.ProgramDemo1 obj in class ProgramDemo3) we can't access
		//obj.z=30;//Only if we inherit the class protected member can be used outside package.
		obj.v1=40;
	}

}
