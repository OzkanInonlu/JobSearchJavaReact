package hrms.jobSearch.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.jobSearch.entities.concretes.CandidateImage;

public interface CandidateImageDao extends JpaRepository<CandidateImage, Integer>{
	
	CandidateImage findByCandidate_Id(int candidateId);

}
