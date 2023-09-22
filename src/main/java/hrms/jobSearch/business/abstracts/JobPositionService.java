package hrms.jobSearch.business.abstracts;

import java.util.List;

import hrms.jobSearch.core.utilities.results.DataResult;
import hrms.jobSearch.core.utilities.results.Result;
import hrms.jobSearch.entities.concretes.JobPosition;

public interface JobPositionService {
	
	DataResult<List<JobPosition>> getAll();
	
	Result add(JobPosition jobPosition);
	
	List<JobPosition> getByTitleContains(String title);


}
