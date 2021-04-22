package ui;

import carte.Pizza;
import orders.Order;

import javax.sound.midi.Soundbank;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
    //System.out.println(getOption());
    String number = sc.next();
    return number;
  }

  public void returnMessage(String message){
    System.out.println(message);
  }


  public void showPizzaMenu(ArrayList<Pizza> pizzaList){
    for(int i = 0; i < pizzaList.size(); i++){
      System.out.println((i + 1) + "" + pizzaList.get(i).printToFile());
/*
      System.out.println(pizzaList.get(i) + pizzaList.get(i).getName() +" "+
          pizzaList.get(i).getToppings().toString() +" "+ pizzaList.get(i).getPrice());

 */
    }
  }

  public void viewOrder(Order order){
    System.out.println("PICK UP TIME: " + order.getPickUpTime());
    System.out.println("Pizzas: ");
    int count = 1;

    for(Pizza p : order.getPizzaList()){
     System.out.println((count++) + ". " + p.getName() + " " + p.getToppings().toString() + " " + p.getPrice());

    }
    System.out.println();
  }

  public void viewOrders(ArrayList<Order> orders){
    for(Order o : orders){
      System.out.println("Order number: " + o.getOrderNumber() + "\nCostumers name: " + o.getName() +
          "\nPick up time: " + o.getPickUpTime() + "\n Order: " + o.getPizzaList());
    }

  }

  public String name(){
    System.out.println("Enter name of costumer: ");
    String name = sc.nextLine();

    return name;
  }


  public LocalDate date(){

    System.out.println("Enter date (dd-mm-yyyy): ");
    String input = sc.nextLine();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    LocalDate date = LocalDate.parse(input, formatter);

    System.out.println(date);
    return date;
  }

  public LocalTime time() {

    System.out.println("PLEASE CHOOSE A PICK UP TIME (hh:mm): ");

    String input = sc.nextLine();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    LocalTime time = LocalTime.parse(input, formatter);

    System.out.println(time);
    return time;
  }


  public void viewStatistics(){}


}
