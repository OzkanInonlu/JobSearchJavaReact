package hrms.jobSearch.business.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import hrms.jobSearch.core.utilities.results.DataResult;
import hrms.jobSearch.core.utilities.results.Result;
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
import hrms.jobSearch.entities.dtos.CandidateCvWithWebAddressDto;

public interface CandidateCvService {
	
	DataResult<List<CandidateCv>> getAll();
	
	Result add(CandidateCv candidateCv);
	
	Result addSkillToCv(int candidateCvId, int skillId);
	
	Result addSchoolToCv(int candidateCvId, int schoolId);
	
	Result addJobExperienceToCv(int candidateCvId, int jobExperienceId);
	
	DataResult<CandidateCv> findById(int candidateCvId);
	
	
	
	
	DataResult<List<CandidateCvWithSchoolDto>> getCandidateCvWithSchoolDetails(); 

	DataResult<List<CandidateCvWithJobExperienceDto>> getCandidateCvWithJobExperienceDetails(); 

	DataResult<List<CandidateCvWithLanguageDto>> getCandidateCvWithLanguageDetails(); 
	
	DataResult<List<CandidateCvWithSkillDto>> getCandidateCvWithSkillDetails(int candidateCvId); 
	
	DataResult<List<CandidateCvWithWebAddressDto>> getCandidateCvWithWebAddressDetails(); 

	


}
