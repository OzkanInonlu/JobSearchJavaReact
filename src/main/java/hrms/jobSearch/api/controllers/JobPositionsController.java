package hrms.jobSearch.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.jobSearch.business.abstracts.JobPositionService;
import hrms.jobSearch.core.utilities.results.DataResult;
import hrms.jobSearch.core.utilities.results.Result;
import hrms.jobSearch.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionsController {
	
	
	private JobPositionService jobPositionService;
	
	@Autowired
	public JobPositionsController(JobPositionService jobPositionService) {
		super();
		this.jobPositionService = jobPositionService;
	}

	@GetMapping("/getAll") //get request -> localhost:8080/api/products/getall
	public DataResult<List<JobPosition>> getAll(){
		
		return this.jobPositionService.getAll();
		
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobPosition jobPosition) {
		return this.jobPositionService.add(jobPosition);
	}
	
	@GetMapping("/getByTitleContains")
	public List<JobPosition> getByTitleContains(@RequestParam String title) {
		// TODO Auto-generated method stub
		return this.jobPositionService.getByTitleContains(title);
	}



}
