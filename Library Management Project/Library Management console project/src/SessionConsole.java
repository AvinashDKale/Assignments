import java.util.Scanner;

public class SessionConsole
{
	static Library library = new Library();
	SessionConsole ses =new SessionConsole();
	static Scanner sc =new Scanner(System.in);

	public static void admin()
	{
		int choice;
		do
		{
			System.out.println("\n\t\t\t---------------------------------------------------------");
			System.out.println("\n\t\t\t--------------------------Admin--------------------------");
			System.out.println("\n\t\t\t---------------------------------------------------------");
			System.out.print("\n\t\t\t\t 1.press 1 to show the Book list");
			System.out.print("\n\t\t\t\t 2.press 2 to add Book");
			System.out.print("\n\t\t\t\t 3.press 3 to remove Book");
			System.out.print("\n\t\t\t\t 4.press 4 to issue a Book");
			System.out.print("\n\t\t\t\t 5.press 5 to return Book");
			System.out.print("\n\t\t\t\t 6.press 6 to EXIT");
			System.out.print("\n\t\t\t\t Enter your choice : ");
			choice = sc.nextInt();
			System.out.println("\n\t\t\t---------------------------------------------------------");
			switch(choice)
			{
				case 1:
					library.showLibrary();
					break;
                case 2:
					library.addBook();
					break;
				case 3: library.removeBook();
					break;
				case 4: library.issueBook();
					break;
				case 5:library.returnBook();
					break;
				case 6:System.exit(1); System.out.println("\n\t\t\t------------------------thank you------------------------");
					break;
				default : System.out.println("\n\t\t\t\t\t\t Invalid Choice !!");
					break;
					}
		} while(true);
	}

	public static void student()
	{
		int choice;
		do
		{
			System.out.println("\n\t\t\t---------------------------------------------------------");
	    	System.out.println("\n\t\t\t-------------------------student-------------------------");
		    System.out.println("\n\t\t\t---------------------------------------------------------");
			System.out.print("\n\t\t\t\t 1.press 1 to show the Book list");
			System.out.print("\n\t\t\t\t 2.press 2 to issue a Book");
			System.out.print("\n\t\t\t\t 3.press 3 to return Book");
			System.out.print("\n\t\t\t\t 4.press 4 to EXIT");
			System.out.print("\n\t\t\t\t Enter your choice : ");
			choice = sc.nextInt();
			System.out.println("\n\t\t\t---------------------------------------------------------");

			switch(choice)
			{
				case 1:
					admin();
					break;

				case 2:
					student();
					break;
				case 3:
					library.returnBook();
					break;
				case 4:
					System.exit(1);System.out.println("\n\t\t\t------------------------thank you------------------------");
				    break;
				default :
					System.out.println("\n\t\t\t\t\t\t Invalid Choice !!");
					break;
			}
		}
		while(true);
	}

	public static void main(String args[])
	{
		int choice;
		do
		{
			System.out.print("\n\t\t\t\t Welcome to Library \n");
			System.out.print("\n\t\t\t\t 1.press 1 for Admin");
			System.out.print("\n\t\t\t\t 2.press 2 for Student");
			System.out.print("\n\t\t\t\t 3.press 3 to Exit");
			System.out.print("\n\t\t\t\t\t\t Enter your choice : ");
			choice = sc.nextInt();
			System.out.println("\n\t\t\t---------------------------------------------------------");
			switch(choice)
			{
				case 1:
					admin();break;
				case 2:
					student();break;
				case 3:
					System.exit(1);System.out.println("\n\t\t\t---------------------------------------------------------");
					break;
				default :
					System.out.println("\n\t\t\t\t\t\t Invalid Choice !!");
					break;
			}
		}
		while(choice!=0);
	}
}
