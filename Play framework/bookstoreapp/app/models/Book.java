package models;

import java.util.Set;

public class Book {
    
    public Integer id;
    public String title;
    public Integer price;
    public String author;
    
//    public Book() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//    
    public Book(Integer id, String title, Integer price, String author) {
//        super();
        this.id = id;
        this.title = title;
        this.price = price;
        this.author = author;
    }
    
    private static Set<Book> books;
    static {
        books.add(new Book(1, "C++", 20, "ABC"));
        books.add(new Book(2, "C", 100, "ABCD"));
    }
    
    public static Set<Book> allBooks() {
        return books;
    }
    
    public static Book findById(Integer id){
    for(Book book : books)
    {
    
        if(id.equals(book.id))
                {
    
            return book;
            }
   
        return null;
    }
    return null;
    }
    
    public static void add(Book book) {
        books.add(book);
    }
    
    public static boolean remove(Book book) {
        return books.remove(book);
    }
    
//    public Integer getId() {
//        return id;
//    }
//    
//    public String getTitle() {
//        return title;
//    }
//    
//    public Integer getPrice() {
//        return price;
//    }
//    
//    public String getAuthor() {
//        return author;
//    }
//    
//    public void setId(Integer id) {
//        this.id = id;
//    }
//    
//    public void setTitle(String title) {
//        this.title = title;
//    }
//    
//    public void setPrice(Integer price) {
//        this.price = price;
//    }
//    
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//    
//    @Override
//    public String toString() {
//        return "Book [id=" + id + ", title=" + title + ", price=" + price + ", author=" + author + "]";
//    }
    
}
