package controllers;

import java.util.Set;


import models.Book;
import play.mvc.*;
import views.html.books.*;

public class BooksController  extends Controller{
    public Result index(){
        Set<Book>books=Book.allBooks();

        return ok(index.render(books));
        }
        public Result create(){
        return null;
        }
        public Result save(){
        return null;
        }
        public Result edit(Integer id){
        return null;
        }
        public Result update(){
        return null;
        }
        public Result destroy(Integer id){
        return null;
        }
        public Result show(Integer id){
        return null;
        }
    
}
