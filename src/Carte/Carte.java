package Carte;

import java.util.ArrayList;

public class Carte {

  public ArrayList<Pizza> pizza = new ArrayList<>();
  public ArrayList<String> topping = new ArrayList<String>();

  public void createAllPizza() {

    topping.add(0,"Ost");
    topping.add(1,"Tomat");
    pizza.add(new Pizza ("1. Margherita", topping.get(0),topping.get(1), 50));
    topping.add (2,"Skinke");
    pizza.add(new Pizza ("2. Vesuvio", topping.get(0),topping.get(1), topping.get(2), 59));
    topping.add(3,"Kødsause");
    topping.add(4,"Løg");
    pizza.add(new Pizza("3. Italiana", topping.get(0),topping.get(1), topping.get(3),topping.get(4), 65));
    topping.add(5,"Kebab");
    topping.add(6,"Bernaise");
    pizza.add(new Pizza("4. SAB", topping.get(0),topping.get(1), topping.get(5),topping.get(6), 65));
    topping.add(7,"Ananas");
    pizza.add(new Pizza("5. Hawaii",topping.get(0),topping.get(1), topping.get(2),topping.get(7), 65));



  }

}
