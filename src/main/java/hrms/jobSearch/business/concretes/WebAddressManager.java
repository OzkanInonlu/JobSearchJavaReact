package hrms.jobSearch.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.jobSearch.business.abstracts.WebAddressService;
import hrms.jobSearch.core.utilities.results.DataResult;
import hrms.jobSearch.core.utilities.results.Result;
import hrms.jobSearch.core.utilities.results.SuccessDataResult;
import hrms.jobSearch.core.utilities.results.SuccessResult;
import hrms.jobSearch.dataAccess.abstracts.WebAddressDao;
import hrms.jobSearch.entities.concretes.WebAddress;

@Service
public class WebAddressManager implements WebAddressService{
	
	private WebAddressDao websiteDao;
	
	@Autowired
	public WebAddressManager(WebAddressDao websiteDao) {
		super();
		this.websiteDao = websiteDao;
	}

	@Override
	public DataResult<List<WebAddress>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<WebAddress>>(this.websiteDao.findAll(), "Data Listed");
	}

	@Override
	public Result add(WebAddress website) {
		// TODO Auto-generated method stub
		this.websiteDao.save(website);
		return new SuccessResult("The website is added");
	}


	@Override
	public DataResult<List<WebAddress>> findAllByCandidateCv_Id(int candidateCvId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<WebAddress>>
		(this.websiteDao.findAllByCandidateCv_Id(candidateCvId), "Data Listelendi");
	}

}
