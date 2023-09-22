package hrms.jobSearch.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.jobSearch.business.abstracts.LanguageService;
import hrms.jobSearch.core.utilities.results.DataResult;
import hrms.jobSearch.core.utilities.results.Result;

import hrms.jobSearch.entities.concretes.Language;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
	
	private LanguageService languageService;

	@Autowired
	public LanguagesController(LanguageService languageService) {
		super();
		this.languageService = languageService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Language>> getAll() {
		return this.languageService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody Language language) {
		return this.languageService.add(language);
	}
	
	@GetMapping("/findAllByCandidateCv_Id")
	public DataResult<List<Language>> findAllByCandidateCv_Id(@RequestParam int candidateCvId) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		return this.languageService.findAllByCandidateCv_Id(candidateCvId);
	}

}
