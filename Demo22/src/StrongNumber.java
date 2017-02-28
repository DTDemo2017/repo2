import java.util.Scanner; 
public class StrongNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StrongNumber ss=new StrongNumber(); 
        int a,b,r,s=0; 
        Scanner sl=new Scanner(System.in); 
        System.out.println("Enter A Number"); 
        b=sl. nextInt() ; 
        a=b; 
        while(b>0) 
        { 
            r=b%10; 
            s=s+ss.fact(r); 
            b=b/10; 
        } 
        if(a==s) 
            System.out.println(a+" is a strong number"); 
         else 
            System.out.println(a+" is not a strong number"); 
       } 
              int fact(int i) 
                    { 
                        int f,j; 
                        f=1; 
                       for(j=i ;j>0;j--) 
                            f=f*j; 
                            return f; 

	}

}
