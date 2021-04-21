package orders;

import carte.Carte;
import carte.Pizza;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class Order {

  private ArrayList<Order> pizzaOrder = new ArrayList<>();
  private Date dateOfOrder =  dateWhenOrdered();
  private  Date timePickUp = timeForPickUp();
  private boolean isComplete = false;



  public Date getDateOfOrder() {
    return dateOfOrder;
  }

  public Date getTimePickUp() {
    return timePickUp;
  }

  public boolean isComplete() {
    return isComplete;
  }

  public ArrayList<Order> getPizzaOrder(){
    return pizzaOrder;}


  public Date dateWhenOrdered() {
    Date date = new Date();
    return date;
  }

  public Date timeForPickUp() {
    Calendar now = Calendar.getInstance();
    now.add(Calendar.MINUTE, 20);
    Date twentyMinutesFromNow = now.getTime();
    System.out.println(twentyMinutesFromNow);
    return twentyMinutesFromNow;
  }

  public void addPizzaOrder(Order order) {
    pizzaOrder.add(order);
  }

  public void removePizza(Pizza pizza) {
    pizzaOrder.remove(pizza);
  }

  public void makeOrder (Pizza pizza, Date dateOfOrder, Date timePickUp, boolean isComplete){
    // optionally quantity later
    while (isComplete){
      pizzaOrder.add(pizza,dateOfOrder,timePickUp);

    }
  }

  public void becomeComplete() {
    isComplete = true;}


}
