public class JavaProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ch;
        int i;
        for(i=1; i<=255; i++)
        {
            ch = new Character((char)i).toString();
            System.out.print(i+ " -> " + ch + "\t");
        }

	}

}
