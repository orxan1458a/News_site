package com.example.FirstProject.Controller;

import com.example.FirstProject.Model.Sharing;
import com.example.FirstProject.Model.User;
import com.example.FirstProject.Service.SessionService;
import com.example.FirstProject.Service.SharingService;
import com.example.FirstProject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class PageController {
 @Autowired
    UserService userService;
 @Autowired
    SessionService sessionService;
 @Autowired
    SharingService sharingService;
//    @GetMapping(value="/register")
//    public String registerForm(Model model)
//    {
//        System.out.println("salam");
//        model.addAttribute("user", new User());
//        System.out.println(model);
//        return "register";
//    }
    @GetMapping("/login")
    public String login()
    {
        return "login";
    }
    @GetMapping("/social")
    public String social()
    {
        return "social";
    }

    @GetMapping("/home")
    public String home(Model model)
    {
        List<Sharing> sharings=sharingService.findAll();
        model.addAttribute("sharings",sharings);
        System.out.println("SEKILLER CAP OLUNDU");
        return "/home";
    }

    @GetMapping("/sharingCreate")
    public String sharingCreate()
    {

        return "sharingCreate";
    }
    @GetMapping("/homeAdmin")
    public String homeAdmin(Model model)
    {
        List<Sharing> sharings=sharingService.findAll();
        model.addAttribute("sharings",sharings);
        System.out.println("SEKILLER CAP OLUNDU");

        return "homeAdmin";
    }





}
