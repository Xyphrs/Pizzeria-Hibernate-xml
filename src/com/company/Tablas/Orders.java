package com.company.Tablas;

import java.io.Serializable;
import java.util.Date;

public class Orders implements Serializable {

    private int idOrder;
    private int idCustomer;
    private Date orderDate;

    public Orders()  {
    }

    public Orders(int idOrder, int idCustomer, Date orderDate) {
        this.idOrder = idOrder;
        this.idCustomer = idCustomer;
        this.orderDate = orderDate;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "idOrder=" + idOrder +
                ", idCustomer=" + idCustomer +
                ", orderDate=" + orderDate +
                '}';
    }
}
