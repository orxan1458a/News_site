package com.example.FirstProject.Service;

import com.example.FirstProject.Model.Sharing;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface SharingService {
    void save(String title, MultipartFile image,String content,String url);
    List<Sharing> findAll();
    String stringSplit(String content);
}
