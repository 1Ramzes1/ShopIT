package com.example.shop_it.services;

import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@Service
public class FirebaseService {
    private Storage storage = StorageOptions.getDefaultInstance().getService();

    public String save(MultipartFile multipartFile) throws Exception {
        String imageName = String.valueOf(System.currentTimeMillis());
        BlobId blobId = BlobId.of("javers-cb7ff.appspot.com", imageName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType(multipartFile.getContentType()).build();
        storage = StorageOptions.newBuilder()
                .setCredentials(ServiceAccountCredentials
                .fromStream(new FileInputStream("javers-cb7ff-firebase-adminsdk-z9ca7-c2f712c1c1.json"))).build().getService();
        storage.create(blobInfo, multipartFile.getInputStream());
        return imageName;
    }

    public String getUrl(String filename){
        return "https://firebasestorage.googleapis.com/v0/b/javers-cb7ff.appspot.com/o/"+filename+"?alt=media&token=756350a7-db05-42a1-b6fc-98adc5b4bb21";
    }
}
