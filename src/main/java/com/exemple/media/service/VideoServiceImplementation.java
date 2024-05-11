package com.exemple.media.service;

import com.exemple.media.model.Video;
import com.google.cloud.storage.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.exemple.media.repository.VideoRepository;

import java.io.IOException;
import java.util.List;

@Service
public class VideoServiceImplementation implements IVideoService {

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private Storage storage;


    @Override
    public Video getVideo(long id) {
        return videoRepository.findById(id).orElse(null);
    }

    @Override
    public Video saveVideo(Video video, MultipartFile file) {
        try {
            String bucketName = "nhom14landscape";
            BlobInfo blobInfo = BlobInfo.newBuilder(bucketName, file.getOriginalFilename()).build();
            Blob blob = storage.create(blobInfo, file.getBytes());

            BlobId blobId = BlobId.of(bucketName, file.getOriginalFilename());
            storage.createAcl(blobId, Acl.of(Acl.User.ofAllUsers(), Acl.Role.READER));

            video.setUrl(blob.getMediaLink());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return videoRepository.save(video);
    }

    @Override
    public List<Video> getAllVideo() {
        return videoRepository.findAll();
    }
}
