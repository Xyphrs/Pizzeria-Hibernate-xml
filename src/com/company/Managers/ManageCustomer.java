package com.company.Managers;

import java.io.IOException;
import java.util.List;
import java.util.Date;
import java.util.Iterator;

import com.company.FileAccessor;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.company.Tablas.Customers;

public class ManageCustomer {

	public static SessionFactory factory;

	public static void start() throws IOException {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}

		ManageCustomer MA = new ManageCustomer();
		FileAccessor fa;
		fa = new FileAccessor();
		fa.readCustomersFile("src\\com\\company\\Inserts\\Customers.csv");
		System.out.println("\n Customer llegits des del fitxer");
		for (int i = 0; i < fa.listaCustomers.size(); i++) {

			System.out.println(fa.listaCustomers.get(i).toString());
			MA.addCustomer(fa.listaCustomers.get(i));

		}
		System.out.println("Customer llegits de la base de dades");
		MA.listCustomer();
		System.out
				.println("Customer llegits de la base de dades després de des actualitzacions");
		MA.listCustomer();

	}

	/* Method to CREATE an Customer in the database */
	public void addCustomer(Customers Customer) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer CustomerID = null;
		try {
			tx = session.beginTransaction();

			CustomerID = (Integer) session.save(Customer);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	/* Method to READ all Customer */
	public void listCustomer() {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List Customer = session.createQuery("FROM Customers").list();

			for (Iterator iterator = Customer.iterator(); iterator.hasNext();) {
				Customers Customers = (Customers) iterator.next();
				System.out.println(Customers.toString());
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
}
