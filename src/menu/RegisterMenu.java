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

  //private ArrayList<String> registerMenu = new ArrayList<>();
  private ArrayList<Pizza> pizzaInOrder = new ArrayList<>();
  private Order order;
  private UI ui;
  private FileHandling fh = new FileHandling();
  private ArrayList<Order> orders = new ArrayList<>();


  public ArrayList<Order> getOrders(){return orders;}

  public void setOrders (ArrayList<Order> orders){this.orders = orders;}

  public ArrayList<String> menuOption() {
    ArrayList<String> registerMenu = new ArrayList<>();
    registerMenu.add("1. Add Pizza");
    registerMenu.add("2. View order");
    registerMenu.add("3. Remove pizza");
    registerMenu.add("4. Choose pick up time");
    registerMenu.add("5. Finish order");
    return registerMenu;
  }


  public void registerOrder(ArrayList<Pizza> pizzasInMenu) {
    order = new Order();

    int choice = 0;

    while(choice != 5) {

      UI ui = new UI("MENU: ", menuOption(), "PLEASE CHOOSE OPTION: ");
      ui.printMenu();
      choice = ui.readChoice();

      switch (choice) {
        case 1:
          order.addPizza(choosePizza(pizzasInMenu));
          break;
        case 2:
          ui.viewOrder(order);
          break;
        case 3:
          order.removePizza(order);
          break;
        case 4:
          giveName(order);
          choosePickUpTime(order);
          break;
        case 5:
          saveOrderToArray(order);
          fh.saveOrdersToFile("OrderList.txt", orders);
          //Save order in file
          break;
        default:
          ui.returnMessage("NOT A VALID INPUT");
      }
    }

  }

  public void saveOrderToArray(Order order) {
    orders.add(order);
  }

  public void giveName(Order order){

    order.setName(ui.name());
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




