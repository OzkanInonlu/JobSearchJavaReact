package hrms.jobSearch.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import hrms.jobSearch.business.abstracts.JobAdvertisementService;
import hrms.jobSearch.business.validation.abstracts.ValidationRuleService;
import hrms.jobSearch.core.utilities.results.DataResult;
import hrms.jobSearch.core.utilities.results.ErrorResult;
import hrms.jobSearch.core.utilities.results.Result;
import hrms.jobSearch.core.utilities.results.SuccessDataResult;
import hrms.jobSearch.core.utilities.results.SuccessResult;
import hrms.jobSearch.dataAccess.abstracts.JobAdvertisementDao;
import hrms.jobSearch.entities.concretes.JobAdvertisement;
import hrms.jobSearch.entities.dtos.JobAdvertisementWithEmployerDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{
	
	private JobAdvertisementDao jobAdvertisementDao;
	private ValidationRuleService validationRuleService;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, ValidationRuleService validationRuleService) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.validationRuleService = validationRuleService;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(), "Data Listed");
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		// TODO Auto-generated method stub
		
		Result validationResult = validationRuleService.checkJobAdvertisement(jobAdvertisement);
		if(!validationResult.isSuccess()) {
			return new ErrorResult(validationResult.getMessage());
		}
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("The job advertisement is successfully added");
	}


//	//for sorting
//	@Override
//	public DataResult<List<JobAdvertisement>> getAllSortedByDate() {
//		// TODO Auto-generated method stub
//		
//		Sort sort = Sort.by(Sort.Direction.DESC, "startDate");
//		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(sort), "Data Listed");
//	}

	@Override
	public DataResult<List<JobAdvertisement>> getActiveJobAdvertisement() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.getByStatusTrue(), "Active job advertisements are successfully listed.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getActiveJobAdvertisementByDateDesc() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByStatusTrueOrderByStartDateDesc(),
				"Active job advertisements are successfully listed by date descending order.");
	}
	
	@Override
	public DataResult<List<JobAdvertisement>> getActiveJobAdvertisementByDateAsc() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByStatusTrueOrderByStartDateAsc(),
				"Active job advertisements are successfully listed by date ascending order.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getActiveJobAdvertisementByCompany(String companyName) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByStatusTrueAndEmployer_CompanyName(companyName),
				"Job advertisements are listed by the desired company.");
	}

	//updating status to false
	@Override
	public Result updateJobAdvertisementStatus(int jobAdvertisementId, boolean selectedStatus) {
		// TODO Auto-generated method stub
		this.jobAdvertisementDao.updateJobAdvertisementStatus(jobAdvertisementId, selectedStatus);
		return new SuccessResult("Selected Job Advertisement is " + (selectedStatus? "opened." : "closed."));

	}

	@Override
	public DataResult<List<JobAdvertisement>> getByJobPosition_TitleContains(String jobName) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByJobPosition_TitleContains(jobName), "Data Listed");
	}

	@Override
	public DataResult<List<JobAdvertisementWithEmployerDto>> getJobAdvertisementWithEmployerDetails() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobAdvertisementWithEmployerDto>>
		(this.jobAdvertisementDao.getJobAdvertisementWithEmployerDetails(), "Data Listed");
	}

}
