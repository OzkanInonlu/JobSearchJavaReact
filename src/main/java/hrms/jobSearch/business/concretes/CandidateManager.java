package hrms.jobSearch.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.jobSearch.business.abstracts.CandidateService;
import hrms.jobSearch.business.validation.abstracts.ValidationRuleService;
import hrms.jobSearch.core.adapters.abstracts.MernisService;
import hrms.jobSearch.core.utilities.results.DataResult;
import hrms.jobSearch.core.utilities.results.ErrorResult;
import hrms.jobSearch.core.utilities.results.Result;
import hrms.jobSearch.core.utilities.results.SuccessDataResult;
import hrms.jobSearch.dataAccess.abstracts.CandidateDao;
import hrms.jobSearch.entities.concretes.Candidate;
import hrms.jobSearch.core.utilities.results.SuccessResult;
import hrms.jobSearch.core.verification.abstracts.EmailVerificationService;

@Service
public class CandidateManager implements CandidateService {
	
	private CandidateDao candidateDao;
	private MernisService mernisService;
	private ValidationRuleService validationRuleService;
	private EmailVerificationService emailVerificationService;

	@Autowired
	public CandidateManager(CandidateDao candidateDao, MernisService mernisService,
			ValidationRuleService validationRuleService, EmailVerificationService emailVerificationService) {
		super();
		this.candidateDao = candidateDao;
		this.mernisService = mernisService;
		this.validationRuleService = validationRuleService;
		this.emailVerificationService  = emailVerificationService;
	}


	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Candidates listed");

	}

	@Override
	public Result add(Candidate candidate) {
		Result validationResult = validationRuleService.checkCandidate(candidate);
		if (!validationResult.isSuccess()) {
			return new ErrorResult(validationResult.getMessage());
		}

		//use mernis
		/*
		boolean mernisValidationResult = mernisService.checkPerson(candidate);
		if (!mernisValidationResult) {
			return new ErrorResult("You provided an invalid identity number. Please check the given info.");
		}
		*/

		//check email and id if they exist before
		boolean emailAndIdValidationResult = checkEmailAndId(candidate);
		if (emailAndIdValidationResult)
			return new ErrorResult("E-mail or identity number already exists.");

		//verify email
		System.out.println(this.emailVerificationService.verifyEmail(candidate.getEmail()).getMessage());
		this.candidateDao.save(candidate);
		return new SuccessResult("The candidate is added successfully.");
	}
	
	public boolean checkEmailAndId(Candidate candidate) {

		Candidate findByEmailOrIdentitynumberResult = this.candidateDao.findByEmailOrIdentityNumber(candidate.getEmail(), candidate.getIdentityNumber());
		if (findByEmailOrIdentitynumberResult == null)
			return false;
		return true;
	}

}
