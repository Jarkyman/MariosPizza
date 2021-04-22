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

<<<<<<< HEAD
  public Order(int orderNumber, String name, ArrayList<Pizza> pizzaList, LocalTime pickUpTime) {
    setOrderNumber(orderNumber);
=======
  public Order(String name, ArrayList<Pizza> pizzaList, LocalDateTime pickUpTime){
>>>>>>> b434630d61ed206b40d832f8b16ce288b549ca25
    setName(name);
    setPizzaList(pizzaList);
    setPickUpTime(pickUpTime);
  }

  //GETTER
  public String getName() {
    return name;
  }

  public LocalDateTime getTimeOfOrder() {
    return timeOfOrder;
  }

<<<<<<< HEAD
  public LocalTime getPickUpTime() {
    return pickUpTime;
  }
=======
  public LocalDateTime getPickUpTime(){return pickUpTime;}
>>>>>>> b434630d61ed206b40d832f8b16ce288b549ca25

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

  public void setPickUpTime(LocalTime pickUpTime) {
    this.pickUpTime = pickUpTime;
  }

  public void setPizzaList(ArrayList<Pizza> pizzaList) {
    this.pizzaList = pizzaList;
  }

  public void setOrders(ArrayList<Order> orders) {
    this.orders = orders;
  }

<<<<<<< HEAD
  public void setOrderNumber(int orderNumber) {
    this.orderNumber = orderNumber;
  }
=======
  public void setPickUpTime(LocalDateTime pickUpTime){this.pickUpTime = pickUpTime;}
>>>>>>> b434630d61ed206b40d832f8b16ce288b549ca25


  //METHODS
  public void addPizza(Pizza pizza) {
    pizzaList.add(pizza);
  }


  public void removePizza(Pizza pizza) {
    pizzaList.remove(pizza);
  }


<<<<<<< HEAD
  public void choosePickUpTime(Order order) {

    ui.returnMessage("PLEASE CHOOSE A PICK UP TIME: ");
    ui.returnMessage("HOUR:");
    int hour = ui.time();
    ui.returnMessage("MINUTE:");
    int minute = ui.time();

    order.setPickUpTime(LocalTime.of(hour, minute));

    System.out.println(order.getPickUpTime());
  }


  public void saveOrderToArray(Order order) {
    orders.add(order);
  }

=======
>>>>>>> b434630d61ed206b40d832f8b16ce288b549ca25
}
