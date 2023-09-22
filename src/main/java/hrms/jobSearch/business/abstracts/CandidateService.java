package hrms.jobSearch.business.abstracts;

import java.util.List;

import hrms.jobSearch.core.utilities.results.DataResult;
import hrms.jobSearch.core.utilities.results.Result;
import hrms.jobSearch.entities.concretes.Candidate;

public interface CandidateService {
	DataResult<List<Candidate>> getAll();
	
	Result add(Candidate candidate);

}
