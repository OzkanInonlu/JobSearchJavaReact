package hrms.jobSearch.business.abstracts;

import java.util.List;

import hrms.jobSearch.core.utilities.results.DataResult;
import hrms.jobSearch.core.utilities.results.Result;
import hrms.jobSearch.entities.concretes.Skill;

public interface SkillService {
	
	DataResult<List<Skill>> getAll();
	Result add(Skill skill);
	
	DataResult<List<Skill>> findAllByCandidateCv_Id(int candidateCvId);
	Skill findById(int skillId);


}
