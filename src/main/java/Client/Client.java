package Client;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import Controller.Control;
import Entity.Candidate;
import Utility.Utility;

public class Client {

	static Control control = new Control();
	static Scanner sc = new Scanner(System.in);

	public static void menu() {
		while (true) {
			System.out.println("---------------------------------------------\nWelcome TO ECI Project :"
					+ "\n*********************************************\n"
					+ "\n1) Show All Candidates \n2) Add Candidates \n3) Update \n4) Show Candidate By Party \n5) Show All Assembly \n6) Exit");
			System.out.print("---------------------------------------------\n");
			System.out.print("Enter your Choice : ");
			try {
				int n = sc.nextInt();
				System.out.print("---------------------------------------------\n");
				sc.nextLine();
				switch (n) {
				case 1:
					List<Candidate> candidates = control.getCandidates();
					for (Candidate c1 : candidates) {
						System.out.printf("%-20s|    %-15s |    %-15s\n", c1.getName(), c1.getParty_name(),
								c1.getAssembly());
					}
					break;
				case 2:
					if (control.insertCandidate() > 0) {
						System.out.println("\nCandidates Added Successfully...");
					}
					break;
				case 3:
					System.out.print("Update : ");
					System.out.print("\n\nEnter Candidate I'd : ");
					control.updateCandidate(sc.nextInt());
					break;
				case 4:
					System.out.println("Show Candidates : ");
					System.out.print("\nEnter Party Name : ");
					List<Candidate> db1 = control.getCandidateByParty(sc.nextLine());
					for (Candidate c1 : db1) {
						System.out.printf("%-20s|    %-15s |    %-15s\n", c1.getName(), c1.getParty_name(),
								c1.getAssembly());
					}
					break;
				case 5:
					System.out.println("All Assemblies : \n");
					Set<String> alist = control.getAssemblyList();
					for (String s : alist) {
						System.out.println(s);
					}
					break;
				case 6:
					System.out.println("Thank You !");
					System.exit(0);
				}
			} catch (InputMismatchException e) {
				System.out.println("---------------------------------------------\nEnter Valid Data....!");
				sc.nextLine();
				menu();
			}
		}
	}
	public static void main(String[] args) {
		menu();
	}
}
