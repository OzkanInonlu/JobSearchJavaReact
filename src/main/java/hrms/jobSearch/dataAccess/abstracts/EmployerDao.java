package hrms.jobSearch.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.jobSearch.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer>{
	
	Employer findByEmail(String email);
	
	List<Employer> findByCompanyNameContains(String name);
}
