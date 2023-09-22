package hrms.jobSearch.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.jobSearch.business.abstracts.EmployeeService;
import hrms.jobSearch.core.utilities.results.DataResult;
import hrms.jobSearch.core.utilities.results.Result;
import hrms.jobSearch.core.utilities.results.SuccessDataResult;
import hrms.jobSearch.core.utilities.results.SuccessResult;
import hrms.jobSearch.dataAccess.abstracts.EmployeeDao;
import hrms.jobSearch.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService{
	
	private EmployeeDao employeeDao;
	
	
	@Autowired
	public EmployeeManager(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Employee>>
		(this.employeeDao.findAll(), "Data Listelendi");
	}

	@Override
	public Result add(Employee employee) {
		// TODO Auto-generated method stub
		this.employeeDao.save(employee);
		return new SuccessResult("The employee is added");
	}

	@Override
	public DataResult<Employee> findByEmail(String email) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Employee>(this.employeeDao.findByEmail(email), "Data Listelendi");
	}

	@Override
	public DataResult<Employee> findById(int employeeId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Employee>(this.employeeDao.findById(employeeId), "Data Listelendi");
	}

	@Override
	public DataResult<List<Employee>> findByEmailContains(String email) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Employee>>
		(this.employeeDao.findByEmailContains(email), "Data Listelendi");
	}

}
