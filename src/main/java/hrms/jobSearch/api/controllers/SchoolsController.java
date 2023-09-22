package hrms.jobSearch.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.jobSearch.business.abstracts.SchoolService;
import hrms.jobSearch.core.utilities.results.DataResult;
import hrms.jobSearch.core.utilities.results.Result;
import hrms.jobSearch.entities.concretes.School;

@RestController
@RequestMapping("/api/schools")
public class SchoolsController {
	
	private SchoolService schoolService;

	@Autowired
	public SchoolsController(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	}
	
	@GetMapping(value = "/getAll")
	public DataResult<List<School>> getAll(){
		return this.schoolService.getAll();
	}
	
	@PostMapping(value = "/add")
	public Result add(@RequestBody School school) {
		return this.schoolService.add(school);
	}
	
	@GetMapping(value = "/findAllByCandidateCv_IdOrderByGraduateDateAsc")
	public DataResult<List<School>> findAllByCandidateCv_IdOrderByGraduateDateAsc(@RequestParam int candidateCvId) {
		// TODO Auto-generated method stub
		return this.schoolService.findAllByCandidateCv_IdOrderByGraduateDateAsc(candidateCvId);
	}

	@GetMapping(value = "/findAllByCandidateCv_IdOrderByGraduateDateDesc")
	public DataResult<List<School>> findAllByCandidateCv_IdOrderByGraduateDateDesc(@RequestParam int candidateCvId) {
		// TODO Auto-generated method stub
		return this.schoolService.findAllByCandidateCv_IdOrderByGraduateDateDesc(candidateCvId);

	}
	
	
	@GetMapping("/findAllByCandidateCv_Id")
	public DataResult<List<School>> findAllByCandidateCv_Id(@RequestParam int candidateCvId) {
		// TODO Auto-generated method stub
		return this.schoolService.findAllByCandidateCv_Id(candidateCvId);
	}

}
