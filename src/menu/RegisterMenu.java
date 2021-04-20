package menu;

import ui.UI;

import java.util.ArrayList;

public class RegisterMenu {
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
    }
  }
}
