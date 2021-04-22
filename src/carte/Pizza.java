package carte;

import java.util.ArrayList;

public class Pizza {
  private int number;
  private String name;
  private ArrayList<String>toppings = new ArrayList<>();
  private double price;

  public Pizza(String name, ArrayList<String> toppings, double price) {
    this.name = name;
    this.toppings = toppings;
    this.price = price;
  }

  public int getNumber(){return number;}

  public void setNumber(int number){this.number = number;}

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public ArrayList<String>getToppings() {
    return toppings;
  }
  public void setToppings(ArrayList<String> toppings) {
    this.toppings = toppings;
  }
  public double getPrice()  {
    return price;
  }
  public void setPrice(double price)  {

    this.price = price;
  }

  @Override
  public String toString() {
    return name + "\n" + toppings + "\n" + price;
  }

  public String printToFile(){
    return ". " +  name + ", toppings:"   + toppings + ", price: " + price;
  }
}