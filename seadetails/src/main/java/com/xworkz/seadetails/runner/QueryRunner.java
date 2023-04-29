package com.xworkz.seadetails.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.xworkz.seadetails.entity.SeaEntity;

public class QueryRunner {
	public static void main(String[] args) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("com.xworkz");
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction= manager.getTransaction();
		Query query= manager.createNamedQuery("findByName");
		Object obj=query.getSingleResult();
		SeaEntity entity=(SeaEntity)obj;
		manager.close();
		System.out.println(entity);
	}

}
