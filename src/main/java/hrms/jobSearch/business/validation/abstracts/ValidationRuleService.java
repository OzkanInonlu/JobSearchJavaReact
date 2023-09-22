package hrms.jobSearch.business.validation.abstracts;

import hrms.jobSearch.core.utilities.results.Result;
import hrms.jobSearch.entities.concretes.Candidate;
import hrms.jobSearch.entities.concretes.City;
import hrms.jobSearch.entities.concretes.Employer;
import hrms.jobSearch.entities.concretes.JobAdvertisement;

public interface ValidationRuleService {
	
	Result checkCandidate(Candidate candidate);

	Result checkEmployer(Employer employer);

	Result checkCity(City city);

	Result checkJobAdvertisement(JobAdvertisement jobAdvertisement);

}
