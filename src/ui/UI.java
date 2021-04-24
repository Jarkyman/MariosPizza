package ui;

import carte.Pizza;
import orders.Order;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    int choice = 0;
    do {
      System.out.println(getOption());
      while (!sc.hasNextInt()) {
        System.out.println("NOT A VALID CHOICE");
        sc.next();
        System.out.println(getOption());
      }
      choice = sc.nextInt();
      sc.nextLine();

      if (choice <= 0 || choice > 30) {
        System.out.println("NOT A VALID CHOICE");
      }
    }
    while(choice <= 0 || choice > 30);

    return choice;
  }

  public long readOrderNumber(ArrayList<Order> orders) {
    long choice;

    do{
      System.out.println(getOption());
      while (!sc.hasNextLong()) {
        System.out.println("NOT A VALID INPUT");
        sc.next();
        System.out.println(getOption());
      }
      choice = sc.nextLong();
      sc.nextLine();
      if(!orderExists(orders, choice)){
        System.out.println("NOT A VALID INPUT");
      }
      for (Order o : orders) {
        if (choice == o.getOrderNumber()) {
          return choice;
        }
      }

    } while (!orderExists(orders, choice) && choice != 0);

    return choice;
  }

  private boolean orderExists(ArrayList<Order> orders, long choice){
    for (Order o : orders) {
      if (choice == o.getOrderNumber()) {
        return true;
      }
    }
    return false;
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
      System.out.printf("\033[4m%-3d %-20s %-90s %.2f DKK\033[0m\n", (i + 1), pizzaList.get(i).getName(), pizzaList.get(i).getToppings().toString()
          .replaceAll("\\[", "").replaceAll("]", ""), pizzaList.get(i).getPrice());
    }
  }

  public void viewOrder(Order order){
    String pickUpTime = order.getPickUpTime().toString();
    pickUpTime = pickUpTime.replaceAll("T", " ");

    System.out.println("PICK UP TIME: " + pickUpTime);
    System.out.println("CUSTOMER NAME: " + order.getName());
    System.out.println("PIZZA: ");
    int count = 1;

    for(String n : order.getPizzaNames()){
      System.out.println(count++ + ". " + n + " Price: " + order.getPizzaPrice().get(count - 2));
    }
    System.out.println("TOTAL PRICE: " + order.priceTotal());
    System.out.println();
  }

  public void viewOrders(ArrayList<Order> orders){
    for(Order o : orders){
      String pickUpTime = o.getPickUpTime().toString();
      pickUpTime = pickUpTime.replaceAll("T", " ");
      String pickupTimeText = pickUpTime;

      System.out.println("--------------------------------------");
      System.out.printf("%-15s %-15d\n%-15s %-15s\n%-15s %.2f DKK\n%-15s %-15s\n%-15s %-15s\n","Order number:", o.getOrderNumber(), "Costumer name:", o.getName(),"Price:", o.priceTotal(),"Pick up time",
          pickupTimeText, "Order:", o.getPizzaNames().toString().replaceAll("\\[", "").replaceAll("]", ""));
    }

    System.out.println("--------------------------------------\n");

  }

  public String name() {
    System.out.println("ENTER NAME OF COSTUMER: ");
    String name = sc.nextLine();

    return name;
  }


  public boolean validateDate(String input){

    try{
      SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");
      format.setLenient(false);
      format.parse(input);
      return true;

    }catch (Exception e){
      return false;
    }
  }

  public LocalDate date(){

    System.out.println("ENTER PICK UP DATE (dd-mm-yyyy): ");

    String input = sc.nextLine();

    while(!validateDate(input)) {
      System.out.println("NOT A VALID INPUT");
      input = sc.nextLine();
    }

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yyyy");
    LocalDate date = LocalDate.parse(input, formatter);

    return date;

  }


  public LocalTime time() {
    System.out.println("ENTER PICK UP TIME (hh:mm): ");
    String input = sc.nextLine();
    while (!(input.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]"))){
      System.out.println("ENTER PICK UP TIME (hh:mm): ");
      input = sc.nextLine();
    }
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    LocalTime time = LocalTime.parse(input, formatter);
    return time;
  }


  public void printReceipt(Order order) {

    String pickUpTime = order.getPickUpTime().toString();
    pickUpTime = pickUpTime.replaceAll("T", " ");

    System.out.println("---------------RECEIPT---------------");
    System.out.printf("%-20s %-15s\n%-20s %-15s\n%-20s %-15s\n%-20s %.2f DKK\n","Customers name:", order.getName(), "Pick uo time:", order.getPickUpTime(), "Pizzas: ",
        order.getPizzaNames(), "Total price:", order.priceTotal());
    System.out.println("-------------------------------------\n");


  }


  public void viewStatistics(){


  }


}
