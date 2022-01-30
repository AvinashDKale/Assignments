import java.util.Scanner;
public class PascalTriangle
{
	public  int factorial(int i)
	{
		if (i == 0)
			return 1;
		return i * factorial(i - 1);
	}

	public  void printPasaclTriangle(int n)
	{
		int i,j;
		PascalTriangle g=new PascalTriangle();
		for (i = 0; i <= n; i++)
		{
			for (j = 0; j <= n - i; j++)
			{
				// for left spacing
				System.out.print(" ");
			}
			for (j = 0; j <= i; j++)
			{
				// nCr formula
				System.out.print(" "+g.factorial(i)/(g.factorial(i - j)*g.factorial(j)));
			}
			// for newline
			System.out.println();
		}
	}

	public static void main(String args[])
	{
		int rows;
		System.out.println(" Enter the  number of rows of pascal triangle: ");
		Scanner sc = new Scanner(System.in);
		rows=sc.nextInt();
		PascalTriangle triangle=new PascalTriangle();
		triangle.printPasaclTriangle(rows);
		sc.close();
	}
}
