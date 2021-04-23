package ui;

import java.util.ArrayList;

public class Statistics {

  public void pizzaOrderCount(ArrayList<Pizza> pizzaInMenu, ) {

    counts = new int[pizzaInMenu.size()];
    for (int i = 0; i < counts.length; i++) {
      if (pizza.getName().equals(pizzaInMenu.get(i).getName())) {
        counts[i]++;
      }
    }
  }



  public void popularPizza(){
    //how much each pizza is chosen
    //most popular pizza
    //Chirs
  }

  public double totalProfit(){
    double profit = 0;
    for (int i = 0; i < oldOrders.size();i++){
      profit += oldOrders.get(i).priceTotal();
    }
    return profit;
  }

  public void averageOrderPrice(ArrayList<Order> orders){

    int count = 0;
    double price = 0;
    for(Order o : orders){
      price = o.priceTotal();
      //ui.returnMessage("Order total: " + price);
      count += price;
    }

    //ui.returnMessage("Total profit : " + count);

    double average = count / orders.size();

    ui.returnMessage("Average order price: " + average);

  }
}
