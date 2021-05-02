package com.example.FirstProject.Service.Imp;

import com.example.FirstProject.Exception.NotFoundException;
import com.example.FirstProject.Model.Enums.Role;
import com.example.FirstProject.Model.Response;
import com.example.FirstProject.Model.Session;
import com.example.FirstProject.Model.User;
import com.example.FirstProject.Repository.UserRepository;
import com.example.FirstProject.Service.SessionService;
import com.example.FirstProject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService
{
    @Autowired
    UserRepository userRepository;
    @Autowired
    SessionService sessionService;

 //   @Override
//    public Response register(User user) {
//    User existed = userRepository.findByUserName(user.getUserName());
//    if(existed!=null)
//        return new Response(false,"UserName already exists");
//    if(!user.getPassword().equals(user.getConfirmPassword()))
//        return new Response(false,"Passwords not equal");
//      user.setRole(Role.User);
//      userRepository.save(user);
//      return new Response(true,"Success");
//
//
//    }

    @Override
    public User login(String userName, String password) {
        User user;

        try
        {
            user = userRepository.findByUserName(userName);
        }catch (Exception e){throw new NotFoundException("Zehmet olmasa login xanasini doldurun;");}
        if (user == null)
        {throw new NotFoundException("Bele login movcud deyil;");}


        System.out.println("yoxduuu");
        if(password.isEmpty())
        {
            System.out.println("Zehmet olmasa xanani doldur...");
            throw new NotFoundException("Zehmet olmasa xanani doldurun");
        }

        if (!password.equals(userRepository.findByUserName(userName).getPassword()))
        {  System.out.println("Parol sehfdi");
            throw new NotFoundException("Parol yanlishdir.");}
        Session session=sessionService.findActiveSession();
        if(session!=null)
            return session.getUser();
        else
        sessionService.create(user);
        return user;


    }

    @Override
    public void logout() {
        sessionService.update();
    }
}
