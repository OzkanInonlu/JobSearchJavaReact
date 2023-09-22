package hrms.jobSearch.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import hrms.jobSearch.business.abstracts.CandidateService;
import hrms.jobSearch.core.utilities.results.DataResult;
import hrms.jobSearch.core.utilities.results.ErrorDataResult;
import hrms.jobSearch.core.utilities.results.Result;
import hrms.jobSearch.entities.concretes.Candidate;

@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {
	
	
	private CandidateService candidateService;
	
	@Autowired
	public CandidatesController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}

	@GetMapping("/getAll") //get request -> 
	public DataResult<List<Candidate>> getAll(){
		
		return this.candidateService.getAll();
		
	}
	/*
	@PostMapping("/add")
	public Result add(@RequestBody Candidate candidate) {
		return this.candidateService.add(candidate);
	}
	*/
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Candidate candidate){
		return ResponseEntity.ok(this.candidateService.add(candidate));
	}
	
	//GLOBAL EXCEPTION HANDLER
	//bu tür bir hata olursa, çalışsın
	//MethodArgumentNotValidException -> @NotBlank, @NotNull, @Email vs
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST) //400 Bad Request.
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
		
		//Map = dict
		Map<String, String> validationErrors = new HashMap<String, String>();
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Validation Errors");
		return errors;
		
	}
}
