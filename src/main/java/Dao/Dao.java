package Dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Entity.Candidate;
import Utility.Utility;

public class Dao {

	public List<Candidate> getCandidates(){
		Session session = Utility.createSession();
		List<Candidate> l1 = session.createQuery("from Candidate",Candidate.class).list();
		Utility.close();
		session.close();
		return l1;
	}
	public int insertCandidate(int cid, String name, int age, String party_name, String gender, String state, String assembly){
		Session session = Utility.createSession();
		Transaction tx = session.beginTransaction();
		session.save(new Candidate(cid,name,age,party_name,gender,state,assembly));
		tx.commit();
		Utility.close();
		session.close();
		return 0;
	}
	
	public int updateCandidate(int cid,String name, int age, String party_name, String gender, String state, String assembly) {
		
		Session session = Utility.createSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(new Candidate(cid,name,age,party_name,gender,state,assembly));
		tx.commit();
		Utility.close();
		session.close();
		return 0;
	}
}
