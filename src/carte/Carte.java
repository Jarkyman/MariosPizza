package carte;

import java.util.ArrayList;

public class Carte {
  private UI ui = new UI();

  //Attributes
  public ArrayList<Pizza> pizzas = new ArrayList<>();

  //Setter
  public ArrayList<Pizza> getPizzas() {return pizzas;}

  //Setter
  public void setPizzas(ArrayList<Pizza> pizzas) { this.pizzas = pizzas; }

  //Method
  public void createPizza(){

    String name = ui.readLine();
    ArrayList<String> toppings = ui.returnTopping();
    double price = ui.returnDouble();


    pizzas.add(new Pizza(name, toppings, price));
  }
}


