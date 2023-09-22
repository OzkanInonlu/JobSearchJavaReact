package hrms.jobSearch.business.abstracts;

import java.util.List;

import hrms.jobSearch.core.utilities.results.DataResult;
import hrms.jobSearch.core.utilities.results.Result;
import hrms.jobSearch.entities.concretes.Employee;

public interface EmployeeService {
	
	DataResult<List<Employee>> getAll();
	
	Result add(Employee employee);
	
	DataResult<Employee> findByEmail(String email);
	
	DataResult<Employee> findById(int employeeId);
	
	DataResult<List<Employee>> findByEmailContains(String email);


}
