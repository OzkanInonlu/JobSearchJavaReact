package hrms.jobSearch.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.jobSearch.business.abstracts.WebAddressService;
import hrms.jobSearch.core.utilities.results.DataResult;
import hrms.jobSearch.core.utilities.results.Result;

import hrms.jobSearch.entities.concretes.WebAddress;

@RestController
@RequestMapping("/api/websites")
public class WebAddressesController {
	
	private WebAddressService websiteService;

	@Autowired
	public WebAddressesController(WebAddressService websiteService) {
		super();
		this.websiteService = websiteService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<WebAddress>> getAll() {
		// TODO Auto-generated method stub
		return this.websiteService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody WebAddress website) {
		// TODO Auto-generated method stub
		return this.websiteService.add(website);
	}
	


	@GetMapping("/findAllByCandidateCv_Id")
	public DataResult<List<WebAddress>> findAllByCandidateCv_Id(@RequestParam int candidateCvId) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		return this.websiteService.findAllByCandidateCv_Id(candidateCvId);
	}

}
