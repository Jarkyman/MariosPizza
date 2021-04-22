package ui;

import carte.Pizza;
import orders.Order;

import javax.sound.midi.Soundbank;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.LocalDateTime;
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

    for(String n : order.getPizzaNames()){
      System.out.println(count++ + ". " + n);
//     System.out.println((count++) + ". " + n.getName() + " " + n.getToppings().toString() + " " + n.getPrice());

    }
    System.out.println();
  }

  public void viewOrders(ArrayList<Order> orders){
    for(Order o : orders){
      String pickUpTime = o.getPickUpTime().toString();
      pickUpTime = pickUpTime.replaceAll("T", " ");

      System.out.println("--------------------------------------");
      System.out.println("Order number: " + o.getOrderNumber() + "\nCostumers name: " + o.getName() +
          "\nPrice: " + o.priceTotal() + "\nPick up time: " + pickUpTime + "\n Order: " + o.getPizzaNames().toString());
    }
    System.out.println("--------------------------------------\n");

  }

  public String name() {
    System.out.println("Enter name of costumer: ");
    String name = sc.nextLine();

    return name;
  }


  public LocalDate date(){

    System.out.println("Enter date (dd-mm-yyyy): ");
    String input = sc.nextLine();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    LocalDate date = LocalDate.parse(input, formatter);

//    System.out.println(date);
    return date;

  }

  public LocalTime time() {

    System.out.println("PLEASE CHOOSE A PICK UP TIME (hh:mm): ");

    String input = sc.nextLine();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    LocalTime time = LocalTime.parse(input, formatter);

//    System.out.println(time);
    return time;
  }


  public LocalDateTime dateTime(){
    System.out.println("PLEASE CHOOSE A PICK UP TIME (dd-mm-yyyy hh:mm): ");

    String input = sc.nextLine();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    LocalDateTime dateTime = LocalDateTime.parse(input, formatter);

    System.out.println(dateTime);
    return dateTime;
  }

  /*public LocalDateTime dateTime(){
    System.out.println("PLEASE CHOOSE A PICK UP TIME (dd-mm-yyyy hh:mm): ");
    String input = sc.nextLine();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    LocalDateTime dateTime = LocalDateTime.parse(input, formatter);
    System.out.println(dateTime);
    return dateTime;
  }*/

  public void printReceipt(Order order) {

    String pickUpTime = order.toString();
    pickUpTime = pickUpTime.replaceAll("T", " ");

    System.out.println("----------------RECEIPT---------------");
    System.out.println("--------------------------------------");
    System.out.println(order.getName());
    System.out.println(order.getPizzaNames());
    System.out.println(order.getPickUpTime());
    System.out.println(order.priceTotal());
    System.out.println("--------------------------------------\n");


  }


  public void viewStatistics(){}


}
