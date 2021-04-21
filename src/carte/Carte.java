package carte;

import java.util.ArrayList;

public class Carte {

  public ArrayList<Pizza> pizza = new ArrayList<>();
  public ArrayList<String> topping = new ArrayList<String>();

  public void createAllPizza() {

    topping.add(0,"Ost");
    topping.add(1,"Tomat");
    pizza.add(new Pizza ("1. Margherita", topping, 50));
    topping.add (2,"Skinke");
    pizza.add(new Pizza("2. Vesuvio", topping, 59));
    topping.add(3,"Kødsause");
    topping.add(4,"Løg");
    pizza.add(new Pizza("3. Italiana", topping, 65));
    topping.add(5,"Kebab");
    topping.add(6,"Bernaise");
    pizza.add(new Pizza("4. SAB", topping, 65));
    topping.add(7,"Ananas");
    pizza.add(new Pizza("5. Hawaii",topping, 65));



  }

  public ArrayList<Pizza> getPizza() {return pizza;}

  public void setPizza(ArrayList<Pizza> pizza) { this.pizza = pizza; }

}


