package com.exemple.media.controller;

import com.exemple.media.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.exemple.media.service.IVideoService;

@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private IVideoService iVideoService;

    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @PostMapping("/upload")
    public Video uploadVideo(@RequestPart("file") MultipartFile file, @RequestPart("video") Video video){
        return iVideoService.saveVideo(video, file);
    }
}
