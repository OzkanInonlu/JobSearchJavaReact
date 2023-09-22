package hrms.jobSearch.business.abstracts;

import java.util.List;

import hrms.jobSearch.core.utilities.results.DataResult;
import hrms.jobSearch.core.utilities.results.Result;
import hrms.jobSearch.entities.concretes.School;

public interface SchoolService {
	
	DataResult<List<School>> getAll();
	Result add(School school);
	
	DataResult<List<School>> findAllByCandidateCv_IdOrderByGraduateDateAsc(int candidateCvId);
	DataResult<List<School>> findAllByCandidateCv_IdOrderByGraduateDateDesc(int candidateCvId);
	
	DataResult<List<School>> findAllByCandidateCv_Id(int candidateCvId);

}
