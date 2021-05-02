package com.example.FirstProject.Service.Imp;

import com.example.FirstProject.Model.Enums.SessionStatus;
import com.example.FirstProject.Model.Session;
import com.example.FirstProject.Model.User;
import com.example.FirstProject.Repository.SessionRepository;
import com.example.FirstProject.Service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class SessionServiceImp implements SessionService {
    @Autowired
    SessionRepository sessionRepository;


    @Override
    public void create(User user) {
    Session session=Session
            .builder()
            .sessionId(UUID.randomUUID().toString())
            .startTime(LocalDateTime.now())
            .user(user)
            .status(SessionStatus.ACTIVE)
            .build();
    sessionRepository.save(session);
    }

    @Override
    public void update() {
        Session session=findActiveSession();
        session.setEndTime(LocalDateTime.now());
        session.setStatus(SessionStatus.EXPIRE);
        sessionRepository.save(session);


    }

    @Override
    public Session findActiveSession() {
       return sessionRepository.findByStatus(SessionStatus.ACTIVE);
    }

}
