package ui;

import carte.Pizza;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Scanner;

public class UI {
  Scanner sc = new Scanner(System.in);

  //ATTRIBUTES
  private String title;
  private ArrayList<String> list;
  private String option;


  //CONSTRUCTOR
  public UI(String title, ArrayList<String> list, String option){
    setTitle(title);
    setList(list);
    setOption(option);
  }

  //GETTER
  public String getTitle(){
    return title;
  }

  public ArrayList<String> getList(){
    return list;
  }

  public String getOption(){return option;}

  //SETTER
  public void setTitle(String title){this.title = title;}

  public void setList(ArrayList<String> list){this.list = list;}

  public void setOption(String option){this.option = option;}


  //METHODS
  public void printMenu(){
    System.out.println(getTitle());
    for(String s : getList()){
      System.out.println(s);
    }
  }

  public int readChoice(){
    System.out.println(getOption());

    int choice = 0;
    choice = sc.nextInt();
    sc.nextLine();

    return choice;
  }

  public void returnMessage(String message){
    System.out.println(message);
  }



  //Might not need
  public void showPizzaMenu(ArrayList<Pizza> pizzaList){
    for(Pizza p : pizzaList){
      System.out.println(p.toString());
    }
  }

  public void viewOrders(){}

  public void viewStatistics(){}


}
