import java.util.Scanner;

public class Ascending {
	void ascending(int arr[],int ArraySize)
	{
		int temp = 0;
		System.out.println("Elements of original array: ");
		for (int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}

		for (int i = 0; i < arr.length; i++)
		{
			for (int j = i+1; j < arr.length; j++)
			{
				if(arr[i] > arr[j])
				{
					temp = arr[i];
                    arr[i] = arr[j];    
                    arr[j] = temp;    
                }     
			}
		}
		System.out.println();
	}

	void printArray(int arr[], int ArrySize)
	{
		System.out.print( " Acending order of Array:");
		for (int i = 0; i < ArrySize; i++)
			System.out.print(arr[i] + " ");
		System.out.print( " dcending order of Array:");
		for (int j = ArrySize-1; j>=0  ; j--)
			System.out.print(arr[j] + " ");
	}

	public static void main(String[] args)
	{
		Ascending asc=new Ascending();
		int ArrySize;
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the size of Array: ");
		ArrySize=sc.nextInt();
		int[] arr = new int[ArrySize];
		System.out.println("Enter the elements of the array: ");
		for(int i=0; i<ArrySize; i++)
		{
			arr[i]=sc.nextInt();
		}
		sc.close();
		asc.ascending(arr, ArrySize);
		asc.printArray(arr, ArrySize);
	}
}
