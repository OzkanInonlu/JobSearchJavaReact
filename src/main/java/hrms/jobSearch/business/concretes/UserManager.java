package hrms.jobSearch.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import hrms.jobSearch.business.abstracts.UserService;
import hrms.jobSearch.core.utilities.results.DataResult;
import hrms.jobSearch.core.utilities.results.Result;
import hrms.jobSearch.dataAccess.abstracts.UserDao;
import hrms.jobSearch.entities.concretes.User;

public class UserManager implements UserService{
	
	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<User>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result add(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
