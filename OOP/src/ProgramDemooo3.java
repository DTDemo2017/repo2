import P1.*;
public class ProgramDemooo3 {
	ProgramDemo1 obj= new ProgramDemo1();
	
	public ProgramDemooo3()
	{
		//x=10;//Private member can't be accessed.
		//y=20;//As it is package scope (ProgramDemo1 obj in class ProgramDemooo3)we can't access.
		//obj.z=30;//As it is not inheriting the class.
		obj.v1=40;
	}


}
