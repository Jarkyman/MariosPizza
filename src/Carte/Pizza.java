package Carte;

import java.util.ArrayList;

public class Pizza {


  private String name;
  private ArrayList<String>toppings = new ArrayList<>();
  private double price;

  public Pizza(String name, ArrayList<String> toppings, double price) {
    this.name = name;
    this.toppings = toppings;
    this.price = price;
  }
}
