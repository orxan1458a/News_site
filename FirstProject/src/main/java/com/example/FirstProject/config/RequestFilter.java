package com.example.FirstProject.config;

import com.example.FirstProject.Model.Enums.Role;
import com.example.FirstProject.Model.Enums.SessionStatus;
import com.example.FirstProject.Model.Session;
import com.example.FirstProject.Service.SessionService;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class RequestFilter implements Filter {

    private SessionService sessionService;

    RequestFilter(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        Session session = sessionService.findActiveSession();

        if (session == null)
            res.addHeader("status", SessionStatus.EXPIRE.name());
        else res.addHeader("status", session.getStatus().name());

        filterChain.doFilter(req, res);
    }
}