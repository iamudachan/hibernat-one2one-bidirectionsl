package com.entiry;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstrutctoDetailsMain {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetails.class).buildSessionFactory();

		Session s = sf.getCurrentSession();
		try {
			s.beginTransaction();
			InstructorDetails instructorDetails = s.get(InstructorDetails.class, 222);
			System.out.println("instructorDetails  heloo" + instructorDetails);
			System.out.println(instructorDetails.getInstructor());
			s.getTransaction().commit();
		}catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			s.close();
			sf.close();
		}

	}

}
