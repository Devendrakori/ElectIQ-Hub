package Utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import Entity.Candidate;

public class Utility {

	private static Configuration cfg = null;
	private static SessionFactory factory = null;

	private Utility() {
	}

	public static Session createSession() {

		cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Candidate.class);
		factory = cfg.buildSessionFactory();
		return factory.openSession();
	}

	public static void close() {

		if (factory != null) {
			factory.close();
		}
	}

}
