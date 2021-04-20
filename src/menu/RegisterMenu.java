package menu;

import carte.Pizza;
import ui.UI;

import java.util.ArrayList;

public class RegisterMenu {
<<<<<<< HEAD
  MainMenu mainMenu = new MainMenu();
  private ArrayList<String> registerMenu = new ArrayList<>();

  public void runRegisterMenu(){

    registerMenu.add("1. Add extra Pizza");
    registerMenu.add("2. Finish order");

    UI ui = new UI("MENU: ", registerMenu, "PLEASE CHOOSE OPTION: ");

    int choice = 0;

    while(choice != 9){
      ui.printMenu();
      choice = ui.readChoice();

      switch(choice){
        case 1:
          choosePizza();
          break;
        case 2:
          chooseExtraTopping();
          break;
        case 3:
          addExtraPizza();
          break;
        case 4:
          finishOrder();
          break;
        case 9:
          mainMenu.runMainMenu();
      }
=======

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
>>>>>>> a5cf071ae92ce8cf6cc06e0481254c6aaaa5a8be
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
