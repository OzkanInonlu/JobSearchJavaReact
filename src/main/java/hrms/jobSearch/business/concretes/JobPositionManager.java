package hrms.jobSearch.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.jobSearch.business.abstracts.JobPositionService;
import hrms.jobSearch.core.utilities.results.DataResult;
import hrms.jobSearch.core.utilities.results.ErrorResult;
import hrms.jobSearch.core.utilities.results.Result;
import hrms.jobSearch.core.utilities.results.SuccessDataResult;
import hrms.jobSearch.core.utilities.results.SuccessResult;
import hrms.jobSearch.dataAccess.abstracts.JobPositionDao;
import hrms.jobSearch.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{
	
	private JobPositionDao jobPositionDao;

	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(), "Job positions listed");
	}

	@Override
	public Result add(JobPosition jobPosition) {
		if(jobPositionDao.findByTitle(jobPosition.getTitle()) != null) {
			return new ErrorResult("Job position exists in the database.");
		}
		jobPositionDao.save(jobPosition);
		return new SuccessResult("Job position has added successfully");
	}

	@Override
	public List<JobPosition> getByTitleContains(String title) {
		// TODO Auto-generated method stub
		return this.jobPositionDao.getByTitleContains(title);
	}

}
