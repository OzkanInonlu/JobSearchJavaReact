package hrms.jobSearch.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.jobSearch.entities.concretes.School;

public interface SchoolDao extends JpaRepository<School, Integer>{
	
	List<School> findAllByCandidateCv_IdOrderByGraduateDateAsc(int candidateCvId);
	List<School> findAllByCandidateCv_IdOrderByGraduateDateDesc(int candidateCvId);
	
	List<School> findAllByCandidateCv_Id(int candidateCvId);
	
	School findById(int id);



}
