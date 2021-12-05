import java.util.Scanner;

public class LeapYear {
	static boolean isLeap(int year)
	{
		
		return (((year % 4 == 0) &&
				(year % 100 != 0)) ||
				(year % 400 == 0));
	}
public static void main(String args[]) {
	int inputYear;
	System.out.println(" Enter the year: ");
		Scanner sc = new Scanner(System.in);
		inputYear=sc.nextInt();
		if(isLeap(inputYear)) {
			System.out.println(inputYear+" :is leap year ");
		}
		else {
			System.out.println(inputYear+" :is not leap year ");
		}
		sc.close();
}
}
