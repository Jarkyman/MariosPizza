package ui;

import carte.Pizza;
import orders.Order;

import java.io.*;
import java.util.*;

public class FileHandling {

  private final String fileNameOrders = "Orders.txt";
  Order order = new Order();

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


  public void saveOrdersToFile(String fileNameOrders, ArrayList<Order> pizzaOrder) {
    File fileOrders = new File(fileNameOrders);

    try {
      FileWriter fileWriterOrders = new FileWriter(fileOrders);
      Writer writerOrders = new BufferedWriter(fileWriterOrders);

      for (Order order : pizzaOrder) {
        writerOrders.write(order.getPizzaOrder() + "\n");
        writerOrders.write(order.getDateOfOrder().toString() + "\n"); //Remove []
        writerOrders.write(order.getDateOfOrder() + "\n");
      }

      writerOrders.close();

    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  public ArrayList<Order> loadOrdersFromFile(String fileNameOrders) {
    File fileOrders = new File(fileNameOrders);
    ArrayList<Pizza> pizzaOrder = new ArrayList<>();

    try {
      Scanner fileReaderOrders = new Scanner(fileOrders);

      boolean newFileCreated = fileOrders.createNewFile();
      if (newFileCreated) {
        System.out.println("File do not exist");
        System.out.println("Creating file..");
        Thread.sleep(2000);
        System.out.println("File created");
      }

      if (fileReaderOrders.hasNextLine()) {
        while (fileReaderOrders.hasNextLine()) {

          String temp;
          String name;
          ArrayList<String> toppingOrders = new ArrayList<>();
          double price;
          temp = fileReaderOrders.nextLine();
          name = temp;

          temp = fileReaderOrders.nextLine();
          String[] toppingOrdersArray = temp.split(", ");
          Collections.addAll(toppingOrders, toppingOrdersArray);

          temp = fileReaderOrders.nextLine();
          price = Double.parseDouble(temp);

          pizzaOrder.add( new Pizza(name, toppingOrders, price));


        }
      }

      fileReaderOrders.close();

    }catch (Exception e) {
      e.printStackTrace();
    }

    return pizzaOrder;
  }
}
