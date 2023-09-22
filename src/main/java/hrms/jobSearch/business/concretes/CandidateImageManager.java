package hrms.jobSearch.business.concretes;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import hrms.jobSearch.business.abstracts.CandidateCvService;
import hrms.jobSearch.business.abstracts.CandidateImageService;
import hrms.jobSearch.business.abstracts.CandidateService;
import hrms.jobSearch.core.adapters.abstracts.CloudinaryFileService;
import hrms.jobSearch.core.utilities.results.DataResult;
import hrms.jobSearch.core.utilities.results.ErrorDataResult;
import hrms.jobSearch.core.utilities.results.ErrorResult;
import hrms.jobSearch.core.utilities.results.Result;
import hrms.jobSearch.core.utilities.results.SuccessDataResult;
import hrms.jobSearch.core.utilities.results.SuccessResult;
import hrms.jobSearch.dataAccess.abstracts.CandidateCvDao;
import hrms.jobSearch.dataAccess.abstracts.CandidateDao;
import hrms.jobSearch.dataAccess.abstracts.CandidateImageDao;
import hrms.jobSearch.entities.concretes.Candidate;
import hrms.jobSearch.entities.concretes.CandidateCv;
import hrms.jobSearch.entities.concretes.CandidateImage;
import lombok.experimental.var;

@Service
public class CandidateImageManager implements CandidateImageService{
	
	private CandidateImageDao candidateImageDao;
	private CloudinaryFileService cloudinaryFileService;
	private CandidateDao candidateDao;
	private CandidateCvDao candidateCvDao;
	
	//@Autowired
	//private Cloudinary cloudinary;
	
	@Autowired
	public CandidateImageManager(CandidateImageDao candidateImageDao, CloudinaryFileService cloudinaryFileService,
			CandidateDao candidateDao, CandidateCvDao candidateCvDao) {
		super();
		this.candidateImageDao = candidateImageDao;
		this.cloudinaryFileService = cloudinaryFileService;
		this.candidateDao = candidateDao;
		this.candidateCvDao = candidateCvDao;
	}

	@Override
	public DataResult<List<CandidateImage>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<CandidateImage>>(this.candidateImageDao.findAll(), "Data Listed");
	}
//
//
//
//	@Override
//	public Result add(int candidateId, int candidateCvId, MultipartFile multipartFile) {
//		// TODO Auto-generated method stub
//        try {
//            var result = this.cloudinaryFileService.upload(multipartFile);
//            CandidateImage candidateImage = new CandidateImage();
//            if (!result.isSuccess()) {
//                return new ErrorResult(result.getMessage());
//            }
//            if(multipartFile == null){
//                candidateImage.setImage("Image is not uploaded");
//            }
//            Candidate candidate = candidateDao.findById(candidateId);
//            CandidateCv candidateCv = candidateCvDao.findById(candidateCvId);
//            
//            candidateImage.setCandidate(candidate);
//            
//            String[] readList = {"pdf","txt","docx"};
//            String url = result.getData().get("url");
//            
//            candidateImage.setImage(multiFileValidation(url, readList, "png"));
//            candidateImageDao.save(candidateImage);
//            
//            candidateCv.setCandidateImage(candidateImage);
//            candidateCvDao.save(candidateCv);
//            
//            return new SuccessResult();
//        }catch (MethodArgumentTypeMismatchException | NoSuchElementException | NullPointerException e){
//            return new ErrorResult();
//        }
//	}
//	
//    public String multiFileValidation(String data, String[] readList, String replacement){
//        String newData = data;
//        for (String a: readList) {
//            newData = data.replace(a, replacement);
//            if (!newData.equals(data)) {
//                break;
//            }
//        }
//        return newData;
//    }

	@Override
	public Result upload(int candidateId, int candidateCvId, MultipartFile file) {
		
	      try {
		      DataResult<Map<String, String>> result = this.cloudinaryFileService.upload(file);
		      CandidateImage candidateImage = new CandidateImage();
		      if (!result.isSuccess()) {
		          return new ErrorResult(result.getMessage());
		      }
		      if(file == null){
		          candidateImage.setPhotoUrl("Image is not uploaded");
		      }
		      Candidate candidate = candidateDao.findById(candidateId);
		      CandidateCv candidateCv = candidateCvDao.findById(candidateCvId);
		      
		      if(candidateImageDao.findByCandidate_Id(candidateId) != null){
		    	  return new ErrorResult("Photo has been already uploaded before");
		      }
		      
		      candidateImage.setCandidate(candidate);
		      
		      String[] readList = {"pdf","txt","docx"};
		      String url = result.getData().get("url");
		      
		      candidateImage.setPhotoUrl(multiFileValidation(url, readList, "png"));
		      candidateImageDao.save(candidateImage);
		      
		      candidateCv.setCandidateImage(candidateImage);
		      candidateCvDao.save(candidateCv);
		      
		      return new SuccessResult(result.getMessage());
		      }
	      catch (MethodArgumentTypeMismatchException | NoSuchElementException | NullPointerException e){
	    	  return new ErrorResult(e.getMessage());
	    	  }
		
		
//		
//		try {
//			return new SuccessDataResult<Map>
//			(this.cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap()), "Photo Uploaded");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			throw new RuntimeException("Image uploading fail");
//		}
	
	}
	
	  public String multiFileValidation(String data, String[] readList, String replacement){
	  String newData = data;
	  for (String a: readList) {
	      newData = data.replace(a, replacement);
	      if (!newData.equals(data)) {
	          break;
	      }
	  }
	  return newData;
	}

}

























