package ui;

import carte.Pizza;
import orders.Order;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class FileHandling {


  //Methods
  public void savePizzaToFile(String fileName, ArrayList<Pizza> list) {
    File file = new File(fileName);

    try {
      FileWriter fileWriter = new FileWriter(file);
      Writer writer = new BufferedWriter(fileWriter);

      for (Pizza p : list) {
        writer.write(p.getName() + "\n");
        writer.write(p.getToppings().toString() + "\n");
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

    } catch (IOException e) {
      e.printStackTrace();
    }

    return pizzaList;
  }


  public void saveOrdersToFile(String fileName, ArrayList<Order> orders) {



    File fileOrders = new File(fileName);
    try {
      FileWriter fileWriterOrders = new FileWriter(fileOrders);
      Writer writerOrders = new BufferedWriter(fileWriterOrders); //Remove []


      for (int i = 0; i < orders.size(); i++) {

        writerOrders.write(orders.get(i).getOrderNumber() + "\n");
        writerOrders.write(orders.get(i).getName() + "\n");
        writerOrders.write(orders.get(i).getPizzaPrice().toString().replaceAll("\\[", "").
            replaceAll("]", "") + "\n");
        writerOrders.write(orders.get(i).getPizzaNames().toString().replaceAll("\\[", "").
            replaceAll("]", "") + "\n");
        writerOrders.write(orders.get(i).getPickUpTime() + "\n");


      }

      writerOrders.close();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }



  public ArrayList<Order> loadOrdersFromFile(String fileName) {

    File fileOrders = new File(fileName);
    ArrayList<Order> orderList = new ArrayList<>();

    try {
      Scanner fileReaderOrders = new Scanner(fileOrders);
      boolean newFileCreated = fileOrders.createNewFile();

      if (newFileCreated) {
        System.out.println("File do not exist");
        System.out.println("Creating file..");
        System.out.println("File created");
      }

      if (fileReaderOrders.hasNextLine()) {
        while (fileReaderOrders.hasNextLine()) {

          String temp;
          long orderNr;
          String orderName;
          ArrayList<Double> pizzaPrice = new ArrayList<>();
          ArrayList<String> pizzaInOrder = new ArrayList<>();
          temp = fileReaderOrders.nextLine();

          if (!temp.isEmpty()) {
            orderNr = Long.parseLong(temp);

            temp = fileReaderOrders.nextLine();
            orderName = temp;

            temp = fileReaderOrders.nextLine();
            String[] pizzaPriceArray = temp.split(", ");
            Double[] pizzaPriceDouble = new Double[pizzaPriceArray.length];
            for (int i = 0; i < pizzaPriceArray.length; i++) {
              pizzaPriceDouble[i] = Double.parseDouble(pizzaPriceArray[i]);
            }
            Collections.addAll(pizzaPrice, pizzaPriceDouble);

            temp = fileReaderOrders.nextLine();
            String[] pizzaArray = temp.split(", ");
            Collections.addAll(pizzaInOrder, pizzaArray);

            temp = fileReaderOrders.nextLine();
            LocalDateTime dateTime = LocalDateTime.parse(temp);


            orderList.add(new Order(orderNr, orderName, pizzaPrice, pizzaInOrder, dateTime));

          }
        }
      }
      fileReaderOrders.close();

    } catch (IOException e) {
      e.printStackTrace();
    }

    return orderList;
  }


}


