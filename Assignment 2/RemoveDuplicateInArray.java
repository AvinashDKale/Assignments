import java.util.Scanner;
public class RemoveDuplicateInArray
{
	public static int removeDuplicateElements(int arr[], int n)
	{
		if (n==0 || n==1)
		{
			return n;
		}
		int[] temp = new int[n];
		int j = 0;
		for (int i=0; i<n-1; i++)
		{
			if (arr[i] != arr[i+1])
			{
				temp[j++] = arr[i];
			}
		}
		temp[j++] = arr[n-1];
		for (int i=0; i<j; i++)
		{
			arr[i] = temp[i];
		}
		return j;
	}
	
	public static void main (String[] args)
	{
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
		ArrySize = removeDuplicateElements(arr, ArrySize);
		for (int i=0; i<ArrySize; i++)
			System.out.print(arr[i]+" ");
	}
}