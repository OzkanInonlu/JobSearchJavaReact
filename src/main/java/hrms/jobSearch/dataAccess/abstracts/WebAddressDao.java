package hrms.jobSearch.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.jobSearch.entities.concretes.WebAddress;

public interface WebAddressDao extends JpaRepository<WebAddress, Integer>{
	
	List<WebAddress> findAllByCandidateCv_Id(int candidateCvId);


}
