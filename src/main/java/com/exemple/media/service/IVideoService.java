package com.exemple.media.service;

import com.exemple.media.model.Video;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.data.domain.Page;

import java.util.List;

import java.util.List;

public interface IVideoService {



    public Video getVideo(long id);

    public Video saveVideo(MultipartFile file);

    public List<Video> getAllVideo();

    public List<Video> getAllVideo();




    Page<Video> getVideoPage(Pageable pageable);
}
