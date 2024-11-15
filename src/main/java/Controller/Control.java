package Controller;

import java.util.List;
import java.util.Map;
import java.util.Set;
import Entity.Candidate;
import Service.Service;

public class Control {

	Service sevice = null;
	public List<Candidate> getCandidates() {
		return new Service().getCandidates();
	}
	public int insertCandidate() {
		return new Service().insertCandidate();
	}
	
	public Map<String,List<Candidate>> getCandidateByAssembly(){
		return new Service().getCandidateByAssembly();
	}
	public int updateCandidate(int cid) {
		return new Service().updateCandidate(cid);
	}
	public List<Candidate> getCandidateByParty(String pname){
		return new Service().getCandidateByPname(pname);
	}
	public Set<String>getAssemblyList()
	{
		return new Service().getAssemblyList();
	}
}