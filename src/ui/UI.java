package ui;

import carte.Pizza;
import orders.Order;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class UI {
  Scanner sc = new Scanner(System.in);

  //Attributes
  private String title;
  private ArrayList<String> list = new ArrayList<String>();
  private String option;


  //Constructors
  public UI(){}

  public UI(String title, ArrayList<String> list, String option){
    setTitle(title);
    setList(list);
    setOption(option);
  }

  //Getters
  public String getTitle(){
    return title;
  }

  public ArrayList<String> getList(){
    return list;
  }

  public String getOption(){return option;}

  //Setters
  public void setTitle(String title){this.title = title;}

  public void setList(ArrayList<String> list){this.list = list;}

  public void setOption(String option){this.option = option;}


  //Methods
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

  public long readOrderNumber(){
    System.out.println(getOption());

    long choice = 0;
    choice = sc.nextLong();
    sc.nextLine();

    return choice;
  }

  public String readLine(){
    String line = sc.next();
    return line;
  }

  public void returnMessage(String message){
    System.out.println(message);
  }


  public void showPizzaMenu(ArrayList<Pizza> pizzaList){
    for(int i = 0; i < pizzaList.size(); i++){
      System.out.println((i + 1) + "" + pizzaList.get(i).print().replaceAll("\\[", "").
          replaceAll("]", ""));
    }
  }

  public void viewOrder(Order order){
    String pickUpTime = order.getPickUpTime().toString();
    pickUpTime = pickUpTime.replaceAll("T", " ");

    System.out.println("PICK UP TIME: " + pickUpTime);
    System.out.println("Customers name: " + order.getName());
    System.out.println("Pizzas: ");
    int count = 1;

    for(String n : order.getPizzaNames()){
      System.out.println(count++ + ". " + n + " Price: " + order.getPizzaPrice().get(count - 2));
    }
    System.out.println("Total price: " + order.priceTotal());
    System.out.println();
  }

  public void viewOrders(ArrayList<Order> orders){
    for(Order o : orders){
      String pickUpTime = o.getPickUpTime().toString();
      pickUpTime = pickUpTime.replaceAll("T", " ");

      System.out.println("--------------------------------------");
      System.out.println("Order number: " + o.getOrderNumber() + "\nCostumers name: " + o.getName() +
          "\nPrice: " + o.priceTotal() + "\nPick up time: " + pickUpTime + "\nOrder: " + o.getPizzaNames().toString().
          replaceAll("\\[", "").replaceAll("]", ""));
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

    return date;

  }

  public LocalTime time() {

    System.out.println("PLEASE CHOOSE A PICK UP TIME (hh:mm): ");

    String input = sc.nextLine();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    LocalTime time = LocalTime.parse(input, formatter);

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


  public void printReceipt(Order order) {

    String pickUpTime = order.toString();
    pickUpTime = pickUpTime.replaceAll("T", " ");

    System.out.println("----------------RECEIPT---------------");
    System.out.println("--------------------------------------");
    System.out.println("Customers name: " + order.getName());
    System.out.println("Pizzas: " + order.getPizzaNames());
    System.out.println("Pick uo time: " + order.getPickUpTime());
    System.out.println("Total price: " + order.priceTotal());
    System.out.println("--------------------------------------\n");


  }


  public void viewStatistics(){


  }


}
