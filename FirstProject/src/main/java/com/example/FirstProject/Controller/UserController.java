package com.example.FirstProject.Controller;

import com.example.FirstProject.Model.Response;
import com.example.FirstProject.Model.User;
import com.example.FirstProject.Repository.UserRepository;
import com.example.FirstProject.Service.SessionService;
import com.example.FirstProject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//@RequestMapping(path = "/user")
@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    SessionService sessionService;
//    @PostMapping("/register")
//    public String register(Model model, @ModelAttribute User user)
//    {
//
//        Response response= userService.register(user);
//        if (response.isSuccess()) {
//            model.addAttribute("newUser", user);
//            System.out.println("Qeydiyyatdan ugurla kecirildi...");
//            return "registerSuccessful";
//        } else {
//            model.addAttribute("error", response.getMessage());
//            model.addAttribute("oldUser", user);
//            System.out.println("Qeydiyyat ugursuz alindi...");
//            return "registerFail";
//        }
//    }

    @PostMapping("/login")
    public String login(Model model,@RequestParam("username") String userName,@RequestParam("password") String password)
    {
        System.out.println("Admin Paneline daxil olundu");
        userService.login(userName,password);
        return "redirect:/homeAdmin";
    }
    @GetMapping("/logout")
    public String logout()
    {
        userService.logout();
        return "redirect:/home";
    }
}
