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

  //Attributes
  private Order order;
  private UI ui;
  private FileHandling fh = new FileHandling();
  private ArrayList<Order> orders = new ArrayList<>();

  //Getter
  public ArrayList<Order> getOrders(){return orders;}

  //Setter
  public void setOrders (ArrayList<Order> orders){this.orders = orders;}

  //Methods
  public ArrayList<String> menuOption() {
    ArrayList<String> registerMenu = new ArrayList<>();
    registerMenu.add("1. Add Pizza");
    registerMenu.add("2. View order");
    registerMenu.add("3. Remove pizza");
    registerMenu.add("4. Change pick up time");
    registerMenu.add("5. Change name");
    registerMenu.add("6. Finish order");
    return registerMenu;
  }

  public void registerOrder(ArrayList<Pizza> pizzasInMenu) {
    order = new Order();
    Pizza pizza = choosePizza(pizzasInMenu);
    order.addPizza(pizza.getName());
    order.addPizzaPrice(pizza.getPrice());
    order.setName(ui.name());
    choosePickUpTime(order);

    //Does it work?
    order.setOrderNumber(order.giveOrderNumber());


    int choice = 0;
    int menuOptions = 7;

    while(choice != 6) {

      UI ui = new UI("MENU: ", menuOption(), "PLEASE CHOOSE OPTION: ");
      ui.printMenu();
      choice = ui.readChoice(menuOptions);

      switch (choice) {
        case 1:
          pizza = choosePizza(pizzasInMenu);
          order.addPizza(pizza.getName());
          order.addPizzaPrice(pizza.getPrice());
          break;
        case 2:
          ui.viewOrder(order);
          break;
        case 3:
          order.removePizza(order);
          break;
        case 4:
          choosePickUpTime(order);
          break;
        case 5:
          giveName(order);
          break;
        case 6:
          saveOrderToArray(order);
          fh.saveOrdersToFile("OrderList.txt", orders);
          break;
        default:
          ui.returnMessage("NOT A VALID INPUT");
      }
    }
  }

  public void saveOrderToArray(Order order) {

    boolean flag = true;

    for (int i = 0; i < orders.size(); i++) {
      if(flag) {
        if (order.getPickUpTime().isBefore(orders.get(i).getPickUpTime())) {
          orders.add(i, order);
          flag = false;
        }
      }
    }

    if(flag) {
      orders.add(order);
    }

    ui.viewOrder(order);
  }

  public void giveName(Order order){
    order.setName(ui.name());
  }

  public Pizza choosePizza(ArrayList<Pizza> pizzaInMenu) {

    ui = new UI();
    ui.returnMessage("MENU: ");
    ui.showPizzaMenu(pizzaInMenu);
    ui.setOption("PLEASE CHOOSE A PIZZA ON THE MENU: ");

    int choice =  ui.readChoice(pizzaInMenu.size());

    Pizza pizza = pizzaInMenu.get(choice - 1);

    System.out.println(choice + ". " + pizza.getName());

    return pizza;
  }

  public LocalDateTime choosePickUpTime(Order order) {

    LocalDate date = ui.date();
    LocalTime time = ui.time();

    order.setPickUpTime(LocalDateTime.of(date, time));

    return LocalDateTime.of(date, time);
  }


  }




