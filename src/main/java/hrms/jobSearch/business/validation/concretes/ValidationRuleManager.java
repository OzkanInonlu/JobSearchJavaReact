package hrms.jobSearch.business.validation.concretes;

import java.time.Year;

import org.springframework.stereotype.Service;

import hrms.jobSearch.business.validation.abstracts.ValidationRuleService;
import hrms.jobSearch.core.utilities.results.ErrorResult;
import hrms.jobSearch.core.utilities.results.Result;
import hrms.jobSearch.core.utilities.results.SuccessResult;
import hrms.jobSearch.entities.concretes.Candidate;
import hrms.jobSearch.entities.concretes.City;
import hrms.jobSearch.entities.concretes.Employer;
import hrms.jobSearch.entities.concretes.JobAdvertisement;

@Service
public class ValidationRuleManager implements ValidationRuleService{

	@Override
	public Result checkCandidate(Candidate candidate) {

		Year currentYear = Year.now();

		if (candidate.getFirstName().isEmpty() || candidate.getLastName().isEmpty() || candidate.getIdentityNumber().isEmpty() || candidate.getEmail().isEmpty()
				|| candidate.getPassword().isEmpty()) {
			return new ErrorResult("Please fill the blanks completely.");
		}

		if (candidate.getBirthYear() <= 0 || candidate.getBirthYear() > currentYear.getValue()) {
			return new ErrorResult("Wrong birth of year.");
		}
		return new SuccessResult("Validation OK.");
	}

	@Override
	public Result checkEmployer(Employer employer) {

		if (employer.getCompanyName().isEmpty() || employer.getWebAddress().isEmpty() || employer.getEmail().isEmpty() || employer.getPhoneNumber().isEmpty()
				|| employer.getPassword().isEmpty()) {
			return new ErrorResult("Please fill the blanks completely.");
		}
			
		
		else {
			String[] parts = employer.getEmail().split("@");
			String domain = parts[1]; 
			
			if(!domain.equals(employer.getWebAddress())) {
				return new ErrorResult("Your email must contain the domain in it.");
			}
			return new SuccessResult("Validation OK.");
		}
			
		/*	
		else if (!employer.getEmail().contains(employer.getWebAddress()))
			return new ErrorResult("Your email must contain the domain in it.");

		return new SuccessResult("Validation OK.");
		*/
	}
	
	@Override
	public Result checkCity(City city) {

		if (city.getName().isEmpty())
			return new ErrorResult("The city name can not be empty.");
		return new SuccessResult("Validation OK.");
	}

	@Override
	public Result checkJobAdvertisement(JobAdvertisement jobAdvertisement) {

		if (jobAdvertisement.getDescription().isEmpty())
			return new ErrorResult("Please fill the blanks completely.");
		if (jobAdvertisement.getFreePositionAmount() <= 0)
			return new ErrorResult("Free position amount can't be zero or less.");

		return new SuccessResult("Validation OK.");
	}
	

}
