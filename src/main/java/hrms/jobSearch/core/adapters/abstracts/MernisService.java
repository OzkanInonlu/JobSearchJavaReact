package hrms.jobSearch.core.adapters.abstracts;

import hrms.jobSearch.entities.concretes.Candidate;

public interface MernisService {
	
	boolean checkPerson(Candidate candidate);
}
