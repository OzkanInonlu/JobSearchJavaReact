package hrms.jobSearch.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.jobSearch.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer>{
	
	Candidate findByEmailOrIdentityNumber(String email, String identityNumber);
	
	Candidate findById(int id);


}
