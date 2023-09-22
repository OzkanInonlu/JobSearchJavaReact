package hrms.jobSearch.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.jobSearch.business.abstracts.JobExperienceService;
import hrms.jobSearch.core.utilities.results.DataResult;
import hrms.jobSearch.core.utilities.results.Result;
import hrms.jobSearch.core.utilities.results.SuccessDataResult;
import hrms.jobSearch.core.utilities.results.SuccessResult;
import hrms.jobSearch.dataAccess.abstracts.JobExperienceDao;
import hrms.jobSearch.entities.concretes.JobExperience;

@Service
public class JobExperienceManager implements JobExperienceService{

	private JobExperienceDao jobExperienceDao;

	@Autowired
	public JobExperienceManager(JobExperienceDao jobExperienceDao) {
		super();
		this.jobExperienceDao = jobExperienceDao;
	}

	@Override
	public DataResult<List<JobExperience>> getAll() {
		
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAll(), "Data Listed");
	}

	@Override
	public Result add(JobExperience jobExperience) {
		this.jobExperienceDao.save(jobExperience);
		return new SuccessResult("Job experince added");
	}

	@Override
	public DataResult<List<JobExperience>> findAllByCandidateCv_IdOrderByEndDateAsc(int candidateCvId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobExperience>>
		(this.jobExperienceDao.findAllByCandidateCv_IdOrderByEndDateAsc(candidateCvId), "Data Listed ascending");
	}

	@Override
	public DataResult<List<JobExperience>> findAllByCandidateCv_IdOrderByEndDateDesc(int candidateCvId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobExperience>>
		(this.jobExperienceDao.findAllByCandidateCv_IdOrderByEndDateDesc(candidateCvId), "Data Listed descending");
	}

	@Override
	public DataResult<List<JobExperience>> findAllByCandidateCv_Id(int candidateCvId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobExperience>>
		(this.jobExperienceDao.findAllByCandidateCv_Id(candidateCvId), "Data Listelendi");
	}

}
