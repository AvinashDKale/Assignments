import java.util.Scanner;

public class PrimNumber
{
	// A school method based JAVA program
	// to check if a number is prime
	static boolean isPrime(int n)
	{
		// Corner case
		if (n <= 1)
			return false;

		// Check from 2 to n-1
		for (int i = 2; i < n; i++)
			if (n % i == 0)
				return false;
		return true;
	}
	// Driver Program
	public static void main(String args[])
	{
		int inputNumber;
		System.out.println(" Enter the number: ");
		Scanner sc = new Scanner(System.in);
		inputNumber=sc.nextInt();
		if(isPrime(inputNumber))
		{
			System.out.println(inputNumber+" is prime number");
		}
		else
		{
			System.out.println(inputNumber+" is not prime number");
		}
		sc.close();
	}
}
