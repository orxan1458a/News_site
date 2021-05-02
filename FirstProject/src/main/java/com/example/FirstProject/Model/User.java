package com.example.FirstProject.Model;

import com.example.FirstProject.Model.Enums.Role;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userName;
    private String password;
    private String confirmPassword;
    private String email;
    private String firstName;
    private String lastName;
    private String gender;
    @Enumerated(EnumType.STRING)
    private Role role;
}
