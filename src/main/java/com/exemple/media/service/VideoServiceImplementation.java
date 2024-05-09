package com.exemple.media.service;

import com.exemple.media.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.exemple.media.repository.VideoRepository;

import java.io.IOException;

@Service
public class VideoServiceImplementation implements IVideoService {

    @Autowired
    private VideoRepository videoRepository;


    @Override
    public Video getVideo(long id) {
        return videoRepository.findById(id).orElse(null);
    }

    @Override
    public Video saveVideo(Video video, MultipartFile file) {
        try {
            video.setData(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return videoRepository.save(video);
    }
}
