package hrms.jobSearch.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import hrms.jobSearch.entities.concretes.JobAdvertisement;
import hrms.jobSearch.entities.dtos.JobAdvertisementWithEmployerDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{

	
	List<JobAdvertisement> getByStatusTrue();//only get the active ones
	
	List<JobAdvertisement> getByStatusTrueOrderByStartDateDesc(); //aktif iş ilanları tarihe göre listelenebilmelidir
	
	List<JobAdvertisement> getByStatusTrueOrderByStartDateAsc(); //aktif iş ilanları tarihe göre listelenebilmelidir

	List<JobAdvertisement> getByStatusTrueAndEmployer_CompanyName(String companyName);
	
	@Transactional
	@Modifying
	@Query("UPDATE JobAdvertisement j SET j.status = :selectedStatus WHERE j.id = :id")
	void updateJobAdvertisementStatus(int id, boolean selectedStatus);
	
	List<JobAdvertisement> getByJobPosition_TitleContains(String jobName);
	
	//dto ile daha kullanışlı bir sekilde veri cekebiliriz
	
//	//inner join
	@Query("SELECT NEW hrms.jobSearch.entities.dtos.JobAdvertisementWithEmployerDto(" +
		       "e.id, jad.id, e.companyName, jad.jobPosition.title, jad.description, jad.startDate, jad.endDate, "
		       + "jad.maxSalary, jad.minSalary, jad.freePositionAmount, jad.status) " +
		       "FROM Employer e " +
		       "INNER JOIN e.jobAdvertisements jad")
	List<JobAdvertisementWithEmployerDto> getJobAdvertisementWithEmployerDetails(); 


}
