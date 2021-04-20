package menu;

public class MainMenu {

  public void runMainMenu(){
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
