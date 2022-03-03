package models;

import javax.persistence.*;
@Entity
@Table(name="book")
public class Book extends Model {
 @Id
 private String id;
 private String name;
 private String author;
 public String getId() {
 return id;
 }
 public void setId(String id) {
 this.id = id;
 }
}
