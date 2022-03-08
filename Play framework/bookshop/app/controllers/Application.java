package controllers;


import com.fasterxml.jackson.databind.JsonNode;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.BodyParser;
public class Application extends Controller {
@BodyParser.Of(BodyParser.Json.class)
public Result acknowledgeGreeting(){
 JsonNode json = request().body().asJson();
 String greeting = json.findPath("greeting").textValue();
 if(greeting == null) {
 return badRequest("Missing parameter [greeting]");
 } else {
 return ok("Your greeting "+greeting+" is accepted" );
 }
 }
}