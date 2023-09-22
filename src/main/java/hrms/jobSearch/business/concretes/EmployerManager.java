package hrms.jobSearch.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.jobSearch.business.abstracts.EmployerService;
import hrms.jobSearch.business.validation.abstracts.ValidationRuleService;
import hrms.jobSearch.core.utilities.results.DataResult;
import hrms.jobSearch.core.utilities.results.ErrorResult;
import hrms.jobSearch.core.utilities.results.Result;
import hrms.jobSearch.core.utilities.results.SuccessDataResult;
import hrms.jobSearch.core.utilities.results.SuccessResult;
import hrms.jobSearch.core.verification.abstracts.EmailVerificationService;
import hrms.jobSearch.core.verification.abstracts.EmployeeVerificationService;
import hrms.jobSearch.dataAccess.abstracts.EmployerDao;
import hrms.jobSearch.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{
	private EmployerDao employerDao;
	private ValidationRuleService validationRuleService;
	private EmailVerificationService emailVerificationService;
	private EmployeeVerificationService employeeVerificationService;

	@Autowired
	public EmployerManager(EmployerDao employerDao, ValidationRuleService validationRuleService,
			EmailVerificationService emailVerificationService, EmployeeVerificationService employeeVerificationService) {
		super();
		this.employerDao = employerDao;
		this.validationRuleService = validationRuleService;
		this.emailVerificationService = emailVerificationService;
		this.employeeVerificationService = employeeVerificationService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Employers listed");

	}


	@Override
	public Result add(Employer employer) {
		
		Result validationResult = this.validationRuleService.checkEmployer(employer);
		if (!validationResult.isSuccess())
			return new ErrorResult(validationResult.getMessage());

		boolean emailValidationResult = checkEmail(employer);
		if (emailValidationResult)
			return new ErrorResult("E-mail already exists.");

		System.out.println(this.emailVerificationService.verifyEmail(employer.getEmail()).getMessage() + "\n" + this.employeeVerificationService.verifyAccount().getMessage());
		this.employerDao.save(employer);
		return new SuccessResult("The employer is added successfully.");
	}
	
	public boolean checkEmail(Employer employer) {

		Employer findByEmailResult = this.employerDao.findByEmail(employer.getEmail());
		if (findByEmailResult == null)
			return false;
		return true;
	}

	@Override
	public DataResult<List<Employer>> findByCompanyNameContains(String name) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Employer>>(this.employerDao.findByCompanyNameContains(name), "Data Listed");
	}

}











