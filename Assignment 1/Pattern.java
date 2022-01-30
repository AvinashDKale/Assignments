import java.util.Scanner;

public class Pattern {
	public static void main(String args[])
	{
		String str;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string:");
		str = sc.nextLine();
		int length = str.length();
        // char[] ch=str.toCharArray();
		for ( int i = 0; i <length; i++ )
			System.out.println("\t\t"+str.substring(0, i+1));
    sc.close();
	}
}
