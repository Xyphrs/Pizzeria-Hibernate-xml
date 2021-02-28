package com.company.Managers;

import com.company.FileAccessor;
import com.company.Tablas.Ingredient;
import com.company.Tablas.Ingredient;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;

public class ManageIngredient {

	public static SessionFactory factory;

	public static void start() throws IOException, ParseException {
		try {
			factory = ManageCustomer.factory;
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}

		ManageIngredient MA = new ManageIngredient();
		FileAccessor fa;
		fa = new FileAccessor();
		fa.readIngredientFile("src\\com\\company\\Inserts\\Ingredients.csv");
		System.out.println("\n Ingredient llegits des del fitxer");
		for (int i = 0; i < fa.listaIngredient.size(); i++) {

			System.out.println(fa.listaIngredient.get(i).toString());
			MA.addIngredient(fa.listaIngredient.get(i));

		}
		System.out.println("Ingredient llegits de la base de dades");
		MA.listIngredient();
		MA.deleteIngredient(10);
		MA.updateIngredient(2);
		System.out
				.println("Ingredient llegits de la base de dades després de des actualitzacions");
		MA.listIngredient();

	}

	/* Method to CREATE an Ingredient in the database */
	public void addIngredient(Ingredient Ingredient) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer IngredientID = null;
		try {
			tx = session.beginTransaction();

			IngredientID = (Integer) session.save(Ingredient);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	/* Method to READ all Ingredient */
	public void listIngredient() {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List Ingredient = session.createQuery("FROM Ingredient").list();

			for (Iterator iterator = Ingredient.iterator(); iterator.hasNext();) {
				Ingredient Ingredients = (Ingredient) iterator.next();
				System.out.println(Ingredients.toString());
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
	public void updateIngredient(Integer IngredientID) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Ingredient ingredient = session.get(Ingredient.class, IngredientID);
			ingredient.setName("Banana");
			session.update(ingredient);
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
	public void deleteIngredient(Integer IngredientID) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Ingredient ingredient = session.get(Ingredient.class, IngredientID);
			session.delete(ingredient);
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
