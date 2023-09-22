package hrms.jobSearch.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.jobSearch.business.abstracts.SkillService;
import hrms.jobSearch.core.utilities.results.DataResult;
import hrms.jobSearch.core.utilities.results.Result;
import hrms.jobSearch.entities.concretes.Skill;

@RestController
@RequestMapping("/api/skills")
public class SkillsController {
	
	private SkillService skillService;

	@Autowired
	public SkillsController(SkillService skillService) {
		super();
		this.skillService = skillService;
	}
	
	@GetMapping(value = "/getAll")
	public DataResult<List<Skill>> getAll(){
		return this.skillService.getAll();
	}
	
	@PostMapping(value = "/add")
	public Result add(@RequestBody Skill skill) {
		return this.skillService.add(skill);
	}
	
	@GetMapping("/findAllByCandidateCv_Id")
	public DataResult<List<Skill>> findAllByCandidateCv_Id(@RequestParam int candidateCvId) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		return this.skillService.findAllByCandidateCv_Id(candidateCvId);
	}
}
