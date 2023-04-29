package com.xworkz.seadetails.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.seadetails.entity.SeaEntity;

public class SeaRunner {

	public static void main(String[] args) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("com.xworkz");
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction= manager.getTransaction();
		SeaEntity entity = new SeaEntity("Sea ship","Bangalore","water",234.45);
		SeaEntity entity1 = new SeaEntity("managalore","mandya","water",456.45);
		SeaEntity entity2 = new SeaEntity("sea spot","mysore","water",567.45);
		SeaEntity entity3 = new SeaEntity("tank","srilanka","water",876.45);
		SeaEntity entity4 = new SeaEntity("ship","","water",678.45);
		SeaEntity entity5 = new SeaEntity("battle ship","Bangalore","water",987.45);
		transaction.begin();
		manager.persist(entity5);
		manager.close();
		System.out.println("this is end");
	}

}
