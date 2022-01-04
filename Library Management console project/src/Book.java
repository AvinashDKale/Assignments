public class Book 
{
	private String BOOK_CODE;
	private String BOOK_TITLE;
	private String CATEGORY;
	private String PUBLICATION;
	private String AUTHOR;
	private String PUBLISH_DATE;
	private String RACK_NUM;
	private String DATE_ARRIVAL;
	private String SUPPLIER_ID;
	private double PRICE;
	private int BOOK_EDITION;
	
	public Book()
	{
		BOOK_CODE=null;
		BOOK_TITLE=null;
		AUTHOR=null;
		CATEGORY=null;
		PUBLICATION=null;
		PUBLISH_DATE=null;
		BOOK_EDITION=0;
		PRICE=0;
		RACK_NUM=null;
		DATE_ARRIVAL=null;
		SUPPLIER_ID=null;
	
	}
	
	public Book(String BOOK_CODE,String BOOK_TITLE,String CATEGORY,String PUBLICATION,String AUTHOR,String PUBLISH_DATE,String RACK_NUM, String DATE_ARRIVAL,String SUPPLIER_ID,double PRICE,int BOOK_EDITION)
	{
		this.BOOK_CODE= BOOK_CODE;
		this.BOOK_TITLE= BOOK_TITLE;
		this.AUTHOR= AUTHOR;
		this.CATEGORY= CATEGORY;
		this.PUBLICATION= PUBLICATION;
		this.PUBLISH_DATE= PUBLISH_DATE;
		this.BOOK_EDITION= BOOK_EDITION;
		this.PRICE= PRICE;
		this.RACK_NUM= RACK_NUM;
		this.DATE_ARRIVAL= DATE_ARRIVAL;
		this.SUPPLIER_ID= SUPPLIER_ID;
	
	}

	public String getBOOK_CODE() {
		return BOOK_CODE;
	}
	public String getBOOK_TITLE()
	{
		return BOOK_TITLE;
	}
	
	public String getAUTHOR() {
		return AUTHOR;
	}
	public String getCATEGORY() {
		return CATEGORY;
	}
	public String getPUBLICATION() {
		return PUBLICATION;
	}
	public String getPUBLISH_DATE() {
		return PUBLISH_DATE;
	}
	public String getRACK_NUM() {
		return RACK_NUM;
	}
	public String getDATE_ARRIVAL() {
		return DATE_ARRIVAL;
	}
	public String getSUPPLIER_ID() {
		return SUPPLIER_ID;
	}
	public int getBOOK_EDITION() {
		return BOOK_EDITION;
	}
	public double getPRICE()
	{
		return PRICE;
	}
	public String toString(){
		return "\n\t\t\t\t\t\t\n\t\t\t\t\t\t BOOK_CODE: "+BOOK_CODE+"\n\t\t\t\t\t\t BOOK_TITLE: "+BOOK_TITLE+"\n\t\t\t\t\t\t CATEGORY: "+CATEGORY+"\n\t\t\t\t\t\t AUTHOR: "+AUTHOR+"\n\t\t\t\t\t\t PUBLICATION: "+PUBLICATION+"\n\t\t\t\t\t\t PUBLISH_DATE: "+PUBLISH_DATE+"\n\t\t\t\t\t\t BOOK_EDITION: "+BOOK_EDITION+"\n\t\t\t\t\t\t PRICE: "+PRICE+"\n\t\t\t\t\t\t RACK_NUM: "+RACK_NUM+"\n\t\t\t\t\t\t DATE_ARRIVAL: "+DATE_ARRIVAL+"\n\t\t\t\t\t\t SUPPLIER_ID:"+SUPPLIER_ID+"\n\t\t\t\t\t\t";
	}
	
}