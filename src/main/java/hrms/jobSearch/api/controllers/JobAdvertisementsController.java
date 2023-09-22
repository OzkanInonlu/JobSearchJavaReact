package hrms.jobSearch.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.jobSearch.business.abstracts.JobAdvertisementService;
import hrms.jobSearch.core.utilities.results.DataResult;
import hrms.jobSearch.core.utilities.results.Result;
import hrms.jobSearch.core.utilities.results.SuccessDataResult;
import hrms.jobSearch.entities.concretes.JobAdvertisement;
import hrms.jobSearch.entities.dtos.JobAdvertisementWithEmployerDto;

@RestController
@RequestMapping("/api/jobadvertisements")
public class JobAdvertisementsController {
	
	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdvertisement>> getAll() {
		// TODO Auto-generated method stub
		return this.jobAdvertisementService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		// TODO Auto-generated method stub
		return this.jobAdvertisementService.add(jobAdvertisement);
	}

//	@GetMapping("/getAllSortedByDate")
//	public DataResult<List<JobAdvertisement>> getAllSortedByDate() {
//		// TODO Auto-generated method stub
//		return this.jobAdvertisementService.getAllSortedByDate();
//	}
//	
	
	@GetMapping("/getActiveJobAdvertisements")
	public DataResult<List<JobAdvertisement>> getActiveJobAdvertisement() {
		// TODO Auto-generated method stub
		return this.jobAdvertisementService.getActiveJobAdvertisement();
	}

	@GetMapping("/getActiveJobAdvertisementsByDateDesc")
	public DataResult<List<JobAdvertisement>> getActiveJobAdvertisementByDateDesc() {
		return this.jobAdvertisementService.getActiveJobAdvertisementByDateDesc();

	}
	

	@GetMapping("/getActiveJobAdvertisementsByDateAsc")
	public DataResult<List<JobAdvertisement>> getActiveJobAdvertisementByDateAsc() {
		return this.jobAdvertisementService.getActiveJobAdvertisementByDateAsc();

	}

	@GetMapping("/getActiveJobAdvertisementsByCompany")
	public DataResult<List<JobAdvertisement>> getActiveJobAdvertisementByCompany(@RequestParam String companyName) {
		return this.jobAdvertisementService.getActiveJobAdvertisementByCompany(companyName);

	}

	//updating status to false
	@PostMapping("/updateJobAdvertisementStatusById")
	public Result updateJobAdvertisementStatus(@RequestParam int jobAdvertisementId, @RequestParam boolean selectedStatus) {
		return this.jobAdvertisementService.updateJobAdvertisementStatus(jobAdvertisementId, selectedStatus);


	}
	
	@GetMapping("/getByJobPositionTitleContains")
	public DataResult<List<JobAdvertisement>> getByJobPosition_TitleContains(@RequestParam String jobName) {
		// TODO Auto-generated method stub
		return this.jobAdvertisementService.getByJobPosition_TitleContains(jobName);
	}
	
	@GetMapping("/getJobAdvertisementWithEmployerDetails")
	public DataResult<List<JobAdvertisementWithEmployerDto>> getJobAdvertisementWithEmployerDetails() {
		// TODO Auto-generated method stub
		return this.jobAdvertisementService.getJobAdvertisementWithEmployerDetails();
	}


}
