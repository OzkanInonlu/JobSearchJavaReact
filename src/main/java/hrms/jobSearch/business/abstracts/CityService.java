package hrms.jobSearch.business.abstracts;

import java.util.List;

import hrms.jobSearch.core.utilities.results.DataResult;
import hrms.jobSearch.core.utilities.results.Result;
import hrms.jobSearch.entities.concretes.City;

public interface CityService {
	
	DataResult<List<City>> getAll();

	Result add(City city);

}
