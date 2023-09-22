package hrms.jobSearch.business.abstracts;

import java.util.List;

import hrms.jobSearch.core.utilities.results.DataResult;
import hrms.jobSearch.core.utilities.results.Result;
import hrms.jobSearch.entities.concretes.JobAdvertisement;
import hrms.jobSearch.entities.dtos.JobAdvertisementWithEmployerDto;

public interface JobAdvertisementService {
	
	DataResult<List<JobAdvertisement>> getAll();
	Result add(JobAdvertisement jobAdvertisement);
	
	//DataResult<List<JobAdvertisement>> getAllSortedByDate();
	
	DataResult<List<JobAdvertisement>> getActiveJobAdvertisement();
	DataResult<List<JobAdvertisement>> getActiveJobAdvertisementByDateDesc();
	DataResult<List<JobAdvertisement>> getActiveJobAdvertisementByDateAsc();
	DataResult<List<JobAdvertisement>> getActiveJobAdvertisementByCompany(String companyName);
	Result updateJobAdvertisementStatus(int jobAdvertisementId, boolean selectedStatus);
	
	DataResult<List<JobAdvertisement>> getByJobPosition_TitleContains(String jobName);
	
	DataResult<List<JobAdvertisementWithEmployerDto>> getJobAdvertisementWithEmployerDetails(); 

	

}
