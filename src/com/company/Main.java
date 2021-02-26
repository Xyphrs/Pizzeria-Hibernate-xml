package com.company;

import com.company.Managers.*;

import java.io.IOException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        ManageCustomer.start();
        ManageOrders.start();
        ManagePizza.start();
        ManageIngredient.start();
        ManageOrderDetails.start();
        ManageIngredientPizza.start();
    }
}


