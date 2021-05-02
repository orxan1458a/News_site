package com.example.FirstProject.Service;

import com.example.FirstProject.Model.Session;
import com.example.FirstProject.Model.User;

public interface SessionService {

    void create(User user);
    void update();
    Session findActiveSession();
}
