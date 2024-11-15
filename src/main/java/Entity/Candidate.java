package Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "candidate1", schema = "election")
public class Candidate implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private int cid;
	private String name;
	private int age;
	@Column(name = "party")
	private String party_name;
	private String gender;
	private String state;
	private String assembly;
	
	public Candidate(int cid, String name, int age, String party_name, String gender, String state, String assembly) {
		super();
		this.cid = cid;
		this.name = name;
		this.age = age;
		this.party_name = party_name;
		this.gender = gender;
		this.state = state;
		this.assembly = assembly;
	}
	
	public Candidate(String name, int age, String party_name, String gender, String state, String assembly) {
		super();
		this.name = name;
		this.age = age;
		this.party_name = party_name;
		this.gender = gender;
		this.state = state;
		this.assembly = assembly;
	}

	public Candidate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getParty_name() {
		return party_name;
	}
	public void setParty_name(String party_name) {
		this.party_name = party_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getAssembly() {
		return assembly;
	}
	public void setAssembly(String assembly) {
		this.assembly = assembly;
	}
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	@Override
	public String toString() {
		return "Candidate [name=" + name + ", party_name=" + party_name + ", assembly=" + assembly + "]";
	}
	
	
}
