package Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import Dao.Dao;
import Entity.Candidate;

public class Service {

	Dao dao = null;
	private Scanner sc = new Scanner(System.in);

	public int insertCandidate() {
		dao = new Dao();
		int check = 0;
		try {
			System.out.print("How Many Candidates Do You Want To Add : ");
			int n = sc.nextInt();
			sc.nextLine();
			System.out.print("---------------------------------------------\n");
			while(n>0){
				System.out.print("Enter candidate id : ");
				int cid = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter candidate name : ");
				String name = sc.nextLine();
				name = name.trim();
				System.out.print("Enter Age : ");
				int age = cid;
				sc.nextLine();
				System.out.print("Enter gender : ");
				String gender = sc.nextLine();
				gender = gender.trim();
				System.out.print("Enter State Name : ");
				String state = sc.nextLine();
				state = state.trim();
				System.out.print("Enter Party name : ");
				String pname = sc.nextLine();
				pname = pname.trim();
				System.out.print("Enter Assembly name : ");
				String as = sc.nextLine();
				as = as.trim();
				check = dao.insertCandidate(cid,name, age, pname, gender, state, as);
				n--;
			}	
		}catch(InputMismatchException e) {
			System.out.println("Enter Valid Data !");
			sc.nextLine();
			this.insertCandidate();
		}
		return check;
	}

	public List<Candidate> getCandidates() {
		return new Dao().getCandidates();
	}

	public Map<String, List<Candidate>> getCandidateByAssembly() {
		List<Candidate> l1 = this.getCandidates();
		Map<String, List<Candidate>> db = new HashMap<String, List<Candidate>>();
		for (Candidate c1 : l1) {
			String assemblyKey = c1.getAssembly();
			db.computeIfAbsent(assemblyKey, k -> new ArrayList<>()).add(c1);
		}
		return db;
	}
	
	public int updateCandidate(int cid) {
		dao = new Dao();
		int n = 0;
		try {
			System.out.print("Enter Candidate Name : ");
			String name = sc.nextLine();
			System.out.print("Enter Age : ");
			int age = sc.nextInt();
			sc.nextLine();
			System.out.print("Enter Gender : ");
			String gen = sc.nextLine();
			System.out.print("Enter State : ");
			String st = sc.nextLine();
			System.out.print("Enter Party Name : ");
			String pt = sc.nextLine();
			System.out.print("Enter Assembly Name : ");
			String as = sc.nextLine();
			n = dao.updateCandidate(cid, name, age, pt, gen, st, as);
		}catch(InputMismatchException e) {
			System.out.print("Please Enter Valid Data !");
			sc.nextLine();
			this.updateCandidate(cid);
		}
		
		return n;
	}

	public List<Candidate> getCandidateByPname(String pname) {
		pname = pname.toUpperCase();
		ArrayList<Candidate> l1 = new ArrayList<Candidate>();
		List<Candidate> candidates = this.getCandidates();
		for (Candidate c : candidates) {
			if (c.getParty_name().equals(pname)) {
				l1.add(c);
			}
		}
		return l1;
	}
	
	public Set<String> getAssemblyList()
	{ Set<String> l2 = new HashSet<String>();
	List<Candidate> can = this.getCandidates();
	for (Candidate c : can) {
		l2.add(c.getAssembly());
		
	}
		return l2;
	}
}
