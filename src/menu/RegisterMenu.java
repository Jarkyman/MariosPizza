package menu;

import carte.Pizza;
import orders.Order;
import ui.FileHandling;
import ui.UI;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class RegisterMenu {

  private ArrayList<String> registerMenu = new ArrayList<>();
  private ArrayList<Pizza> pizzaInOrder = new ArrayList<>();
  private Order order = new Order();
  private UI ui;
  private FileHandling fh = new FileHandling();


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
    registerMenu.add("5. Finish order");
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
          removePizzas();
          break;
        case 4:
          choosePickUpTime(order);
          break;
        case 5:
          fh.saveOrdersToFile(order);
          //Save order in file
          break;
        default:
          ui.returnMessage("NOT A VALID INPUT");
      }
    }

    return true;
  }

  public Pizza choosePizza(ArrayList<Pizza> pizzaInMenu) {

    ui = new UI();
    ui.returnMessage("MENU: ");
    ui.showPizzaMenu(pizzaInMenu);
    ui.setOption("PLEASE CHOOSE AN OPTION: ");

    int choice =  ui.readChoice();

    Pizza pizza = pizzaInMenu.get(choice - 1);

    System.out.println(pizza.getName());
    //chooseTopping();

    return pizza;
  }


  public void removePizzas() {    //Remove pizza(s) from ongoing order
    ui = new UI();
    ui.returnMessage("Current order: ");
    ui.viewOrder(order);
    ui.setOption("Select the pizza you want to remove ");

    int choice = ui.readChoice();
    for (int i = 0; i < order.getPizzaList().size(); i++) {

      Pizza pizza = order.getPizzaList().remove(choice - 1);
      if (order.getPizzaList().remove(pizza)) {
        order.removePizza(pizza);

        ui.viewOrder(order);
      }
      //Pizza pizza = ui.getPizzaList().remove(choice - 1);
      //System.out.println(pizza.getName());
      //return pizza;
    }
  }

  public LocalDateTime choosePickUpTime(Order order) {

    LocalDate date = ui.date();
    LocalTime time = ui.time();

    order.setPickUpTime(LocalDateTime.of(date, time));

    return LocalDateTime.of(date, time);
  }


/*
    private void chooseTopping() {

      // tilføj topping

      // + ekstra pris

    }

 */

  }




