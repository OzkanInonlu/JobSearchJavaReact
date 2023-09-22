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

import hrms.jobSearch.business.abstracts.EmployerService;
import hrms.jobSearch.core.utilities.results.DataResult;
import hrms.jobSearch.core.utilities.results.ErrorDataResult;
import hrms.jobSearch.core.utilities.results.Result;
import hrms.jobSearch.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {
	
	private EmployerService employerService;

	@Autowired
	public EmployersController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Employer>> getAll(){
		return this.employerService.getAll();
	}
	
	@GetMapping("/getByCompanyNameContains")
	public DataResult<List<Employer>> findByCompanyNameContains(String name) {
		// TODO Auto-generated method stub
		return this.employerService.findByCompanyNameContains(name);
	}
/*	
	@PostMapping("/add")
	public Result add(@RequestBody Employer employer) {
		return this.employerService.add(employer);
	}
*/
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Employer employer){
		return ResponseEntity.ok(this.employerService.add(employer));
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
