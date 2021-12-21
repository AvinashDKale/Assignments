import java.util.Scanner;
import java.util.ArrayList;



	public class SessionConsole
	{
		 static Library lib = new Library();
		 static Scanner sc =new Scanner(System.in);	

		public static void main(String args[])
		{
			int choice;
			do{
				System.out.print("\t\tSession ongoing...\n");
				System.out.print("\t\t\n1.Show the Book list");
				System.out.print("\t\t\n2.Add Book");
				System.out.print("\t\t\n3.Remove Book");
				System.out.print("\t\t\n4.Issue a Book");
				System.out.print("\t\t\\n5.Return Book");
				System.out.print("\t\t\n0.EXIT");
				System.out.print("\t\t\\nEnter your choice : ");
				choice = sc.nextInt();
				System.out.println("------------------------------------");
				
				switch(choice)
				{
					case 1:lib.showLibrary();
					break;
					case 2: lib.addBook();
					break;
					case 3: lib.removeBook();
					break;
					case 4: lib.issueBook();
					break;
					case 5:lib.returnBook();
					break;
					case 0: System.out.println("----------Thank you----------");
					break;	
					default : System.out.println("Invalid Choice !!");
					break;
				}
			} while(choice!=0);

		}
	}
