package com.company.Tablas;

import java.io.Serializable;

public class Pizza implements Serializable {
    private int idPizza;
    private String name;
    private float price;

    public Pizza() {
    }

    public Pizza(int idPizza, String name, float price) {
        this.idPizza = idPizza;
        this.name = name;
        this.price = price;
    }

    public int getIdPizza() {
        return idPizza;
    }

    public void setIdPizza(int idPizza) {
        this.idPizza = idPizza;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "idPizza=" + idPizza +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
