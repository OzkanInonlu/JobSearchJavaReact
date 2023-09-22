package hrms.jobSearch.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.jobSearch.entities.concretes.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer>{
	
	Employee findById(int employeeId);
	Employee findByEmail(String email);
	List<Employee> findByEmailContains(String email);


}
