package com.example.FirstProject.Repository;

import com.example.FirstProject.Model.Enums.SessionStatus;
import com.example.FirstProject.Model.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session,Long> {
Session findByStatus(SessionStatus status);
}
