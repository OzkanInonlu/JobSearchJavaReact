package hrms.jobSearch.business.abstracts;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import hrms.jobSearch.core.utilities.results.DataResult;
import hrms.jobSearch.core.utilities.results.Result;
import hrms.jobSearch.entities.concretes.Candidate;
import hrms.jobSearch.entities.concretes.CandidateImage;

public interface CandidateImageService {
	
	DataResult<List<CandidateImage>> getAll();
	
	//Result add(int candidateId, int candidateCvId, MultipartFile multipartFile);
	
	Result upload(int candidateId, int candidateCvId, MultipartFile file);
	
}
