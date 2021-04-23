package menu;

import carte.Carte;
import carte.Pizza;
import orders.Order;
import ui.FileHandling;
import ui.UI;

import java.util.ArrayList;

public class MainMenu {

  //Attributes
  private UI ui;
  private FileHandling fh = new FileHandling();
  private Carte carte = new Carte();
  private RegisterMenu rm = new RegisterMenu();
  private ArrayList<Order> oldOrders = new ArrayList<>();


  //Methods

  public ArrayList<String> mainMenuOption(){
    ArrayList<String> mainMenu = new ArrayList<>();

    mainMenu.add("1. Show Pizza Menu");
    mainMenu.add("2. Register order");
    mainMenu.add("3. Send order");
    mainMenu.add("4. Remove order");
    mainMenu.add("5. View Orders");
    mainMenu.add("6. View Statistics");
    mainMenu.add("9. Quit");

    return mainMenu;
  }

  public void runMainMenu(){

    carte.setPizza(fh.loadPizzaFromFile("PizzaList.txt"));
    rm.setOrders(fh.loadOrdersFromFile("OrderList.txt"));
    oldOrders = fh.loadOrdersFromFile("OldOrders.txt");


    ui = new UI("MENU", mainMenuOption(), "PLEASE CHOOSE OPTION: ");

    int choice = 0;

    while(choice != 9){
      ui.printMenu();
      choice = ui.readChoice();
      switch(choice){
        case 1:
          ui.showPizzaMenu(carte.getPizza());
          break;
        case 2:
          rm.registerOrder(carte.getPizza());
          break;
        case 3:
          sendOrder(rm.getOrders());
          break;
        case 4:
          removeOrder(rm.getOrders());
          break;
        case 5:
          averageOrderPrice(rm.getOrders());
          ui.viewOrders(rm.getOrders());
          break;
        case 6:
          averageOrderPrice(oldOrders);
          //ui.viewStatistics();
          break;
        case 9:
          ui.returnMessage("QUIT");
          break;
        default:
          ui.returnMessage("NOT A VALID CHOICE");
      }
    }
  }

  public void removeOrder(ArrayList<Order> orders){
    UI ui = new UI();
    ui.returnMessage("Current order: ");
    ui.viewOrders(orders);
    ui.setOption("Select the order you want to remove ");

    long choice = ui.readOrderNumber();

    Order order = null;
    for(Order o : orders){
      if(o.getOrderNumber() == choice){
        order = o;
      }
    }

    if (!(order == null)) {

      orders.remove(order);
      fh.saveOrdersToFile("OrderList.txt", orders);
    }
  }

  public void sendOrder(ArrayList<Order> orders) {
    UI ui = new UI();
    ui.returnMessage("Current order: ");
    ui.viewOrders(orders);
    ui.setOption("Select the order you want to send ");

    long choice = ui.readOrderNumber();

    Order order = null;
    for(Order o : orders){
      if(o.getOrderNumber() == choice){
        order = o;
      }
    }

    if (!(order == null)) {
      ui.printReceipt(order);

      oldOrders.add(order);
      fh.saveOrdersToFile("OldOrders.txt", oldOrders);

      orders.remove(order);
      fh.saveOrdersToFile("OrderList.txt", orders);
    } else {
      ui.returnMessage("Not valid order input");
    }
  }


  public void popularPizza(){
    //how much each pizza is chosen
    //most popular pizza
    //Chirs
  }

  public void totalProfit(){
  //Vitaliy
  }

  public void averageOrderPrice(ArrayList<Order> orders){

    int count = 0;
    double price = 0;
    for(Order o : orders){
      price = o.priceTotal();
      //ui.returnMessage("Order total: " + price);
      count += price;
      }

    //ui.returnMessage("Total profit : " + count);

    double average = count / orders.size();

    ui.returnMessage("Average order price: " + average);

    }

  }




