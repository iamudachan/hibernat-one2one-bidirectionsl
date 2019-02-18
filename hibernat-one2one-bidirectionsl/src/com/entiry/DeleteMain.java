package com.entiry;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteMain {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetails.class).buildSessionFactory();

		Session s = sf.getCurrentSession();
		try {
			int id = 1;
			s.beginTransaction();
			Instructor instructor = s.get(Instructor.class, id);
			if (null != instructor){
				System.out.println(instructor);
				s.delete(instructor);
			}
			s.getTransaction().commit();
		} finally {
			sf.close();
		}

	}

}
