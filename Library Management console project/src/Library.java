import java.util.ArrayList;
import java.util.Scanner;

public class Library
{
	Scanner sc =new Scanner(System.in);
	ArrayList<Book> bookCollection = new ArrayList<>();
	
	public void addBook()
	{
		System.out.println("\n\t\t\t\t\t\t Id:");
		int id = sc.nextInt();
		
		System.out.println("\n\t\t\t\t\t\t Title:");
		String title = sc.next();
		System.out.println("\n\t\t\t\t\t\t Author:");
		String author = sc.next();
		System.out.println("\n\t\t\t\t\t\t Price:");
		double price = sc.nextDouble();
		System.out.print("\n\t\t\t\t\t\t Quantity:");
		int quantity = sc.nextInt();
		
		Book singleBook = new Book(id,title,author,price,quantity);
		bookCollection.add(singleBook);
	}
	public void removeBook()
	{
		System.out.print("\n\t\t\t\t\t\t Enter book id:");
		int id = sc.nextInt();
		for (int i = 0; i < bookCollection.size(); i++) 
		 {
			Book tempBook = bookCollection.get(i);
			
			
	            if(tempBook.getId()==id)
	            {
	            	
	            	bookCollection.remove(i);
	            	System.out.println("\n\t\t\t\t\t\t Removed Successfully !!!");
	            }
	            else
	            	System.out.println("\n\t\t\t\t\t\tInvalid  ID !!!");
		 }
	}
	public void showLibrary()
	{System.out.println("\n\t\t\t---------------------------------------------------------");
		System.out.println("\n\t\t\t-------------------------Library-------------------------");
		System.out.println("\n\t\t\t---------------------------------------------------------");
		 for (int i = 0; i < bookCollection.size(); i++) 
		 {
			 Book tempBook = bookCollection.get(i);
				System.out.println(tempBook.toString());
		 }

	}
	public void issueBook()
	{
		System.out.print("\n\t\t\t\t\t\t Enter book id:");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.print("\n\t\t\t\t\t\t Enter your Name -  ");
		String name = sc.nextLine();
		for (int i = 0; i < bookCollection.size(); i++) 
		 {
			Book tempBook = bookCollection.get(i);
			
	            if(tempBook.getId()==id)
	            {
	            	int tempQuant = tempBook.getQuantity();
	            	tempQuant--;
	            	tempBook.setQuantity(tempQuant);
	            	String title = tempBook.getTitle();
	            	System.out.println("\n\t\t\t\t\t\t Book ["+title+"] issued to [" +name+ "] successfully !!");
	            }
	            else
	            	{System.out.println("\n\t\t\t\t\t\t Invalid  ID !!!");}
		 }
		
	}
	public void returnBook()
	{
		System.out.print("\n\t\t\t\t\t\t Enter book id:");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.print("\n\t\t\t\t\t\tEnter your Name -  ");
		String name = sc.nextLine();
		for (int i = 0; i < bookCollection.size(); i++) 
		 {
			Book tempBook = bookCollection.get(i);
			
	            if(tempBook.getId()==id)
	            {
	            	int tempQuant = tempBook.getQuantity();
	            	tempQuant++;
	            	tempBook.setQuantity(tempQuant);
	            	String title = tempBook.getTitle();
	            	System.out.println("\n\t\t\t\t\t\tBook ["+title+"] returned from [" +name+ "] successfully !!");
	            }
	            else
	            	{System.out.println("\n\t\t\t\t\t Invalid  ID !!!");}
		 }
	}
}