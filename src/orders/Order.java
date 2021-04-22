package orders;

import carte.Carte;
import carte.Pizza;
import ui.UI;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class Order {


  //ATTRIBUTES
  private LocalDateTime timeOfOrder = LocalDateTime.now();
  private LocalDateTime pickUpTime;
  private ArrayList<Pizza> pizzaList = new ArrayList<>();
  private UI ui = new UI();

  private ArrayList<Order> orders = new ArrayList<>();
  private int orderNumber;
  private String name;


  //CONSTRUCTOR
  public Order() {
  }


  public Order(String name, ArrayList<Pizza> pizzaList, LocalDateTime pickUpTime){

    setName(name);
    setPizzaList(pizzaList);
    setPickUpTime(pickUpTime);
  }

  //GETTER
  public String getName() {
    return name;
  }


  public LocalDateTime getPickUpTime() {
    return pickUpTime;
  }


  public ArrayList<Pizza> getPizzaList() {
    return pizzaList;
  }

  public ArrayList<Order> getOrders() {
    return orders;
  }

  public int getOrderNumber() {
    return orderNumber + 1;
  }


  //SETTER
  public void setName(String name) {
    this.name = name;
  }


  public void setPizzaList(ArrayList<Pizza> pizzaList) {
    this.pizzaList = pizzaList;
  }

  public void setOrders(ArrayList<Order> orders) {
    this.orders = orders;
  }


  public void setOrderNumber(int orderNumber) {
    this.orderNumber = orderNumber;
  }

  public void setPickUpTime(LocalDateTime pickUpTime){this.pickUpTime = pickUpTime;}



  //METHODS
  public void addPizza(Pizza pizza) {
    pizzaList.add(pizza);
  }


  public void removePizza(Pizza pizza) {
    pizzaList.remove(pizza);
  }



  public void saveOrderToArray(Order order) {
    orders.add(order);
  }


}
