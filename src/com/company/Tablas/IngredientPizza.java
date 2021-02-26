package com.company.Tablas;

import java.io.Serializable;

public class IngredientPizza implements Serializable {

    private int idPizza;
    private int idIngredient;

    public IngredientPizza() {
    }

    public IngredientPizza(int idPizza, int idIngredient) {
        this.idPizza = idPizza;
        this.idIngredient = idIngredient;
    }

    public int getIdPizza() {
        return idPizza;
    }

    public void setIdPizza(int idPizza) {
        this.idPizza = idPizza;
    }

    public int getIdIngredient() {
        return idIngredient;
    }

    public void setIdIngredient(int idIngredient) {
        this.idIngredient = idIngredient;
    }

    @Override
    public String toString() {
        return "IngredientPizza{" +
                "idPizza=" + idPizza +
                ", idIngredient=" + idIngredient +
                '}';
    }
}
