import java.util.Scanner;
public class RotationArray {
		

	
		void leftRotate(int arr[], int delimeter, int ArrySize)
		{
			
			int temporary[] = new int[delimeter];

			
			for (int i = 0; i < delimeter; i++)
				temporary[i] = arr[i];

		
			for (int i = delimeter; i < ArrySize; i++) {
				arr[i - delimeter] = arr[i];
			}

		
			for (int i = 0; i < delimeter; i++) {
				arr[i + ArrySize - delimeter] = temporary[i];
			}
		}

		
		void printArray(int arr[], int ArrySize)
		{   
			
			for (int i = 0; i < ArrySize; i++)
				System.out.print(arr[i] + " ");
		}

		
		public static void main(String[] args)
		{
			
			RotationArray rotate = new RotationArray();

		
			
			
			
			int ArrySize,delimeter;  
			Scanner sc=new Scanner(System.in);  
			System.out.print("Enter the size of Array: ");  
			 
			ArrySize=sc.nextInt();  
			
			int[] arr = new int[ArrySize];  
			System.out.println("Enter the elements of the array: ");  
			for(int i=0; i<ArrySize; i++)  
			{  
			   
			arr[i]=sc.nextInt();  
			}  
			
			Scanner sc2=new Scanner(System.in);  
			System.out.print("Enter the delimeter for left rotation of Array: ");  
			 
			delimeter=sc2.nextInt();  
			
			
			
			rotate.leftRotate(arr, delimeter, arr.length);
			System.out.println("Left rotation of Array by "+delimeter+" is:\n");
			rotate.printArray(arr, arr.length);
			sc.close();
			sc2.close();
		}
	

	
	
	
	
}
