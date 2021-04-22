package ui;

import carte.Carte;
import carte.Pizza;
import orders.Order;

import java.io.*;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class FileHandling {

  //Order order = new Order();


  public void savePizzaToFile(String fileName, ArrayList<Pizza> list) {
    File file = new File(fileName);

    try {
      FileWriter fileWriter = new FileWriter(file);
      Writer writer = new BufferedWriter(fileWriter);

      for (Pizza p : list) {
        writer.write(p.getName() + "\n");
        writer.write(p.getToppings().toString() + "\n"); //Remove []
        writer.write(p.getPrice() + "\n");
      }

      writer.close();

    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  public ArrayList<Pizza> loadPizzaFromFile(String fileName) {
    File file = new File(fileName);
    ArrayList<Pizza> pizzaList = new ArrayList<>();

    try {
      Scanner fileReader = new Scanner(file);

      boolean newFileCreated = file.createNewFile();
      if (newFileCreated) {
        System.out.println("File do not exist");
        System.out.println("Creating file..");
        Thread.sleep(2000);
        System.out.println("File created");
      }

      if (fileReader.hasNextLine()) {
        while (fileReader.hasNextLine()) {

          String temp;
          String name;
          ArrayList<String> topping1 = new ArrayList<>();
          double price;
          temp = fileReader.nextLine();

          if (!temp.isEmpty()) {
            name = temp;

            temp = fileReader.nextLine();
            String[] toppingArray = temp.split(", ");
            Collections.addAll(topping1, toppingArray);

            temp = fileReader.nextLine();
            price = Double.parseDouble(temp);

            pizzaList.add(new Pizza(name, topping1, price));

          }


        }
      }

      fileReader.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return pizzaList;
  }


  public void saveOrdersToFile(String fileName, Order order, ArrayList<Order> orders) {

    //private final String fileNameOrders = "PizzaInOrder.txt";

    File fileOrders = new File(fileName);
    try {
      FileWriter fileWriterOrders = new FileWriter(fileOrders);
      Writer writerOrders = new BufferedWriter(fileWriterOrders); //Remove []


      for (int i = 0; i <= orders.size(); i++) {

        writerOrders.write(order.getOrderNumber() + "\n");
        writerOrders.write(order.getName() + "\n");
        writerOrders.write(order.getPizzaList().toString().replaceAll("\\[", "").
            replaceAll("]", "") + "\n");
        writerOrders.write(order.getPickUpTime() + "\n");


/*
        writerOrders.write(orders.get(i).getOrderNumber() + "\n");
        writerOrders.write(orders.get(i).getName() + "\n");
        writerOrders.write(orders.get(i).getPizzaList().toString().replaceAll("\\[", "").
            replaceAll("]", "") + "\n");
        writerOrders.write(orders.get(i).getPickUpTime() + "\n");

 */

      }

      writerOrders.close();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}

//  public ArrayList<Order> loadOrdersFromFile() {
//
//    File fileOrders = new File(fileNameOrders);
//    ArrayList<Order> orderTemp = new ArrayList<>();
//
//    try {
//      Scanner fileReaderOrders = new Scanner(fileOrders);
//      boolean newFileCreated = fileOrders.createNewFile();
//
//      if (newFileCreated) {
//        System.out.println("File do not exist");
//        System.out.println("Creating file..");
//        Thread.sleep(2000);
//        System.out.println("File created");
//      }
//
//      if (fileReaderOrders.hasNextLine()) {
//        while (fileReaderOrders.hasNextLine()) {
//
//          String temp;
//          String orderName;
//          ArrayList<String> pizzaTemp = new ArrayList<>();
//          String dateTimeOrder;
//
//          ArrayList<String> pizzaInOneOrder = new ArrayList<>();
//
//          temp = fileReaderOrders.nextLine();
//
//          if (!temp.isEmpty()) {
//            orderName = temp;
//
//            temp = fileReaderOrders.nextLine();
//            String[] pizzaArray = temp.split(", ");
//            Collections.addAll(pizzaTemp, pizzaArray);
//
//            temp = fileReaderOrders.nextLine();
//            temp = dateTimeOrder;
//
//            dateTimeOrder = "2018-07-14T17:45:55.9483536";
//            DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
//            LocalDateTime dateTime = LocalDateTime.parse(dateTimeOrder, formatter);
//
//
//            orderTemp.add(new Order(orderName, pizzaInOneOrder, dateTime));
//
//
//          }
//        }
//      }
//      fileReaderOrders.close();
//
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//
//    return orderTemp;
//    }
//  }


