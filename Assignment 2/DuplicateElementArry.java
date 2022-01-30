import java.util.Scanner;

public class DuplicateElementArry
{
	void duplicateElement(int arr[], int ArrySize)
	{
		System.out.print("Duplicate elements of Arry: ");for(int i=0;i<ArrySize;i++)
		{
			int testingElement=arr[i];
			for(int j=i+1;j<ArrySize;j++)
			{
				if(testingElement==arr[j])
				{
					System.out.print(testingElement+" ");
				}
			}
		}
	}
	public static void main(String[] args)
	{
		DuplicateElementArry dupli=new DuplicateElementArry();
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
		dupli.duplicateElement(arr, arr.length);
	}
}


