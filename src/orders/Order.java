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
  private LocalTime pickUpTime;
  private ArrayList<Pizza> pizzaList = new ArrayList<>();
  private UI ui = new UI();



  private String name;

  //CONSTRUCTOR
  public Order(){}

  public Order(String name, ArrayList<Pizza> pizzaList, LocalTime pickUpTime){
    setName(name);
    setPizzaList(pizzaList);
    setPickUpTime(pickUpTime);
  }

  //GETTER
  public String getName(){return name;}

  public LocalDateTime getTimeOfOrder(){
    return timeOfOrder;
  }

  public LocalTime getPickUpTime(){return pickUpTime;}

  public ArrayList<Pizza> getPizzaList(){
    return pizzaList;
  }



  //SETTER
  public void setName(String name){this.name = name;}


  public void setPickUpTime(LocalTime pickUpTime){this.pickUpTime = pickUpTime;}

  public void setPizzaList(ArrayList<Pizza> pizzaList){this.pizzaList = pizzaList;}

  //METHODS
  public void addPizza(Pizza pizza){
    pizzaList.add(pizza);
  }


  public void removePizza(Pizza pizza){
    pizzaList.remove(pizza);
  }


  public void choosePickUpTime(Order order) {

    ui.returnMessage("PLEASE CHOOSE A PICK UP TIME: ");
    ui.returnMessage("HOUR:");
    int hour = ui.time();
    ui.returnMessage("MINUTE:");
    int minute = ui.time();

    order.setPickUpTime(LocalTime.of(hour, minute));

    System.out.println(order.getPickUpTime());
  }


}
