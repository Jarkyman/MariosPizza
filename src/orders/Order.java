package orders;

import carte.Pizza;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class Order {
  private ArrayList<Pizza> pizzaOrder = new ArrayList<>();

  public ArrayList<Pizza> getPizzaOrder(){return pizzaOrder;}

  public Date dateWhenOrdered() {
    Date date = new Date();
    return date;
  }

  public void timeForPickUp() {
    Calendar now = Calendar.getInstance();
    now.add(Calendar.MINUTE, 20);
    Date twentyMinutesFromNow = now.getTime();
    System.out.println(twentyMinutesFromNow);
  }

  public void addPizza(Pizza pizza) {
    pizzaOrder.add(pizza);
  }

  public void removePizza(Pizza pizza) {
    pizzaOrder.remove(pizza);
  }


}
