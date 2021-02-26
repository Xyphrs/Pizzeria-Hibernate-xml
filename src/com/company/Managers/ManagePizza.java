package com.company.Managers;

import com.company.FileAccessor;
import com.company.Tablas.Pizza;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class ManagePizza {

	public static SessionFactory factory;

	public static void start() throws IOException {
		try {
			factory = ManageCustomer.factory;
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}

		ManagePizza MA = new ManagePizza();
		FileAccessor fa;
		fa = new FileAccessor();
		fa.readPizzaFile("src\\com\\company\\Inserts\\Pizzas.csv");
		System.out.println("\n Pizza llegits des del fitxer");
		for (int i = 0; i < fa.listaPizza.size(); i++) {

			System.out.println(fa.listaPizza.get(i).toString());
			MA.addPizza(fa.listaPizza.get(i));

		}
		System.out.println("Pizza llegits de la base de dades");
		MA.listPizza();
		System.out
				.println("Pizza llegits de la base de dades després de des actualitzacions");
		MA.listPizza();

	}

	/* Method to CREATE an Pizza in the database */
	public void addPizza(Pizza Pizza) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer PizzaID = null;
		try {
			tx = session.beginTransaction();

			PizzaID = (Integer) session.save(Pizza);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	/* Method to READ all Pizza */
	public void listPizza() {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List Pizza = session.createQuery("FROM Pizza").list();

			for (Iterator iterator = Pizza.iterator(); iterator.hasNext();) {
				Pizza Pizzas = (Pizza) iterator.next();
				System.out.println(Pizzas.toString());
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
