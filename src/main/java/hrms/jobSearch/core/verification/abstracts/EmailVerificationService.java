package hrms.jobSearch.core.verification.abstracts;

import hrms.jobSearch.core.utilities.results.Result;

public interface EmailVerificationService {
	Result verifyEmail(String email);

}
