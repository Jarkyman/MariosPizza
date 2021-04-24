package ui;

import carte.Pizza;
import orders.Order;

import java.util.ArrayList;
import java.util.Arrays;

public class Statistics {

  private int[] count;
  private UI ui = new UI();


  public void popularPizza(ArrayList<Order> oldOrders, ArrayList<Pizza> pizzaInMenu){

    count = new int[pizzaInMenu.size()];

    for(int i = 0; i < oldOrders.size(); i++){

      for(int j = 0; j < pizzaInMenu.size(); j++) {
        for(int k = 0; k < oldOrders.get(i).getPizzaNames().size(); k++){
          if (oldOrders.get(i).getPizzaNames().get(k).equals(pizzaInMenu.get(j).getName())) {
            count[j]++;
          }
        }
      }
    }

    //System.out.println(Arrays.toString(count));

    int temp = 0;
    int popular = 0;
    for (int i = 0; i < count.length; i++) {
      if (count[i] > temp) {
        temp = count[i];
        popular = i;
      }
    }

    ui.returnMessage("The most popular pizza is: " + pizzaInMenu.get(popular).getName());

  }

  public void totalProfit(ArrayList<Order> oldOrders){
    double profit = 0;
    for (int i = 0; i < oldOrders.size();i++){
      profit += oldOrders.get(i).priceTotal();
    }

    String p = String.valueOf(profit);

    ui.returnMessage("Total profit is: " + p + " DKK");
  }

  public void averageOrderPrice(ArrayList<Order> oldOrders){

    int count = 0;
    double price = 0;
    for(Order o : oldOrders){
      price = o.priceTotal();
      count += price;
    }

    double average = count / oldOrders.size();

    System.out.println("Average order price: " + average + " DKK");
  }




}
