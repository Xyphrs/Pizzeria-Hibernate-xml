package com.company.Managers;

import com.company.FileAccessor;
import com.company.Tablas.OrderDetails;
import com.company.Tablas.OrderDetails;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;

public class ManageOrderDetails {

	public static SessionFactory factory;

	public static void start() throws IOException, ParseException {
		try {
			factory = ManageCustomer.factory;
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}

		ManageOrderDetails MA = new ManageOrderDetails();
		FileAccessor fa;
		fa = new FileAccessor();
		fa.readOrderDetailsFile("src\\com\\company\\Inserts\\OrderDetails.csv");
		System.out.println("\n OrderDetail llegits des del fitxer");
		for (int i = 0; i < fa.listaOrdersDetails.size(); i++) {

			System.out.println(fa.listaOrdersDetails.get(i).toString());
			MA.addOrderDetail(fa.listaOrdersDetails.get(i));

		}
		System.out.println("OrderDetail llegits de la base de dades");
		MA.listOrderDetail();
		MA.deleteOrderDetails(3);
		MA.updateOrderDetails(2);
		System.out
				.println("OrderDetail llegits de la base de dades després de des actualitzacions");
		MA.listOrderDetail();

	}

	/* Method to CREATE an OrderDetail in the database */
	public void addOrderDetail(OrderDetails OrderDetail) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer OrderDetailID = null;
		try {
			tx = session.beginTransaction();

			OrderDetailID = (Integer) session.save(OrderDetail);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	/* Method to READ all OrderDetail */
	public void listOrderDetail() {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List OrderDetail = session.createQuery("FROM OrderDetails").list();

			for (Iterator iterator = OrderDetail.iterator(); iterator.hasNext();) {
				OrderDetails OrderDetails = (OrderDetails) iterator.next();
				System.out.println(OrderDetails.toString());
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
	public void updateOrderDetails(Integer OrderDetailsID) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			OrderDetails orderDetails = session.get(OrderDetails.class, OrderDetailsID);
			orderDetails.setQuantity(5);
			session.update(orderDetails);
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
	public void deleteOrderDetails(Integer OrderDetailsID) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			OrderDetails orderDetails = session.get(OrderDetails.class, OrderDetailsID);
			session.delete(orderDetails);
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
