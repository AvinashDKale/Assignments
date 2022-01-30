import java.util.Scanner;

class TowerofHonai 
{ 
	static void towerOfHanoi(int n, char fromRod, char toRod, char aux_rod)
	{
		if (n == 1)
		{
			System.out.println("Move disk 1 from rod "+ fromRod+" to rod "+toRod);
			return;
		}
		towerOfHanoi(n - 1, fromRod, aux_rod, toRod);
		System.out.println("Move disk "+ n + " from rod " + fromRod +" to rod " + toRod );
		towerOfHanoi(n - 1, aux_rod, toRod, fromRod);
	}
	public static void main(String args[])
	{
		int inputNumber;
		System.out.println(" Enter the number of disks: ");
		Scanner sc = new Scanner(System.in);
		inputNumber=sc.nextInt();
		// Number of disks
	    towerOfHanoi(inputNumber, 'A', 'C', 'B'); // A, B and C are names of rods
		sc.close();
	}
}