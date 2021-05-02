package com.example.FirstProject.Controller;

import com.example.FirstProject.Model.Sharing;
import com.example.FirstProject.Service.SharingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class SharingController {
    @Autowired
    SharingService sharingService;
    @PostMapping("/sharingCreate")
    public String sharingCreate(@RequestParam("title")String title,
                                @RequestParam("file")MultipartFile image,
                                @RequestParam("content")String content,
                                @RequestParam("url")String url)
    {
        System.out.println("SHARING CREATED");
        sharingService.save(title,image,content,url);
        return "homeAdmin";
    }

}
