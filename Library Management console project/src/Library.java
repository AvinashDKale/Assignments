import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.sql.*;
public class Library
{
	Scanner sc =new Scanner(System.in);
	ArrayList<Book> bookCollection = new ArrayList<>();
	

	public void addBook()
	{
		try {
		Class.forName("com.mysql.jdbc.Driver");
	    java.sql.Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanegementsystem_db","root","root");
	
	    //Calendar calendar = Calendar.getInstance();
	     // java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
	      String query="INSERT INTO `librarymanegementsystem_db`.`lms_book_details`(`BOOK_CODE`,`BOOK_TITLE`,`CATEGORY`,`AUTHOR`,`PUBLICATION`,`PUBLISH_DATE`,`BOOK_EDITION`,`PRICE`,`RACK_NUM`,`DATE_ARRIVAL`,`SUPPLIER_ID`)VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	      PreparedStatement preparedStmt = conn.prepareStatement(query);
	      
	      System.out.println("\n\t\t\t\t\t\t BOOK_CODE:");
			String BOOK_CODE = sc.next();
			preparedStmt.setString (1, BOOK_CODE);
			System.out.println("\n\t\t\t\t\t\t BOOK_TITLE:");
			String BOOK_TITLE = sc.next();
			preparedStmt.setString (2, BOOK_TITLE);
			System.out.println("\n\t\t\t\t\t\t CATEGORY:");
			String CATEGORY = sc.next();
			preparedStmt.setString (3, CATEGORY);
			System.out.println("\n\t\t\t\t\t\t AUTHOR:");
			String AUTHOR = sc.next();
			preparedStmt.setString (4, AUTHOR);
			System.out.println("\n\t\t\t\t\t\t PUBLICATION:");
			String PUBLICATION = sc.next();
			preparedStmt.setString (5, PUBLICATION);
			System.out.println("\n\t\t\t\t\t\t PUBLISH_DATE:yyyy-mm-dd");
			String PUBLISH_DATE = sc.next();
			preparedStmt.setString (6, PUBLISH_DATE);
			System.out.println("\n\t\t\t\t\t\t RACK_NUM:");
			String RACK_NUM = sc.next();
			preparedStmt.setString (9, RACK_NUM);
			System.out.println("\n\t\t\t\t\t\t DATE_ARRIVAL:yyyy-mm-dd");
			String DATE_ARRIVAL = sc.next();
			preparedStmt.setString (10, DATE_ARRIVAL);
			System.out.println("\n\t\t\t\t\t\t SUPPLIER_ID:(S##)");
			String SUPPLIER_ID = sc.next();
			preparedStmt.setString (11, SUPPLIER_ID);
			System.out.println("\n\t\t\t\t\t\t PRICE:");
			double PRICE = sc.nextDouble();
			preparedStmt.setDouble (8, PRICE);
			System.out.print("\n\t\t\t\t\t\t BOOK_EDITION:");
			int BOOK_EDITION = sc.nextInt();
			preparedStmt.setInt (7, BOOK_EDITION);
			
			Book singleBook = new Book( BOOK_CODE,BOOK_TITLE,CATEGORY,PUBLICATION,AUTHOR,PUBLISH_DATE,RACK_NUM,  DATE_ARRIVAL, SUPPLIER_ID,PRICE,BOOK_EDITION);
			bookCollection.add(singleBook);
			preparedStmt.execute();
			conn.close();
	
}catch(Exception exc) {
	exc.printStackTrace();
}
		
	}
	public void removeBook()
	{System.out.print("\n\t\t\t\t\t\t Enter book BOOK_CODE:BL######");
	  String BOOK_CODE = sc.next();

		for (int i = 0; i < bookCollection.size(); i++)
		{
			Book tempBook = bookCollection.get(i);
			if(tempBook.getBOOK_CODE()==BOOK_CODE)
	            {
				try {
					  Class.forName("com.mysql.jdbc.Driver");
				      java.sql.Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanegementsystem_db","root","root");
				
				      //Calendar calendar = Calendar.getInstance();
				      //java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
				      String query="DELETE FROM `librarymanegementsystem_db`.`lms_book_details`WHERE BOOK_CODE=?";
				      PreparedStatement preparedStmt = conn.prepareStatement(query);
					  preparedStmt.setString (1, BOOK_CODE);
					  conn.close();
				
			}catch(Exception exc) {
				exc.printStackTrace();
			}
	            	bookCollection.remove(i);
	            	System.out.println("\n\t\t\t\t\t\t Removed Successfully !!!");
	            }
	            else
	            	System.out.println("\n\t\t\t\t\t\tInvalid  BOOK_CODE !!!");
		 }
	}
	public void showLibrary()
	{
		
		try {Class.forName("com.mysql.jdbc.Driver");
		java.sql.Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanegementsystem_db","root","root");
		
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM librarymanegementsystem_db.lms_book_details;");
	
	    rs.next();	
		while(rs.next()) {
			int bookedition=rs.getInt("BOOK_EDITION");
			String Bookname = rs.getString("BOOK_TITLE");
			System.out.println(Bookname+""+bookedition);
		}
		st.close();
		conn.close();
		
	}catch(Exception exc) {
		exc.printStackTrace();
	}
        System.out.println("\n\t\t\t---------------------------------------------------------");
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
		System.out.print("\n\t\t\t\t\t\t Enter book BOOK_CODE:BL######");
		String BOOK_CODE = sc.next();
		
		System.out.print("\n\t\t\t\t\t\t Enter your Name -  ");
		String name = sc.nextLine();
		for (int i = 0; i < bookCollection.size(); i++) 
		 {
			Book tempBook = bookCollection.get(i);
			
	            if(tempBook.getBOOK_CODE()==BOOK_CODE)
	            {
	            	
	           	String BOOK_TITLE = tempBook.getBOOK_CODE();
	            	System.out.println("\n\t\t\t\t\t\t Book ["+BOOK_TITLE+"] issued to [" +name+ "] successfully !!");
	            }
	            else
	            	{System.out.println("\n\t\t\t\t\t\t Invalid  BOOK_CODE !!!");}
		 }
		
	}
	public void returnBook()
	{
		System.out.print("\n\t\t\t\t\t\t Enter book BOOK_CODE:");
		String BOOK_CODE = sc.next();
		sc.nextLine();
		System.out.print("\n\t\t\t\t\t\tEnter your Name -  ");
		String name = sc.nextLine();
		for (int i = 0; i < bookCollection.size(); i++) 
		 {
			Book tempBook = bookCollection.get(i);
			
/*	            if(tempBook.getId()==BOOK_CODE)
	            {
	            	int tempQuant = tempBook.getQuantity();
	            	tempQuant++;
	            	tempBook.setQuantity(tempQuant);
	            	String BOOK_TITLE = tempBook.getTitle();
	            	System.out.println("\n\t\t\t\t\t\tBook ["+BOOK_TITLE+"] returned from [" +name+ "] successfully !!");
	            }
	            else
	            	{System.out.println("\n\t\t\t\t\t Invalid  BOOK_CODE !!!");}
*/		 }
	}
}