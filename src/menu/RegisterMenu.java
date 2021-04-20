package menu;

import ui.UI;

public class RegisterMenu {
  UI ui = new UI();
  MainMenu mainMenu = new MainMenu();

  public void runRegisterMenu(){
    int choice = 0;

    while(choice != 9){
      ui.printRegisterMenu();
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
    }
  }
}
