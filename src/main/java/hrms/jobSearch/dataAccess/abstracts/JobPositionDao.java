package hrms.jobSearch.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.jobSearch.entities.concretes.JobPosition;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer>{
	
	JobPosition findByTitle(String title);
	
	List<JobPosition> getByTitleContains(String title);
	


}
