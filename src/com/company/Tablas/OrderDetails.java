package com.company.Tablas;

import java.io.Serializable;

public class OrderDetails  implements Serializable {

    private int orderId;
    private int pizzaId;
    private int quantity;
    private float priceEach;

    public OrderDetails() {
    }

    public OrderDetails(int orderId, int pizzaId, int quantity, float priceEach) {
        this.orderId = orderId;
        this.pizzaId = pizzaId;
        this.quantity = quantity;
        this.priceEach = priceEach;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(int pizzaId) {
        this.pizzaId = pizzaId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPriceEach() {
        return priceEach;
    }

    public void setPriceEach(float priceEach) {
        this.priceEach = priceEach;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "orderId=" + orderId +
                ", pizzaId=" + pizzaId +
                ", quantity=" + quantity +
                ", priceEach=" + priceEach +
                '}';
    }
}
