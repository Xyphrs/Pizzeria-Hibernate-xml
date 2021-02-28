package com.company.Managers;

import com.company.FileAccessor;
import com.company.Tablas.IngredientPizza;
import com.company.Tablas.IngredientPizza;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;

public class ManageIngredientPizza {

	public static SessionFactory factory;

	public static void start() throws IOException, ParseException {
		try {
			factory = ManageCustomer.factory;
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}

		ManageIngredientPizza MA = new ManageIngredientPizza();
		FileAccessor fa;
		fa = new FileAccessor();
		fa.readIngredientPizzaFile("src\\com\\company\\Inserts\\IngredientPizza.csv");
		System.out.println("\n IngredientPizza llegits des del fitxer");
		for (int i = 0; i < fa.listaIngredientPizza.size(); i++) {

			System.out.println(fa.listaIngredientPizza.get(i).toString());
			MA.addIngredientPizza(fa.listaIngredientPizza.get(i));

		}
		System.out.println("IngredientPizza llegits de la base de dades");
		MA.listIngredientPizza();
		MA.deleteIngredientPizza(7);
		MA.updateIngredientPizza(2);
		System.out
				.println("IngredientPizza llegits de la base de dades després de des actualitzacions");
		MA.listIngredientPizza();

	}

	/* Method to CREATE an IngredientPizza in the database */
	public void addIngredientPizza(IngredientPizza IngredientPizza) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer IngredientPizzaID = null;
		try {
			tx = session.beginTransaction();

			IngredientPizzaID = (Integer) session.save(IngredientPizza);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	/* Method to READ all IngredientPizza */
	public void listIngredientPizza() {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List IngredientPizza = session.createQuery("FROM IngredientPizza").list();

			for (Iterator iterator = IngredientPizza.iterator(); iterator.hasNext();) {
				IngredientPizza IngredientPizzas = (IngredientPizza) iterator.next();
				System.out.println(IngredientPizzas.toString());
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
	public void updateIngredientPizza(Integer IngredientPizzaID) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			IngredientPizza ingredientPizza = session.get(IngredientPizza.class, IngredientPizzaID);
			ingredientPizza.setIdPizza(3);
			session.update(ingredientPizza);
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
	public void deleteIngredientPizza(Integer IngredientPizzaID) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			IngredientPizza ingredientPizza = session.get(IngredientPizza.class, IngredientPizzaID);
			session.delete(ingredientPizza);
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
