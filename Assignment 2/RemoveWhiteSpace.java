import java.util.Scanner;
public class RemoveWhiteSpace
{
	public static void main(String[] args)
	{
		String string;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string:");
		string = sc.nextLine();
		string = string.replaceAll("\\s+", "");
		System.out.println("String after removing all the white spaces : " + string);
		sc.close();
	}
}
