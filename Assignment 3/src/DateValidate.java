import java.util.Scanner;

class DateValidate
{
	static int MaxValidYr = 9999;
	static int MinValideYr = 1800;

	static boolean isLeap(int year)
	{
		return (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0));
	}

	static boolean isValidDate(int d,int m,int y)
	{
		if (y > MaxValidYr || y < MinValideYr)
			return false;
		if (m < 1 || m > 12)
			return false;
		if (d < 1 || d > 31)
			return false;
		if (m == 2)
		{
			if (isLeap(y))
				return (d <= 29);
			else
				return (d <= 28);
		}
		if (m == 4 || m == 6 || m == 9 || m == 11)
			return (d <= 30);
		return true;
	}

	public static void main(String args[])
	{
		int day,month,year;
		System.out.println(" Enter the date between year 1800 to 9999 ");
		Scanner sc = new Scanner(System.in);
		System.out.println(" Enter the day: ");
		day=sc.nextInt();
		System.out.println(" Enter the month: ");
		month=sc.nextInt();
		System.out.println(" Enter the year: ");
		year=sc.nextInt();
		if (isValidDate(day,month, year))
			System.out.println(day+"/"+month+"/"+year+"      is valid date");
		else
			System.out.println(day+"/"+month+"/"+year+"      is not valid date");
		sc.close();
	}
}