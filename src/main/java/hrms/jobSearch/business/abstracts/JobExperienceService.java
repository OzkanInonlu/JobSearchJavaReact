package hrms.jobSearch.business.abstracts;

import java.util.List;

import hrms.jobSearch.core.utilities.results.DataResult;
import hrms.jobSearch.core.utilities.results.Result;
import hrms.jobSearch.entities.concretes.JobExperience;

public interface JobExperienceService {
	
	
	DataResult<List<JobExperience>> getAll();
	Result add(JobExperience jobExperience);
	
	DataResult<List<JobExperience>> findAllByCandidateCv_IdOrderByEndDateAsc(int candidateCvId);
	DataResult<List<JobExperience>> findAllByCandidateCv_IdOrderByEndDateDesc(int candidateCvId);
	
	DataResult<List<JobExperience>> findAllByCandidateCv_Id(int candidateCvId);
	
	JobExperience findById(int id);

}
