package Carte;

<<<<<<< HEAD
public class Carte {

=======
import java.util.ArrayList;

public class Carte {

  public ArrayList<String> topping = new ArrayList<String>();

  public void createAllPizza() {

    topping.add("Ost");
    topping.add("Tomat");
    new Pizza ("Hej", topping, 57);
    topping.add("Kebab");
    new Pizza ("Pizza 2", topping, 89);
    topping.remove(2);
    topping.add("Peperoni");
    new Pizza("Pizza 3", topping, 58);
  }

>>>>>>> 4de015141b30bfbf1aac3c683dea61dad7919bb9
}
