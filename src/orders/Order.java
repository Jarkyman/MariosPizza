package orders;


import ui.UI;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;


public class Order {


  //ATTRIBUTES
  private LocalDateTime pickUpTime;
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

  public ArrayList<String> getPizzaNames() {return pizzaNames; }

  public long getOrderNumber() {
    return orderNumber;
  }


  //SETTER
  public void setName(String name) {

    String[] nameSplitter = name.split(" ");

    for (int i = 0; i < nameSplitter.length; i++) {
      nameSplitter[i] = nameSplitter[i].substring(0,1).toUpperCase() + nameSplitter[i].substring(1).toLowerCase();
    }
    name = String.join(" ", nameSplitter);

    this.name = name;
  }

  public void setPizzaPrice(ArrayList<Double> pizzaPrice){this.pizzaPrice = pizzaPrice;}

  public void setPizzaNames(ArrayList<String> pizzaNames) { this.pizzaNames = pizzaNames; }

  public void setOrderNumber(long orderNumber) {
    this.orderNumber = orderNumber;
  }

  public void setPickUpTime(LocalDateTime pickUpTime){
    this.pickUpTime = pickUpTime;
  }



  //METHODS

  //Change to one method???
  public void addPizza(String pizzaName) {
    pizzaNames.add(pizzaName);}
  public void addPizzaPrice(double price) {
    pizzaPrice.add(price); }


  public void removePizza(Order order) {    //Remove pizza(s) from ongoing order
    ui = new UI();
    ui.returnMessage("CURRENT ORDER: ");
    ui.viewOrder(order);
    ui.setOption("SELECT THE PIZZA YOU WANT TO REMOVE: ");

    int choice = ui.readChoice(getPizzaNames().size());

    order.getPizzaNames().remove(choice - 1);
    order.getPizzaPrice().remove(choice - 1);
    ui.viewOrder(order);

  }

  public double priceTotal(){

    double count = 0;
    for(double d : getPizzaPrice()){
      count += d;
    }

    return count;
  }

  public long giveOrderNumber() {

    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyHHmmss");
    long orderNumber = Long.parseLong(formatter.format(date));

    return orderNumber;
  }

}
