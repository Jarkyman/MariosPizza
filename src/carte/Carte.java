package carte;

import java.util.ArrayList;

public class Carte {

  //Attributes
  public ArrayList<Pizza> pizza = new ArrayList<>();
  public ArrayList<String> topping = new ArrayList<String>();

  //getter
  public ArrayList<Pizza> getPizza() {return pizza;}

  //setter
  public void setPizza(ArrayList<Pizza> pizza) { this.pizza = pizza; }

  //method
  public void createPizza() {

    //topping.add(topping);
    //pizza.add(pizza);

  }


}


