package com;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class StoreData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		
		org.hibernate.Transaction t = session.beginTransaction();
		
		Employee e1 = new Employee();
		e1.setId(1);
		e1.setFirstName("Gauri");
		e1.setLastName("sharma");
		
		session.save(e1);
		t.commit();
		System.out.println("successfully saved");
		
		factory.close();
		session.close();
 	}

}
