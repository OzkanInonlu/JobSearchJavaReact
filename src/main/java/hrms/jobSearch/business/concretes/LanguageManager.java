package hrms.jobSearch.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.jobSearch.business.abstracts.LanguageService;
import hrms.jobSearch.core.utilities.results.DataResult;
import hrms.jobSearch.core.utilities.results.Result;
import hrms.jobSearch.core.utilities.results.SuccessDataResult;
import hrms.jobSearch.core.utilities.results.SuccessResult;
import hrms.jobSearch.dataAccess.abstracts.LanguageDao;
import hrms.jobSearch.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {
	
	private LanguageDao languageDao;
	
	@Autowired
	public LanguageManager(LanguageDao languageDao) {
		super();
		this.languageDao = languageDao;
	}

	@Override
	public DataResult<List<Language>> getAll() {
		return new SuccessDataResult<List<Language>>(this.languageDao.findAll(), "Data Listed");
	}

	@Override
	public Result add(Language language) {
		this.languageDao.save(language);
		return new SuccessResult("The language is added");
	}


	@Override
	public DataResult<List<Language>> findAllByCandidateCv_Id(int candidateCvId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Language>>
		(this.languageDao.findAllByCandidateCv_Id(candidateCvId), "Data Listelendi");
	}

}
