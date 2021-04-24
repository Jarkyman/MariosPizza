package ui;

import carte.Pizza;
import orders.Order;

import java.util.ArrayList;
import java.util.Arrays;

public class Statistics {

  private int[] count;

/*
  public void pizzaOrderCount(ArrayList<Pizza> pizzaInMenu) {

    counts = new int[pizzaInMenu.size()];
    for (int i = 0; i < counts.length; i++) {
      if (pizza.getName().equals(pizzaInMenu.get(i).getName())) {
        counts[i]++;
      }
    }
  }

 */


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

    System.out.println(Arrays.toString(count));

    int temp = 0;
    int popular = 0;
    for (int i = 0; i < count.length; i++) {
      if (count[i] > temp) {
        temp = count[i];
        popular = i;
      }
    }

    System.out.println(pizzaInMenu.get(popular));

  }

  public static void topChoice(int[] choiceCount, String[] itemList){
    int max = 0;
    int index = 0;
    for(int i = 0; i < choiceCount.length; i++){
      if(choiceCount[i] > max){
        max = choiceCount[i];
        index = i;
      }
    }
    String item = itemList[index];
    System.out.println("The most popular choice was: " + item + ".\nThe number of times it was chosen: " + max);
  }



  public double totalProfit(ArrayList<Order> oldOrders){
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
      count += price;
    }

    double average = count / orders.size();

    System.out.println("Average order price: " + average);
  }




}
