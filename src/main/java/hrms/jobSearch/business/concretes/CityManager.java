package hrms.jobSearch.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.jobSearch.business.abstracts.CityService;
import hrms.jobSearch.business.validation.abstracts.ValidationRuleService;
import hrms.jobSearch.core.utilities.results.DataResult;
import hrms.jobSearch.core.utilities.results.ErrorResult;
import hrms.jobSearch.core.utilities.results.Result;
import hrms.jobSearch.core.utilities.results.SuccessDataResult;
import hrms.jobSearch.core.utilities.results.SuccessResult;
import hrms.jobSearch.dataAccess.abstracts.CityDao;
import hrms.jobSearch.entities.concretes.City;

@Service
public class CityManager implements CityService{
	
	private CityDao cityDao;
	private ValidationRuleService validationRuleService;
	
	@Autowired
	public CityManager(CityDao cityDao, ValidationRuleService validationRuleService) {
		super();
		this.cityDao = cityDao;
		this.validationRuleService = validationRuleService;
	}

	@Override
	public DataResult<List<City>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<City>>(this.cityDao.findAll(), "Data Listed");
	}

	@Override
	public Result add(City city) {
		// TODO Auto-generated method stub
		
		Result validationResult = validationRuleService.checkCity(city);
		if (!validationResult.isSuccess())
			return new ErrorResult(validationResult.getMessage());
		
		boolean checkCityResult = checkCity(city);
		if(checkCityResult) {
			return new ErrorResult("The city already exists");
		}
		this.cityDao.save(city);
		return new SuccessResult("The city is added successfully.");
	}
	
	// Auxiliary Functions
	public boolean checkCity(City city) {

		City findByName = this.cityDao.findByName(city.getName());
		if (findByName == null)
			return false;
		return true;
	}

}
