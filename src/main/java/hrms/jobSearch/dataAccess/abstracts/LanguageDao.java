package hrms.jobSearch.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.jobSearch.entities.concretes.Language;

public interface LanguageDao extends JpaRepository<Language, Integer> {
	
	List<Language> findAllByCandidateCv_Id(int candidateCvId);


}
