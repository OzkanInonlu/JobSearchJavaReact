package hrms.jobSearch.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;

@Configuration
public class CloudinaryConfig {
	
    @Bean
    public Cloudinary cloudinary() {
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "dt2neegbd");
        config.put("api_key","415351662957737");
        config.put("api_secret", "Hl_BHoMm3WVe4OIcYA2k3ZBoCI8");
        return new Cloudinary(config);
    }

}
