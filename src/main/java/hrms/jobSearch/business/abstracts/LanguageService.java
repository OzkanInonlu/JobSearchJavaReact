package hrms.jobSearch.business.abstracts;

import java.util.List;

import hrms.jobSearch.core.utilities.results.DataResult;
import hrms.jobSearch.core.utilities.results.Result;
import hrms.jobSearch.entities.concretes.Language;

public interface LanguageService {
	
	DataResult<List<Language>> getAll();
	Result add(Language language);
	
	DataResult<List<Language>> findAllByCandidateCv_Id(int candidateCvId);


}
