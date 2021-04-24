package menu;

import carte.Carte;
import carte.Pizza;
import orders.Order;
import ui.FileHandling;
import ui.Statistics;
import ui.UI;

import java.util.ArrayList;

public class MainMenu {

  //Attributes
  private UI ui;
  private FileHandling fh = new FileHandling();
  private Carte carte = new Carte();
  private RegisterMenu rm = new RegisterMenu();
  private ArrayList<Order> oldOrders = new ArrayList<>();
  private Statistics st = new Statistics();


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
          ui.viewOrders(rm.getOrders());
          break;
        case 6:
          st.popularPizza(oldOrders, carte.getPizza());
          st.averageOrderPrice(oldOrders);
          st.totalProfit(oldOrders);
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
    ui.returnMessage("CURRENT ORDER: ");
    ui.viewOrders(orders);
    ui.setOption("SELECT THE ORDER YOU WANT TO REMOVE (0 FOR EXIT): ");

    long choice = ui.readOrderNumber(orders);

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
    ui.returnMessage("CURRENT ORDER: ");
    ui.viewOrders(orders);
    ui.setOption("SELECT THE ORDER YOU WANT TO SEND: ");

    long choice = ui.readOrderNumber(orders);

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
      ui.returnMessage("NOT A VALID INPUT");
    }
  }

  }




