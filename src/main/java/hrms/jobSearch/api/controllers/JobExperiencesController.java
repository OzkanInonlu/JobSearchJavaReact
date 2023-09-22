package hrms.jobSearch.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.jobSearch.business.abstracts.JobExperienceService;
import hrms.jobSearch.core.utilities.results.DataResult;
import hrms.jobSearch.core.utilities.results.Result;
import hrms.jobSearch.entities.concretes.JobExperience;

@RestController
@RequestMapping("/api/jobExperiences")
public class JobExperiencesController {

	private JobExperienceService jobExperienceService;

	@Autowired
	public JobExperiencesController(JobExperienceService jobExperienceService) {
		super();
		this.jobExperienceService = jobExperienceService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobExperience>> getAll() {
		
		return this.jobExperienceService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobExperience jobExperience) {
		return this.jobExperienceService.add(jobExperience);
	}

	@GetMapping("/findAllByCandidateCv_IdOrderByDateOfEndAsc")
	public DataResult<List<JobExperience>> findAllByCandidateCv_IdOrderByEndDateAsc(int candidateCvId) {
		// TODO Auto-generated method stub
		return this.jobExperienceService.findAllByCandidateCv_IdOrderByEndDateAsc(candidateCvId);
	}

	@GetMapping("/findAllByCandidateCv_IdOrderByDateOfEndDesc")
	public DataResult<List<JobExperience>> findAllByCandidateCv_IdOrderByEndDateDesc(int candidateCvId) {
		return this.jobExperienceService.findAllByCandidateCv_IdOrderByEndDateDesc(candidateCvId);
	}
	
	@GetMapping("/findAllByCandidateCv_Id")
	public DataResult<List<JobExperience>> findAllByCandidateCv_Id(@RequestParam int candidateCvId) {
		// TODO Auto-generated method stub
		return this.jobExperienceService.findAllByCandidateCv_Id(candidateCvId);
	}
	
	
}
