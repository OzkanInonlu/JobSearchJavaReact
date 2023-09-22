package hrms.jobSearch.business.abstracts;

import java.util.List;

import hrms.jobSearch.core.utilities.results.DataResult;
import hrms.jobSearch.core.utilities.results.Result;
import hrms.jobSearch.entities.concretes.WebAddress;

public interface WebAddressService {
	
	DataResult<List<WebAddress>> getAll();
	
	Result add(WebAddress webAddress);
	
	DataResult<List<WebAddress>> findAllByCandidateCv_Id(int candidateCvId);


}
