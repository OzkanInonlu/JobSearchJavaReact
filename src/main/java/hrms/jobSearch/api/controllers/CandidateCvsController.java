package hrms.jobSearch.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.jobSearch.business.abstracts.CandidateCvService;
import hrms.jobSearch.core.utilities.results.DataResult;
import hrms.jobSearch.core.utilities.results.Result;
import hrms.jobSearch.core.utilities.results.SuccessDataResult;
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

@RestController
@RequestMapping("/api/candidateCvs")
public class CandidateCvsController {
	
	private CandidateCvService candidateCvService;

	@Autowired
	public CandidateCvsController(CandidateCvService candidateCvService) {
		super();
		this.candidateCvService = candidateCvService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CandidateCv>> getAll() {
		// TODO Auto-generated method stub
		return this.candidateCvService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody CandidateCv candidateCv) {
		// TODO Auto-generated method stub
		return this.candidateCvService.add(candidateCv);
	}
	
	@PostMapping("/addSkillToCv")
	public Result addSkillToCv(@RequestParam int candidateCvId, @RequestParam int skillId) {
		// TODO Auto-generated method stub
		return this.candidateCvService.addSkillToCv(candidateCvId, skillId);
	}
	
	
	@PostMapping("/addSchoolToCv")
	public Result addSchoolToCv(@RequestParam int candidateCvId, @RequestParam int schoolId) {
		// TODO Auto-generated method stub
		return this.candidateCvService.addSchoolToCv(candidateCvId, schoolId);
	}
	
	@PostMapping("/addJobExperienceToCv")
	public Result addJobExperienceToCv(@RequestParam int candidateCvId, @RequestParam int jobExperienceId) {
		// TODO Auto-generated method stub
		return this.candidateCvService.addJobExperienceToCv(candidateCvId, jobExperienceId);
	}
	
	
	@PostMapping("/addLanguageToCv")
	public Result addLanguageToCv(@RequestParam int candidateCvId, @RequestParam int languageId) {
		// TODO Auto-generated method stub
		return this.candidateCvService.addLanguageToCv(candidateCvId, languageId);
	}
	
	@PostMapping("/addWebAddressToCv")
	public Result addWebAddressToCv(@RequestParam int candidateCvId, @RequestParam int webAddressId) {
		// TODO Auto-generated method stub
		return this.addWebAddressToCv(candidateCvId, webAddressId);
	}
	
	
	
	
	
	@PostMapping("/findById")
	public DataResult<CandidateCv> findById(@RequestParam int candidateCvId) {
		// TODO Auto-generated method stub
		return this.candidateCvService.findById(candidateCvId);
	}
	
	@GetMapping("/getCandidateCvWithSchoolDetails")
	public DataResult<List<CandidateCvWithSchoolDto>> getCandidateCvWithSchoolDetails() {
		// TODO Auto-generated method stub
		return this.candidateCvService.getCandidateCvWithSchoolDetails();
	}
	
	@GetMapping("/getCandidateCvWithJobExperienceDetails")
	public DataResult<List<CandidateCvWithJobExperienceDto>> getCandidateCvWithJobExperienceDetails() {
		// TODO Auto-generated method stub
		return this.candidateCvService.getCandidateCvWithJobExperienceDetails();
	}
	
	@GetMapping("/getCandidateCvWithLanguageDetails")
	public DataResult<List<CandidateCvWithLanguageDto>> getCandidateCvWithLanguageDetails() {
		return this.candidateCvService.getCandidateCvWithLanguageDetails();
	}

	@PostMapping("/getCandidateCvWithSkillDetails")
	public DataResult<List<CandidateCvWithSkillDto>> getCandidateCvWithSkillDetails(@RequestParam int candidateCvId) {
		return this.candidateCvService.getCandidateCvWithSkillDetails(candidateCvId);
	}
	
	@GetMapping("/getCandidateCvWithWebAddressDetails")
	public DataResult<List<CandidateCvWithWebAddressDto>> getCandidateCvWithWebAddressDetails() {
		return this.candidateCvService.getCandidateCvWithWebAddressDetails();
	}






	

}
