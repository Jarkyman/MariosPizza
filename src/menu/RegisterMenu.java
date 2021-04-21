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
    registerMenu.add("3. Remove pizza");
    registerMenu.add("4. Choose pick up time");
    registerMenu.add("3. Finish order");
  }

  private boolean morePizza() {

    int choice = 0;

    while(choice != 5) {

      UI ui = new UI("MENU: ", registerMenu, "PLEASE CHOOSE OPTION: ");
      ui.printMenu();
      choice = ui.readChoice();

      switch (choice) {
        case 1:
          return false;
        case 2:
          ui.viewOrder(order);
          break;
        case 3:
          //removePizzas();
          break;
        case 4:
          order.choosePickUpTime(order);
        case 5:
          //Save order in file
          break;
        default:
          ui.returnMessage("NOT A VALID INPUT");
      }
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
    //chooseTopping();

    return pizza;
  }


  private void chooseTopping() {

    // tilføj topping

    // + ekstra pris

  }
}



