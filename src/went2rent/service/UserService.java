package went2rent.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import went2rent.beans.Users;

public class UserService 
{
	
/******************        USERS TABLE METHODS        ******************/	
	
	public static final String TABLE = "users";
	public static final String COL_USERNAME = "username";
	public static final String COL_PASSWORD = "password";
	public static final String COL_ID = "id";
	public static final String COL_EMAIL = "email";
	public static final String COL_FIRSTNAME = "firstname";
	public static final String COL_LASTNAME = "lastname";
	
	public static List<Users> getAllUsers() 
	{
		List<Users> users = new ArrayList<Users>();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqldb");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction trans = em.getTransaction();
		
		try {
			trans.begin();
			TypedQuery<Users> q = em.createQuery("FROM users", Users.class);
			users = q.getResultList();
			
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		
		return users;
	}
	
	public static boolean addUser(Users u) 
	{
		boolean added = false;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqldb");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction trans = em.getTransaction();
		
		try {
			trans.begin();
			em.persist(u);
			
			trans.commit();
			added = true;
		} catch(Exception e) {
			if(trans != null) {
				trans.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
		
		return added;
	}

	public static boolean updateUser(int id, Users newinfo)
	{
		boolean updated = false;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqldb");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction trans = em.getTransaction();
		
		try {
			trans.begin();
			
			Users u = em.find(Users.class, id);
			
			u.setUsername(newinfo.getUsername());
			u.setPassword(newinfo.getPassword());
			
			trans.commit();
			updated = true;
		} catch(Exception e) {
			if(trans != null) {
				trans.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
		
		return updated;
	}
	
	public static boolean deleteUser(int id)
	{
		boolean deleted = false;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqldb");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction trans = em.getTransaction();
		
		try {
			trans.begin();
			
			Users u = em.find(Users.class, id);
			
			em.remove(u);
			trans.commit();
			deleted = true;
		} catch(Exception e) {
			if(trans != null) {
				trans.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
		
		return deleted;
	}
	
	public static Users getUser(int id)
	{
		Users u = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqldb");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction trans = em.getTransaction();
		
		try {
			trans.begin();
			
			u = em.find(Users.class, id);
			
			trans.commit();
			
		} catch(Exception e) {
			if(trans != null) {
				trans.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
		
		return u;
	}
	

	public static Users findUser(String username, String password) {
		Users user = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqldb");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction trans = em.getTransaction();
		
		try {
			trans.begin();
			String query = "FROM users where " + COL_USERNAME + " = :username AND " + COL_PASSWORD + " = :password";
			TypedQuery<Users> q = em.createQuery(query, Users.class);
			q.setParameter("username", username);
			q.setParameter("password", password);
			List <Users> users = q.getResultList();
						
			System.out.println(users.get(0).getUsername());
			System.out.println(users.get(0).getPassword());
		
			if(users != null && users.size() != 0) {
				user = users.get(0);
			}
			trans.commit();
			
		} catch(Exception e) {
			if(trans != null) {
				trans.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}	
		
//		System.out.println(user.getUsername());
		
		return user;
	}
	
	public static Users getUserByName(String username)
	{
		Users u = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqldb");
		EntityManager em = emf.createEntityManager();
		EntityTransaction trans = em.getTransaction();
		
		try {
			trans.begin();
			String query = "FROM users where " + COL_USERNAME + " = :username";
			TypedQuery<Users> q = em.createQuery(query, Users.class);
			q.setParameter("username", username);
			List <Users> users = q.getResultList();
			
			if(users != null && users.size() != 0) {
				u = users.get(0);
			}
			trans.commit();
			
		} catch(Exception e) {
			if(trans != null) {
				trans.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
		System.out.println(u.getUsername());
		return u;
	}
	
	public static void main (String[] args) {
/*	
		Users u = new Users();
		u.setFirstname("jj");
		u.setLastname("ww");
		u.setUsername("jw");
		u.setPassword("wow");
		u.setEmail("lol@ph");
		
		UserService.addUser(u);
*/		
<<<<<<< HEAD
//		List<Users> users = getAllUsers();
/*		for(Users ul: users)
=======
		List<Users> users = getAllUsers();
		for(Users ul: users)
>>>>>>> e6bfa1e4c96307a60685b93b4af77c7e1881994f
		{
			System.out.println(ul.toString());
		}
		
		findUser("ronsarahan","123");
<<<<<<< HEAD
*/	
=======
>>>>>>> e6bfa1e4c96307a60685b93b4af77c7e1881994f
	}
}

