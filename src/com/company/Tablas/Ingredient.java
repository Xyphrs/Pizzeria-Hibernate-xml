package com.company.Tablas;

import java.io.Serializable;

public class Ingredient implements Serializable {
    private int idIngredient;
    private String name;

    public Ingredient() {
    }

    public Ingredient(int idIngredient, String name) {
        this.idIngredient = idIngredient;
        this.name = name;
    }

    public int getIdIngredient() {
        return idIngredient;
    }

    public void setIdIngredient(int idIngredient) {
        this.idIngredient = idIngredient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "idIngredient=" + idIngredient +
                ", name='" + name + '\'' +
                '}';
    }
}
