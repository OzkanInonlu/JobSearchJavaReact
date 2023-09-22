package hrms.jobSearch.core.verification.concretes;

import org.springframework.stereotype.Service;

import hrms.jobSearch.core.utilities.results.Result;
import hrms.jobSearch.core.utilities.results.SuccessResult;
import hrms.jobSearch.core.verification.abstracts.EmailVerificationService;

@Service
public class EmailVerificationManager implements EmailVerificationService{

	@Override
	public Result verifyEmail(String email) {
		// TODO Auto-generated method stub
		return new SuccessResult("Please verify your account. We sent the e-mail to your e-mail address: " + email);
	}

}
