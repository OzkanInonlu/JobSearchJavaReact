package hrms.jobSearch.business.abstracts;

import java.util.List;

import hrms.jobSearch.core.utilities.results.DataResult;
import hrms.jobSearch.core.utilities.results.Result;
import hrms.jobSearch.entities.concretes.Employer;

public interface EmployerService {

	DataResult<List<Employer>> getAll();
	
	Result add(Employer employer);
	
	DataResult<List<Employer>> findByCompanyNameContains(String name);

}
