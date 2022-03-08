package models;

import java.util.List;
import controllers.Order;
public class Customer {
 private long id;
 private String name;
 private boolean loyaltyMember;
 private boolean isActive;
 private List<Order> orders;
 public List<Order> getOrders() {
    return orders;
 //Logic
 }
 public boolean deactivate() {
    return isActive;
 //Logic and validation to deactivate a customer
 }
}

