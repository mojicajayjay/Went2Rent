package went2rent.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


import went2rent.beans.Car;
import went2rent.beans.Users;

public class CarService {
	public static final String TABLE = "car";
	public static final String COL_ID = "car_id";
	public static final String COL_CAR = "car_name";
	public static final String COL_PLATE = "car_platenumber";
	public static final String COL_COLOR = "car_color";
	
	public static List<Car> getAllCars(){
		List<Car> c = new ArrayList<Car>();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqldb");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction trans = em.getTransaction();
		
		try {
			trans.begin();
			TypedQuery<Car> car = em.createQuery("FROM car", Car.class);
			c = car.getResultList();
			
			trans.commit();
		}catch(Exception e) {
			if(trans==null)
				trans.rollback();
			e.printStackTrace();
		}finally {
			em.close();
		}
		
		return c;
	}
	
	public static Car getCar(int id) {
		Car c = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqldb");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction trans = em.getTransaction();
		
		try {
			trans.begin();
			
			c = em.find(Car.class, id);
			
			trans.commit();
		}catch(Exception e) {
			if(trans == null) 
				trans.rollback();
			e.printStackTrace();
		}finally {
			em.close();
		}
		
		return c;
	}
	
	public static boolean addCar(Car c) {
		boolean added = false;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqldb");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction trans = em.getTransaction();
		
		try {
			trans.begin();
			em.persist(c);
			
			trans.commit();
			added = true;
		}catch(Exception e) {
			if(trans == null)
				trans.rollback();
			e.printStackTrace();
		}finally {
			em.close();
		}
		
		return added;
	}
	
	public static boolean updateCar(int id, Car c) {
		boolean edited = false;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqldb");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction trans = em.getTransaction();
		
		try {
			trans.begin();
			Car car = em.find(Car.class, id);
			car.setCar_name(c.getCar_name());
			car.setCar_color(c.getCar_color());
			car.setCar_platenumber(c.getCar_platenumber());
			
			trans.commit();
			edited = true;
		}catch(Exception e) {
			if(trans == null)
				trans.rollback();
			e.printStackTrace();
		}finally {
			em.close();
		}
		
		return edited;
	}
	
	public static boolean deleteCar(int id) {
		boolean deleted = false;
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqldb");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction trans = em.getTransaction();
		
		try {
			trans.begin();
			
			Car c = em.find(Car.class, id);
			em.remove(c);
			trans.commit();
			deleted = true;
		}catch(Exception e) {
			if(trans==null) 
				trans.rollback();
			e.printStackTrace();
		}finally {
			em.close();
		}
		
		return deleted;
	}
	
	public static List<Car> getCarsByName(String car_name){
		List<Car> cars = new ArrayList<Car>();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction trans = em.getTransaction();
		
		try {
			trans.begin();
			String query = "FROM car WHERE " + COL_CAR + " = :car_name";
			TypedQuery<Car> c = em.createQuery(query, Car.class);
			c.setParameter("car_name", car_name);
			
			cars = c.getResultList();
			trans.commit();
		}catch(Exception e) {
			if(trans==null) 
				trans.rollback();
			e.printStackTrace();
		}finally {
			em.close();
		}
		
		return cars;
	}
	
	public static List<Car> getCarsByColor(String color){
		List<Car> cars = new ArrayList<Car>();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction trans = em.getTransaction();
		
		try {
			trans.begin();
			String query = "FROM car WHERE " + COL_COLOR + " = :car_color";
			TypedQuery<Car> c = em.createQuery(query, Car.class);
			c.setParameter("car_color", color);
			
			cars = c.getResultList();
			trans.commit();
		}catch(Exception e) {
			if(trans==null) 
				trans.rollback();
			e.printStackTrace();
		}finally {
			em.close();
		}
		
		return cars;

	}
}
