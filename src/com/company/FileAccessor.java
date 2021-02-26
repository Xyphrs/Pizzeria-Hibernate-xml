package com.company;

import com.company.Tablas.*;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.StringTokenizer;




public class FileAccessor {

    public ArrayList<Customers> listaCustomers = new ArrayList();
    public ArrayList<Pizza> listaPizza = new ArrayList();
    public ArrayList<Ingredient> listaIngredient = new ArrayList();
    public ArrayList<Orders> listaOrders = new ArrayList();
    public ArrayList<OrderDetails> listaOrdersDetails = new ArrayList();
    public ArrayList<IngredientPizza> listaIngredientPizza = new ArrayList();


    public FileAccessor() {
    }

    public void readCustomersFile(String filename) throws IOException {
        int idCustomer;
        String name, address, email, phone;

        BufferedReader br = new BufferedReader(new FileReader(filename));
        String linea = "";
        while ((linea = br.readLine()) != null) {
            StringTokenizer str = new StringTokenizer(linea, ",");
            idCustomer = Integer.parseInt(str.nextToken());
            name = str.nextToken();
            address = str.nextToken();
            email = str.nextToken();
            phone = str.nextToken();
            // System.out.println(id + name + country + year + active);

            listaCustomers.add(new Customers(idCustomer, name, address, email, phone));
        }
        br.close();
    }

    public void printCustomers() {
        for (int i = 0; i < listaCustomers.size(); i++) {
            System.out.println(listaCustomers.get(i).toString());
        }
    }

    public void readPizzaFile(String filename) throws IOException {
        int idPizza;
        String name;
        float price;

        BufferedReader br = new BufferedReader(new FileReader(filename));
        String linea = "";
        while ((linea = br.readLine()) != null) {
            StringTokenizer str = new StringTokenizer(linea, ",");
            idPizza = Integer.parseInt(str.nextToken());
            name = str.nextToken();
            price = Float.parseFloat(str.nextToken());

            // System.out.println(id + name + country + year + active);

            listaPizza.add(new Pizza(idPizza, name, price));
        }
        br.close();
    }

    public void printPizza() {
        for (int i = 0; i < listaPizza.size(); i++) {
            System.out.println(listaPizza.get(i).toString());
        }
    }

    public void readOrdersFile(String filename) throws IOException, ParseException {
        DateFormat dateformat = new SimpleDateFormat("MM-dd-yyyy");

        int idOrders, idCustomer;
        Date orderDate;

        BufferedReader br = new BufferedReader(new FileReader(filename));
        String linea = "";
        while ((linea = br.readLine()) != null) {
            StringTokenizer str = new StringTokenizer(linea, ",");
            idOrders = Integer.parseInt(str.nextToken());
            idCustomer = Integer.parseInt(str.nextToken());
            orderDate = dateformat.parse(str.nextToken());


            // System.out.println(id + name + country + year + active);

            listaOrders.add(new Orders(idOrders, idCustomer, orderDate));
        }
        br.close();
    }

    public void printOrders() {
        for (int i = 0; i < listaOrders.size(); i++) {
            System.out.println(listaOrders.get(i).toString());
        }
    }

    public void readIngredientFile(String filename) throws IOException {
        int idIngredient;
        String name;

        BufferedReader br = new BufferedReader(new FileReader(filename));
        String linea = "";
        while ((linea = br.readLine()) != null) {
            StringTokenizer str = new StringTokenizer(linea, ",");
            idIngredient = Integer.parseInt(str.nextToken());
            name = str.nextToken();


            // System.out.println(id + name + country + year + active);

            listaIngredient.add(new Ingredient(idIngredient, name));
        }
        br.close();
    }

    public void printIngredient() {
        for (int i = 0; i < listaIngredient.size(); i++) {
            System.out.println(listaIngredient.get(i).toString());
        }
    }


    public void readOrderDetailsFile(String filename) throws IOException {
        int orderId, pizzaId, quantity;
        float priceEach;

        BufferedReader br = new BufferedReader(new FileReader(filename));
        String linea = "";
        while ((linea = br.readLine()) != null) {
            StringTokenizer str = new StringTokenizer(linea, ",");
            orderId = Integer.parseInt(str.nextToken());
            pizzaId = Integer.parseInt(str.nextToken());
            quantity = Integer.parseInt(str.nextToken());
            priceEach = Float.parseFloat(str.nextToken());

            // System.out.println(id + name + country + year + active);

            listaOrdersDetails.add(new OrderDetails(orderId, pizzaId, quantity, priceEach));
        }
        br.close();
    }

    public void printOrderDetails() {
        for (OrderDetails listaOrdersDetail : listaOrdersDetails) {
            System.out.println(listaOrdersDetail.toString());
        }
    }

    public void readIngredientPizzaFile(String filename) throws IOException {
        int idPizza, idIngredient;


        BufferedReader br = new BufferedReader(new FileReader(filename));
        String linea = "";
        while ((linea = br.readLine()) != null) {
            StringTokenizer str = new StringTokenizer(linea, ",");
            idPizza = Integer.parseInt(str.nextToken());
            idIngredient = Integer.parseInt(str.nextToken());


            // System.out.println(id + name + country + year + active);

            listaIngredientPizza.add(new IngredientPizza(idPizza, idIngredient));
        }
        br.close();
    }

    public void printIngredientPizza() {
        for (int i = 0; i < listaIngredientPizza.size(); i++) {
            System.out.println(listaIngredientPizza.get(i).toString());
        }
    }


}