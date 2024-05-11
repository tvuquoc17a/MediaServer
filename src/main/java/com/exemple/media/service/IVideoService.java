package com.exemple.media.service;

import com.exemple.media.model.Video;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IVideoService {



    public Video getVideo(long id);

    public Video saveVideo(Video video ,MultipartFile file);

    public List<Video> getAllVideo();


}
