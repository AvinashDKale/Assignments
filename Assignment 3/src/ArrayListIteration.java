import java.util.*;


class ArrayListIteration {

	
	public static void main(String[] args)
	{
		// Creating and initializing the ArrayList
		// Declaring object of integer type
		List<String> fruits = Arrays.asList("Apple","Mango","chikku","Grapes","Guava","Orange","Papaya");

		System.out.println("Using for loop:\n"); 
		// Iterating using for loop
		for (int i = 0; i < fruits.size(); i++)
		
			// Printing and display the elements in ArrayList
			System.out.print(fruits.get(i) + " ");	
		
		int val=0;
		System.out.println("\nUsing While loop:\n"); 
        while (fruits.size() > val) {
        	 
            // Printing the element which holds above
            // condition true
            System.out.println(fruits.get(val));
 
            // Step 3: Terminating condition by incrementing
            // our counter in each iteration
            val++ ;
        }
        

		System.out.println("\nUsing advaced for loop:\n"); 

        
        for (String i : fruits)
        	 
            // Printing the elements of ArrayList
            System.out.print(i + " ");
	}
	
}

