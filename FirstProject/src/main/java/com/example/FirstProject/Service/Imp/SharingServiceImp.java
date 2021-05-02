package com.example.FirstProject.Service.Imp;

import com.example.FirstProject.Model.Sharing;
import com.example.FirstProject.Repository.SharingRepository;
import com.example.FirstProject.Service.SharingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class SharingServiceImp implements SharingService {
    @Autowired
    SharingRepository sharingRepository;

    @Override
    public void save(String title, MultipartFile image, String content, String url) {
    Sharing sharing=new Sharing();
        sharing.setTitle(title);
        try {
            sharing.setImage(Base64.getEncoder().encodeToString(image.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String shortContent =stringSplit(content);

        sharing.setContent(content);
        sharing.setShortContent(shortContent);
        sharing.setUrl(url);
        sharingRepository.save(sharing);
    }

    @Override
    public List<Sharing> findAll() {
        return sharingRepository.findAll();
    }

    @Override
    public String stringSplit(String content) {
        List<Character> list=new ArrayList<>();
        if(content.length()>150)
        {
            for(int i=0;i<150;i++)
            {

                list.add(content.charAt(i));
                //System.out.print( content.charAt(i));
            }
        }
        else for(int i=0;i<content.length();i++)
        {

            list.add(content.charAt(i));
            //System.out.print( content.charAt(i));
        }

        StringBuilder string=new StringBuilder();
        for(Character chr : list)
            string.append(chr);
        String result=string.toString();
        System.out.println(result);
        result=result+"[.]";
        return result;
    }

}
