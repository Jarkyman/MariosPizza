package menu;

import ui.UI;

import java.util.ArrayList;

public class MainMenu {

  private ArrayList<String> mainMenu = new ArrayList<>();


  public void runMainMenu(){

    mainMenu.add("1. Show Pizza Menu");
    mainMenu.add("2. Register order");
    mainMenu.add("3. Send order");
    mainMenu.add("4. Remove order");
    mainMenu.add("5. View Orders");
    mainMenu.add("6. View Statistics");
    mainMenu.add("9. Quit");

    UI ui = new UI("MENU", mainMenu, "PLEASE CHOOSE OPTION: ");

    int choice = 0;

    while(choice != 9){
      ui.printMenu();
      choice = ui.readChoice();
      switch(choice){
        case 1:
          ui.showPizzaMenu();
          break;
        case 2:
          registerOrder();
          break;
        case 3:
          sendOrder();
          break;
        case 4:
          removeOrder();
          break;
        case 5:
          ui.viewOrders();
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
