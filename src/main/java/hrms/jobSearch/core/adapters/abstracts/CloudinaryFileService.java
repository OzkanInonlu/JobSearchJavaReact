package hrms.jobSearch.core.adapters.abstracts;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import hrms.jobSearch.core.utilities.results.DataResult;

public interface CloudinaryFileService {
	
    DataResult<Map<String, String>> upload(MultipartFile multipartFile);
    DataResult<Map> delete(String id);

}
