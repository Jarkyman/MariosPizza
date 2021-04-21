package ui;

import carte.Pizza;
import orders.Order;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Scanner;

public class UI {
  Scanner sc = new Scanner(System.in);

  //ATTRIBUTES
  private String title;
  private ArrayList<String> list = new ArrayList<String>();
  //private ArrayList<Pizza> pizzaList;
  private String option;


  //CONSTRUCTOR

  public UI(){}

  public UI(String title, ArrayList<String> list, String option){
    setTitle(title);
    setList(list);
    setOption(option);
  }
/*
  public UI(String title, ArrayList<Pizza> pizzaList, String option){
    setTitle(title);
    setPizzaList(pizzaList);
    setOption(option);
  }
  */

  //GETTER
  public String getTitle(){
    return title;
  }

  public ArrayList<String> getList(){
    return list;
  }

  /*public ArrayList<Pizza> getPizzaList(){
    return pizzaList;
  }

   */

  public String getOption(){return option;}

  //SETTER
  public void setTitle(String title){this.title = title;}

  public void setList(ArrayList<String> list){this.list = list;}

  //public void setPizzaList(ArrayList<Pizza> pizzaList){this.pizzaList = pizzaList;}

  public void setOption(String option){this.option = option;}


  //METHODS
  public void printMenu(){
    System.out.println(getTitle());
    for(Object s : getList()){
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
  public String readLine(){
    System.out.println(getOption());
    String number = sc.next();
    return number;
  }


  public void returnMessage(String message){
    System.out.println(message);
  }


  public void showPizzaMenu(ArrayList<Pizza> pizzaList){
    for(Pizza p : pizzaList){
      System.out.println(p.getName() +" "+ p.getToppings().toString() +" "+ p.getPrice());
    }
  }

  public void viewOrder(Order order){
    System.out.println(order.getPickUpTime());
    for(Pizza p : order.getPizzaList()){
     System.out.println(p.getName() + " " + p.getToppings().toString() + " " + p.getPrice());
    }
    System.out.println();
  }

  public int time(){
    int choice = sc.nextInt();
    sc.nextLine();

    return choice;
  }

  //RETURN DOUBLE PICK UP TIME

  public void viewStatistics(){}


}
