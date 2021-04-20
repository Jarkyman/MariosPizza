package menu;

import carte.Pizza;
import orders.Order;
import ui.UI;

import java.util.ArrayList;

public class RegisterMenu {

  private ArrayList<String> registerMenu = new ArrayList<>();
  private ArrayList<Pizza> pizzaInOrder = new ArrayList<>();
  private Order order = new Order();


  public void registerPizza(ArrayList<Pizza> pizzasInMenu) {
    morePizzaOption();
    boolean quit = false;

    while (!quit) {
      order.addPizza(choosePizza(pizzasInMenu));

      quit = morePizza();
    }

  }

  private void morePizzaOption() {
    registerMenu.add("1. Add Pizza");
    registerMenu.add("2. View order");
    registerMenu.add("3. Finish order");
  }

  private boolean morePizza() {

    UI ui = new UI("MENU: ", registerMenu, "PLEASE CHOOSE OPTION: ");
    ui.printMenu();
    int choice = ui.readChoice();

    if (choice == 1) {
      return false;
    } else if (choice == 2) {
      ui.viewOrder(order);
      return false;
    } else if(choice == 3){
      //Save order in file
      return true;
    }

    return true;
  }

  public Pizza choosePizza(ArrayList<Pizza> pizzaInMenu) {

    UI ui = new UI();
    ui.returnMessage("MENU: ");
    ui.showPizzaMenu(pizzaInMenu);
    ui.setOption("PLEASE CHOOSE AN OPTION: ");

    int choice =  ui.readChoice();

    Pizza pizza = pizzaInMenu.get(choice - 1);

    System.out.println(pizza.getName());
    //chooseToping();

    return pizza;
  }


  private void chooseToping() {

    // tilføj topping

    // + ekstra pris

  }
}



