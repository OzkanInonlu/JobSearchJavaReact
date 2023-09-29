package hrms.jobSearch.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.jobSearch.business.abstracts.SkillService;
import hrms.jobSearch.core.utilities.results.DataResult;
import hrms.jobSearch.core.utilities.results.Result;
import hrms.jobSearch.core.utilities.results.SuccessDataResult;
import hrms.jobSearch.core.utilities.results.SuccessResult;
import hrms.jobSearch.dataAccess.abstracts.SkillDao;
import hrms.jobSearch.entities.concretes.Skill;

@Service
public class SkillManager implements SkillService{
	
	private SkillDao skillDao;

	@Autowired
	public SkillManager(SkillDao skillDao) {
		super();
		this.skillDao = skillDao;
	}

	@Override
	public DataResult<List<Skill>> getAll() {
		return new SuccessDataResult<List<Skill>>(this.skillDao.findAll(), "Data Listed");
		
	}

	@Override
	public Result add(Skill skill) {
		this.skillDao.save(skill);
		return new SuccessResult("Skill is added");
	}

	@Override
	public DataResult<List<Skill>> findAllByCandidateCv_Id(int candidateCvId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Skill>>
		(this.skillDao.findAllByCandidateCv_Id(candidateCvId), "Data Listelendi");
	}

	@Override
	public Skill findById(int skillId) {
		// TODO Auto-generated method stub
		return this.skillDao.findById(skillId);
	}

}
