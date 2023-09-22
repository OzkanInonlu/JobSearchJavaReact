package hrms.jobSearch.core.verification.concretes;

import org.springframework.stereotype.Service;

import hrms.jobSearch.core.utilities.results.Result;
import hrms.jobSearch.core.utilities.results.SuccessResult;
import hrms.jobSearch.core.verification.abstracts.EmployeeVerificationService;

@Service
public class EmployeeVerificationManager implements EmployeeVerificationService{

	@Override
	public Result verifyAccount() {
		return new SuccessResult("Account is verified by HRMS.");
	}

}
