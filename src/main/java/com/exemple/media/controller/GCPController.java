package com.exemple.media.controller;

import com.exemple.media.model.Video;
import com.exemple.media.service.IVideoService;
import com.google.cloud.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/gcp")
public class GCPController {

    private final Storage storage;
    private IVideoService iVideoService;
    @Autowired
    public GCPController(IVideoService iVideoService,Storage storage){
        this.storage = storage;
        this.iVideoService = iVideoService;
    }


    public GCPController(Storage storage) {
        this.storage = storage;
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @PostMapping("/upload")
    public ResponseEntity<List<String>> uploadVideo(@RequestParam("file") MultipartFile[] files){
        List<String> list = new ArrayList<String>();
        System.out.println(files.length);
        for( MultipartFile file : files){
            Video savedVideo = iVideoService.saveVideo(file);
            list.add(savedVideo.getUrl());
        }
        return ResponseEntity.ok(list);

//        if(saveVideo != null){
//            return ResponseEntity.ok(saveVideo.getUrl());
//        }else {
//            return ResponseEntity.status(500).build();
//        }
    }

    @GetMapping("/display")
    public String display(Model model){
        model.addAttribute("videoUrl", "https://storage.googleapis.com/nhom14landscape/landscape1.mp4");
        return "display";
    }

    @GetMapping("/get-all")
    @ResponseBody
    public List<Video> getAllVideo(){
        return iVideoService.getAllVideo();
    }

    @GetMapping("/get-videos")
    @ResponseBody
    public Page<Video> getVideos(@RequestParam int page, @RequestParam int size){
        Pageable pageable = PageRequest.of(page, size);
        return iVideoService.getVideoPage(pageable);
    }
}
