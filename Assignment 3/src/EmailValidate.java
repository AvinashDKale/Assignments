import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.*;
class EmailValidate
{
	public static boolean isValid(String email)
	{
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@" +"(?:[a-zA-Z0-9-]+\\.)+[a-z" +"A-Z]{2,7}$";
		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}

	public static void main(String[] args)
	{
		String str;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a Email:");
		str = sc.nextLine();
		sc.close();
		ArrayList<String> address = new ArrayList<>();
		address.add(str);
		for(String i : address)
		{
			if (isValid(i))
				System.out.println(i + " - This is  valid email");
			else
				System.out.println(i + " - This is not valid email ");
		}
	}
}
