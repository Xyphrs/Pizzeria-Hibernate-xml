package com.company.Managers;

import com.company.FileAccessor;
import com.company.Tablas.Customers;
import com.company.Tablas.Orders;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;

public class ManageOrders {

	public static SessionFactory factory;

	public static void start() throws IOException, ParseException {
		try {
			factory = ManageCustomer.factory;
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}

		ManageOrders MA = new ManageOrders();
		FileAccessor fa;
		fa = new FileAccessor();
		fa.readOrdersFile("src\\com\\company\\Inserts\\Orders.csv");
		System.out.println("\n Order llegits des del fitxer");
		for (int i = 0; i < fa.listaOrders.size(); i++) {

			System.out.println(fa.listaOrders.get(i).toString());
			MA.addOrder(fa.listaOrders.get(i));

		}
		System.out.println("Order llegits de la base de dades");
		MA.listOrder();
		MA.deleteOrders(12);
		MA.updateOrders(6);
		System.out
				.println("Order llegits de la base de dades després de des actualitzacions");
		MA.listOrder();

	}

	/* Method to CREATE an Order in the database */
	public void addOrder(Orders Order) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer OrderID = null;
		try {
			tx = session.beginTransaction();

			OrderID = (Integer) session.save(Order);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	/* Method to READ all Order */
	public void listOrder() {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List Order = session.createQuery("FROM Orders").list();

			for (Iterator iterator = Order.iterator(); iterator.hasNext();) {
				Orders Orders = (Orders) iterator.next();
				System.out.println(Orders.toString());
			}

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}


	/* Method to UPDATE activity for an autor */
	public void updateOrders(Integer OrderID) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Orders orders = session.get(Orders.class, OrderID);
			orders.setIdCustomer(1);
			session.update(orders);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/* Method to DELETE an employee from the records */
	public void deleteOrders(Integer OrderID) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Orders orders = session.get(Orders.class, OrderID);
			session.delete(orders);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
