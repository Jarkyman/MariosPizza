package orders;

import carte.Carte;
import carte.Pizza;
import menu.RegisterMenu;
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
  private ArrayList<String> pizzaNames = new ArrayList<>();
  private ArrayList<Double> pizzaPrice = new ArrayList<>();
  private UI ui = new UI();

  private long orderNumber;
  private String name;


  //CONSTRUCTOR
  public Order() {
  }


  public Order(String name, ArrayList<Double> pizzaPrice, ArrayList<String> pizzaNames, LocalDateTime pickUpTime){
    setName(name);
    setPizzaPrice(pizzaPrice);
    setPizzaNames(pizzaNames);
    setPickUpTime(pickUpTime);
  }

  public Order(long orderNumber, String name, ArrayList<Double> pizzaPrice, ArrayList<String> pizzaNames, LocalDateTime pickUpTime){
    setOrderNumber(orderNumber);
    setName(name);
    setPizzaPrice(pizzaPrice);
    setPizzaNames(pizzaNames);
    setPickUpTime(pickUpTime);
  }

  //GETTER
  public String getName() {
    return name;
  }

  public ArrayList<Double> getPizzaPrice() { return pizzaPrice; }

  public LocalDateTime getPickUpTime() {
    return pickUpTime;
  }


//  public ArrayList<Pizza> getPizzaList() {
//    return pizzaList;
//  }
  public ArrayList<String> getPizzaNames() {return pizzaNames; }

  //public ArrayList<Order> getOrders() {return orders;}

  public long getOrderNumber() {
    return orderNumber;
  }


  //SETTER
  public void setName(String name) {
    this.name = name;
  }


  public void setPizzaList(ArrayList<Pizza> pizzaList) {
    this.pizzaList = pizzaList;
  }
  public void setPizzaNames(ArrayList<String> pizzaNames) { this.pizzaNames = pizzaNames; }

  //public void setOrders(ArrayList<Order> orders) {this.orders = orders;}


  public void setOrderNumber(long orderNumber) {
    this.orderNumber = orderNumber;
  }

  public void setPickUpTime(LocalDateTime pickUpTime){
    this.pickUpTime = pickUpTime;
  }



  //METHODS
  /*public void addPizza(Pizza pizza) {
    pizzaList.add(pizza);
  }*/

  public void addPizza(String pizzaName) {pizzaNames.add(pizzaName);}
  public void addPizzaPrice(double price) {pizzaPrice.add(price); }

  public void removePizza(Order order) {    //Remove pizza(s) from ongoing order
    ui = new UI();
    ui.returnMessage("Current order: ");
    ui.viewOrder(order);
    ui.setOption("Select the pizza you want to remove ");

    int choice = ui.readChoice();

    order.getPizzaNames().remove(choice - 1);
    order.getPizzaPrice().remove(choice - 1);
    ui.viewOrder(order);

  }



}
