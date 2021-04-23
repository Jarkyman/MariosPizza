package carte;

import java.util.ArrayList;

public class Pizza {

  //Attributes
  private String name;
  private ArrayList<String>toppings = new ArrayList<>();
  private double price;

  //Constructor
  public Pizza(String name, ArrayList<String> toppings, double price) {
    setName(name);
    setToppings(toppings);
    setPrice(price);
  }

  //Getter
  public String getName() {
    return name;
  }

  public ArrayList<String>getToppings() {
    return toppings;
  }

  public double getPrice()  {
    return price;
  }


  //Setter
  public void setName(String name) {
    this.name = name;
  }

  public void setToppings(ArrayList<String> toppings) {
    this.toppings = toppings;
  }

  public void setPrice(double price)  {

    this.price = price;
  }

  //Methods
  @Override
  public String toString() {
    return name + "\n" + toppings + "\n" + price;
  }

  public String print(){
    return ". " +  name + ", toppings:"   + toppings + ", price: " + price;
  }
}