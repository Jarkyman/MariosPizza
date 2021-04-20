package menu;

import carte.Carte;
import carte.Pizza;
import orders.Order;
import ui.FileHandling;
import ui.UI;

import java.util.ArrayList;

public class MainMenu {

  private ArrayList<String> mainMenu = new ArrayList<>();
  private UI ui;
  private FileHandling fh = new FileHandling();
  private Carte carte = new Carte();
  private RegisterMenu rm = new RegisterMenu();



  public void runMainMenu(){

    carte.setPizza(fh.loadPizzaFromFile("PizzaList.txt"));

    mainMenu.add("1. Show Pizza Menu");
    mainMenu.add("2. Register order");
    mainMenu.add("3. Send order");
    mainMenu.add("4. Remove order");
    mainMenu.add("5. View Orders");
    mainMenu.add("6. View Statistics");
    mainMenu.add("9. Quit");

    ui = new UI("MENU", mainMenu, "PLEASE CHOOSE OPTION: ");

    int choice = 0;

    while(choice != 9){
      ui.printMenu();
      choice = ui.readChoice();
      switch(choice){
        case 1:
          ui.showPizzaMenu(carte.getPizza());
          break;
        case 2:
          rm.registerPizza(carte.getPizza());
          break;
        case 3:
//          sendOrder();
          break;
        case 4:
//          removeOrder();
          break;
        case 5:
//          ui.viewOrders();
          break;
        case 6:
          ui.viewStatistics();
          break;
        case 9:
          ui.returnMessage("QUIT");
          break;
        default:
          ui.returnMessage("NOT A VALID CHOICE");
      }
    }
  }

}
