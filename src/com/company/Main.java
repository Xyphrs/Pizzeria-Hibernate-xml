package com.company;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
            FileAccessor fa = new FileAccessor();

            fa.readCustomersFile("src\\com\\company\\Inserts\\Customers.csv");
            fa.printCustomers();

            fa.readPizzaFile("src\\com\\company\\Inserts\\Pizzas.csv");
            fa.printPizza();

            fa.readIngredientFile("src\\com\\company\\Inserts\\Ingredients.csv");
            fa.printIngredient();

            fa.readOrdersFile("src\\com\\company\\Inserts\\Orders.csv");
            fa.printOrders();

            fa.readOrderDetailsFile("src\\com\\company\\Inserts\\OrderDetails.csv");
            fa.printOrderDetails();

            fa.readIngredientPizzaFile("src\\com\\company\\Inserts\\IngredientPizza.csv");
            fa.printIngredientPizza();
        }
}


