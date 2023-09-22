package hrms.jobSearch.api.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import hrms.jobSearch.business.abstracts.CandidateImageService;
import hrms.jobSearch.core.utilities.results.DataResult;
import hrms.jobSearch.core.utilities.results.Result;
import hrms.jobSearch.entities.concretes.CandidateImage;

@RestController
@RequestMapping("/api/candidateImages")
public class CandidateImagesController {
	
	private CandidateImageService candidateImageService;

	@Autowired
	public CandidateImagesController(CandidateImageService candidateImageService) {
		super();
		this.candidateImageService = candidateImageService;
	}
	
//	@PostMapping("/add")
//	public Result add(int candidateId, int candidateCvId, MultipartFile multipartFile) {
//		return this.candidateImageService.add(candidateId, candidateCvId, multipartFile);
//	}
	
	@PostMapping("/upload")
	public ResponseEntity<?> upload(@RequestParam int candidateId, @RequestParam int candidateCvId, @RequestParam MultipartFile file){
		
		return ResponseEntity.ok(this.candidateImageService.upload(candidateId, candidateCvId, file));
		
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CandidateImage>> getAll(){
		return this.candidateImageService.getAll();
	}

}












