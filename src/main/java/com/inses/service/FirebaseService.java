package com.inses.service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.inses.api.ImageResource;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;

@Service
public class FirebaseService {
    @Autowired
    ImageResource.Properties properties;
    @PostConstruct
    private void initialize() {
        try {
            FileInputStream serviceAccount = new FileInputStream("./serviceAccount.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://inses-73ab3-default-rtdb.firebaseio.com")
                    .setStorageBucket(properties.getBucketName())
                    .build();

            FirebaseApp.initializeApp(options);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Data
    @Configuration
    @ConfigurationProperties(prefix = "firebase")
    public class Properties {

        private String bucketName;

        private String imageUrl;
    }

}
