package com.ra.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {
    @Value("${cloudinary_name}")
    private String CLOUDINARY_NAME;
    @Value("${cloudinary_api_key}")
    private String CLOUDINARY_API_KEY;
    @Value("${cloudinary_api_secret}")
    private String CLOUDINARY_API_SECRET;

    @Bean
    public Cloudinary cloudinary() {
       return new Cloudinary(ObjectUtils.asMap(
               "cloud_name",CLOUDINARY_NAME,
               "api_key",CLOUDINARY_API_KEY,
               "api_secret",CLOUDINARY_API_SECRET
       ));
    }
}
