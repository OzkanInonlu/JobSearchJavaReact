package hrms.jobSearch.business.abstracts;

import java.util.List;

import hrms.jobSearch.core.utilities.results.DataResult;
import hrms.jobSearch.core.utilities.results.Result;
import hrms.jobSearch.entities.concretes.User;

public interface UserService {
	
	DataResult<List<User>> getAll();
	
	Result add(User user);

}
