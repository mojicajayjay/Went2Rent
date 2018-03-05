package went2rent.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import went2rent.beans.Reports;
import went2rent.beans.Users;

public class ReportService {

	public static final String TABLE = "car_reports";
	public static final String COL_ID = "report_id";
	public static final String COL_CAR_ID = "car_id";
	public static final String COL_USER_ID = "user_id";
	public static final String COL_DATE = "date_report";
	public static final String COL_REPORT = "report";
	
	public static List<Reports> getAllReports(){
		List<Reports> r = new ArrayList<Reports>();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqldb");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction trans = em.getTransaction();
		
		try {
			trans.begin();
			TypedQuery<Reports> q = em.createQuery("FROM "+TABLE, Reports.class);
			
			r = q.getResultList();
			
			trans.commit();
		}catch(Exception e) {
			if(trans == null)
				trans.rollback();
			e.printStackTrace();
		}finally {
			em.close();
		}
		
		return r;
	}
	
	public static boolean addReport(Reports r) {
		boolean added = false;
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqldb");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction trans = em.getTransaction();
		
		try {
			trans.begin();
			em.persist(r);
			
			trans.commit();
			added = true;
		}catch(Exception e) {
			if(trans!=null)
				trans.rollback();
			e.printStackTrace();
		}finally {
			em.close();
		}
		
		return added;
	}
	
	public static List<Reports> getReportbyCar(int id) {
		List<Reports> car_reports = new ArrayList<Reports>();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqldb");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction trans = em.getTransaction();
		
		try {
			trans.begin();
			
			TypedQuery<Reports> q = em.createQuery("FROM "+TABLE+ " WHERE "+COL_CAR_ID+" = "+id, Reports.class);
			
			car_reports = q.getResultList();
			trans.commit();
		}catch(Exception e) {
			if(trans==null)
				trans.rollback();
			e.printStackTrace();
		}finally {
			em.close();
		}
		
		return car_reports;
	}
	
	public static List<Reports> getReportbyUser(int id) {
		List<Reports> car_reports = new ArrayList<Reports>();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqldb");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction trans = em.getTransaction();
		
		try {
			trans.begin();
			
			TypedQuery<Reports> q = em.createQuery("FROM "+TABLE+ " WHERE "+COL_USER_ID+" = "+id, Reports.class);
			
			car_reports = q.getResultList();
			trans.commit();
		}catch(Exception e) {
			if(trans==null)
				trans.rollback();
			e.printStackTrace();
		}finally {
			em.close();
		}
		
		return car_reports;
	}
	
}
