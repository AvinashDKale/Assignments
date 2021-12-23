public class Book 
{
	private int id;
	private String title;
	private String author;
	private double price;
	private int quantity;
	
	public Book()
	{
		id=0;
		title=null;
		author=null;
		price=0;
		quantity = 0;
	}
	
	public Book(int id,String title, String author,double price,int quantity)
	{
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}
	public String getTitle()
	{
		return title;
	}
	public int getQuantity()
	{
		return quantity;
	}
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	public String toString(){
		return"\n\t\t\t\t\t\t Book{"+"\n\t\t\t\t\t\t Id: "+id+"\n\t\t\t\t\t\t Title: "+title+"\n\t\t\t\t\t\t Author: "+author+"\n\t\t\t\t\t\t Price: "+price+"\n\t\t\t\t\t\t Quantity: "+quantity+"}";
	}
	
}