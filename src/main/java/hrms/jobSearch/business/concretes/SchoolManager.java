package hrms.jobSearch.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.jobSearch.business.abstracts.SchoolService;
import hrms.jobSearch.core.utilities.results.DataResult;
import hrms.jobSearch.core.utilities.results.Result;
import hrms.jobSearch.core.utilities.results.SuccessDataResult;
import hrms.jobSearch.core.utilities.results.SuccessResult;
import hrms.jobSearch.dataAccess.abstracts.SchoolDao;
import hrms.jobSearch.entities.concretes.School;

@Service
public class SchoolManager implements SchoolService{
	
	private SchoolDao schoolDao;
	
	
	@Autowired
	public SchoolManager(SchoolDao schoolDao) {
		super();
		this.schoolDao = schoolDao;
	}

	@Override
	public DataResult<List<School>> getAll() {
		return new SuccessDataResult<List<School>>(this.schoolDao.findAll(), "Data Listed");
	}

	@Override
	public Result add(School school) {
		// TODO Auto-generated method stub
		this.schoolDao.save(school);
		return new SuccessResult("The school is added");
	}

	@Override
	public DataResult<List<School>> findAllByCandidateCv_IdOrderByGraduateDateAsc(int candidateCvId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<School>>
		(this.schoolDao.findAllByCandidateCv_IdOrderByGraduateDateAsc(candidateCvId), "Data Listed ascending");
	}

	@Override
	public DataResult<List<School>> findAllByCandidateCv_IdOrderByGraduateDateDesc(int candidateCvId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<School>>
		(this.schoolDao.findAllByCandidateCv_IdOrderByGraduateDateDesc(candidateCvId), "Data Listed descending");
	}

	@Override
	public DataResult<List<School>> findAllByCandidateCv_Id(int candidateCvId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<School>>(this.schoolDao.findAllByCandidateCv_Id(candidateCvId), "Data Listelendi");
	}

}
