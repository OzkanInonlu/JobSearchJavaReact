package hrms.jobSearch.core.adapters.concretes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import hrms.jobSearch.core.adapters.abstracts.CloudinaryFileService;
import hrms.jobSearch.core.utilities.results.DataResult;
import hrms.jobSearch.core.utilities.results.ErrorDataResult;
import hrms.jobSearch.core.utilities.results.SuccessDataResult;
import java.util.*;

@Service
//@Configuration
public class CloudinaryFileAdapter implements CloudinaryFileService{
	
	@Autowired
	private Cloudinary cloudinary;

	@Override
	public DataResult<Map<String, String>> upload(MultipartFile multipartFile) {
		// TODO Auto-generated method stub
        File file;
        try {
            file = convert(multipartFile);
            Map<String, String> result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
            file.delete();
            return new SuccessDataResult<Map<String,String>>(result, "File is uploaded");
        } catch (IOException e) {
            e.printStackTrace();
            return new ErrorDataResult<Map<String,String>>("File could not be uploaded");
        }
	}

	@Override
	public DataResult<Map> delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
    private static File convert(MultipartFile multipartFile) throws IOException {
        File file = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        FileOutputStream stream = new FileOutputStream(file);
        stream.write(multipartFile.getBytes());
        stream.close();

        return file;
    }

}
