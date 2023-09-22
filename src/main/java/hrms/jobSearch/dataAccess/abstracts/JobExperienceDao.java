package hrms.jobSearch.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.jobSearch.entities.concretes.JobExperience;

public interface JobExperienceDao extends JpaRepository<JobExperience, Integer>{
	
	List<JobExperience> findAllByCandidateCv_IdOrderByEndDateAsc(int candidateCvId);
	List<JobExperience> findAllByCandidateCv_IdOrderByEndDateDesc(int candidateCvId);
	
	List<JobExperience> findAllByCandidateCv_Id(int candidateCvId);
	
	JobExperience findById(int id);


}
