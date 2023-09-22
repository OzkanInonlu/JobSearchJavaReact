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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import hrms.jobSearch.business.abstracts.EmployeeService;
import hrms.jobSearch.core.utilities.results.DataResult;
import hrms.jobSearch.core.utilities.results.ErrorDataResult;
import hrms.jobSearch.core.utilities.results.Result;
import hrms.jobSearch.core.utilities.results.SuccessDataResult;
import hrms.jobSearch.core.utilities.results.SuccessResult;
import hrms.jobSearch.entities.concretes.Employee;
import hrms.jobSearch.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController {
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeesController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@GetMapping("/getAll")
	public DataResult<List<Employee>> getAll() {
		// TODO Auto-generated method stub
		return this.employeeService.getAll();
	}

//	@PostMapping("/add")
//	public Result add(@RequestBody Employee employee) {
//		// TODO Auto-generated method stub
//		return this.employeeService.add(employee);
//	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Employee employee){
		return ResponseEntity.ok(this.employeeService.add(employee));
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

	@GetMapping("/findByEmail")
	public DataResult<Employee> findByEmail(@RequestParam String email) {
		return this.employeeService.findByEmail(email);
	}

	@GetMapping("/findById")
	public DataResult<Employee> findById(@RequestParam int employeeId) {
		// TODO Auto-generated method stub
		return this.employeeService.findById(employeeId);
	}
	
	@GetMapping("/findByEmailContains")
	public DataResult<List<Employee>> findByEmailContains(@RequestParam String email) {
		return this.employeeService.findByEmailContains(email);
	}
}
