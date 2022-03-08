package controllers;

import play.mvc.Controller;
import javax.inject.Inject;
import play.mvc.*;
import play.data.DynamicForm;
import play.data.FormFactory;
public class Application extends Controller{
/**
* Process the home page
* @return
*/
public Result index() {
 return ok(views.html.bookshop.render());
}
/**
* Get the details of a book by id
* @param id
* @return
*/
public Result getBook(String id) {
 return ok(views.html.bookshop.render());
}
@Inject
FormFactory formFactory;


public Result saveComment(Http.Request request) {
 DynamicForm requestData = formFactory.form().
bindFromRequest(request);
 String comment = requestData.get("comment");
 return ok(views.html.savecomment.render());
}
public Result searchByTitle(String title) {
 //Query db and get the book details or get from cache
 return ok(views.html.searchresults.render());
}

}
