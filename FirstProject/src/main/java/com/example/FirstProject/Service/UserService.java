package com.example.FirstProject.Service;

import com.example.FirstProject.Model.Response;
import com.example.FirstProject.Model.User;

public interface UserService {
//    Response register(User user);
    User login(String userName,String password);
    void logout();
}
