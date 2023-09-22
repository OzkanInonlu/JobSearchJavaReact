package hrms.jobSearch.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.jobSearch.business.abstracts.CandidateCvService;
import hrms.jobSearch.core.utilities.results.DataResult;
import hrms.jobSearch.core.utilities.results.ErrorResult;
import hrms.jobSearch.core.utilities.results.Result;
import hrms.jobSearch.core.utilities.results.SuccessDataResult;
import hrms.jobSearch.core.utilities.results.SuccessResult;
import hrms.jobSearch.dataAccess.abstracts.CandidateCvDao;
import hrms.jobSearch.dataAccess.abstracts.JobExperienceDao;
import hrms.jobSearch.dataAccess.abstracts.SchoolDao;
import hrms.jobSearch.dataAccess.abstracts.SkillDao;
import hrms.jobSearch.entities.concretes.CandidateCv;
import hrms.jobSearch.entities.concretes.JobExperience;
import hrms.jobSearch.entities.concretes.Language;
import hrms.jobSearch.entities.concretes.School;
import hrms.jobSearch.entities.concretes.Skill;
import hrms.jobSearch.entities.concretes.WebAddress;
import hrms.jobSearch.entities.dtos.CandidateCvWithJobExperienceDto;
import hrms.jobSearch.entities.dtos.CandidateCvWithLanguageDto;
import hrms.jobSearch.entities.dtos.CandidateCvWithSchoolDto;
import hrms.jobSearch.entities.dtos.CandidateCvWithSkillDto;
import hrms.jobSearch.entities.dtos.CandidateCvWithWebAddressDto;

@Service
public class CandidateCvManager implements CandidateCvService{
	
	@Autowired
	private CandidateCvDao candidateCvDao;
	@Autowired
	private SkillDao skillDao;
	@Autowired
	private SchoolDao schoolDao;
	@Autowired
	private JobExperienceDao jobExperienceDao;


	@Override
	public DataResult<List<CandidateCv>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<CandidateCv>>(this.candidateCvDao.findAll(), "Data Listed");
	}

	@Override
	public Result add(CandidateCv candidateCv) {
		// TODO Auto-generated method stub
		this.candidateCvDao.save(candidateCv);
		return new SuccessResult("The candidate cv is added");
	}
	

	@Override
	public Result addSkillToCv(int candidateCvId, int skillId) {
		Skill skill = skillDao.findById(skillId);
		if(skill == null) {
			return new ErrorResult("There is no such skill");
		}
		if(candidateCvDao.existsSkillInCv(skillId)) {
			return new ErrorResult("This skill exists in cv");
		}
		if(!candidateCvDao.existsById(candidateCvId)) {
			return new ErrorResult("There is no such cv");
		}
		this.candidateCvDao.addSkillToCv(candidateCvId, skillId);
		return new SuccessResult("Skill is added to cv");
		
	}
	

	@Override
	public Result addSchoolToCv(int candidateCvId, int schoolId) {
		// TODO Auto-generated method stub
		School school = schoolDao.findById(schoolId);
		if(school == null) {
			return new ErrorResult("There is no such school");
		}
		if(!candidateCvDao.existsById(candidateCvId)) {
			return new ErrorResult("There is no such cv");
		}
		if(candidateCvDao.existsSchoolInCv(schoolId)) {
			return new ErrorResult("This school exists in cv");
		}
		this.candidateCvDao.addSchoolToCv(candidateCvId, schoolId);
		return new SuccessResult("School is added to cv");
	}
	
	@Override
	public Result addJobExperienceToCv(int candidateCvId, int jobExperienceId) {
		// TODO Auto-generated method stub
		JobExperience jobExperience = jobExperienceDao.findById(jobExperienceId);
		if(jobExperience == null) {
			return new ErrorResult("There is no such job experience");
		}
		if(!candidateCvDao.existsById(candidateCvId)) {
			return new ErrorResult("There is no such cv");
		}
		if(candidateCvDao.existsJobExperienceInCv(jobExperienceId)) {
			return new ErrorResult("This job experience exists in cv");
		}
		this.candidateCvDao.addJobExperienceToCv(candidateCvId, jobExperienceId);
		return new SuccessResult("Job experience is added to cv");
	}

	@Override
	public DataResult<CandidateCv> findById(int candidateCvId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<CandidateCv>(this.candidateCvDao.findById(candidateCvId), "Data Listed");
	}

	@Override
	public DataResult<List<CandidateCvWithSchoolDto>> getCandidateCvWithSchoolDetails() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<CandidateCvWithSchoolDto>>
		(this.candidateCvDao.getCandidateCvWithSchoolDetails(), "Data Listed");
	}

	@Override
	public DataResult<List<CandidateCvWithJobExperienceDto>> getCandidateCvWithJobExperienceDetails() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<CandidateCvWithJobExperienceDto>>
		(this.candidateCvDao.getCandidateCvWithJobExperienceDetails(), "Data Listed");
	}

	@Override
	public DataResult<List<CandidateCvWithLanguageDto>> getCandidateCvWithLanguageDetails() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<CandidateCvWithLanguageDto>>
		(this.candidateCvDao.getCandidateCvWithLanguageDetails(), "Data Listed");
	}

	@Override
	public DataResult<List<CandidateCvWithSkillDto>> getCandidateCvWithSkillDetails(int candidateCvId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<CandidateCvWithSkillDto>>
		(this.candidateCvDao.getCandidateCvWithSkillDetails(candidateCvId), "Data Listed");
	}

	@Override
	public DataResult<List<CandidateCvWithWebAddressDto>> getCandidateCvWithWebAddressDetails() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<CandidateCvWithWebAddressDto>>
		(this.candidateCvDao.getCandidateCvWithWebAddressDetails(), "Data Listed");
	}





	








}
