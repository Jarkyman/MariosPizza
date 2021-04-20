package menu;

import carte.Pizza;
import ui.UI;

import java.util.ArrayList;

public class RegisterMenu {
  private UI ui = new UI();
  private MainMenu mainMenu = new MainMenu();
  private ArrayList<Pizza> pizzaInOrder = new ArrayList<>();


  public void registerPizza(ArrayList<Pizza> pizzasInMenu) {
    while (!morePizza()) {
      pizzaInOrder.add(pizzaInOrder(choosePizza(pizzasInMenu)));
      morePizza();
    }

  }

  private boolean morePizza() {

    UI ui = new UI("Do you want more?");
    int choice = ui.readChoice();

    if (choice == 1) {
      return false;
    } else if (choice == 2) {
      return true;
    }

    return true;
  }

  public Pizza choosePizza(ArrayList<Pizza> pizzaInMenu) {

    UI ui = new UI(pizzaInMenu, "Choose Pizza: ");

    Pizza pizza = pizzaInMenu.get(ui.readChoice() - 1);

    //chooseToping();

    return pizza;
  }

  private void chooseToping() {

    // tilføj topping

    // + ekstra pris

  }

}
