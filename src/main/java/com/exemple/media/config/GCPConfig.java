package com.exemple.media.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class GCPConfig {

    @Bean
    public Storage storage() throws IOException {
        GoogleCredentials credentials = GoogleCredentials.fromStream(
                new FileInputStream("D:\\Media\\MediaServer\\MediaServer\\src\\main\\resources\\able-coast-422816-v5-f9e9bb73f656.json")
        );
        return StorageOptions.newBuilder().setCredentials(credentials).build().getService();
    }
}
