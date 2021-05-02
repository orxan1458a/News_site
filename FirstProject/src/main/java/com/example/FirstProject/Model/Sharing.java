package com.example.FirstProject.Model;

import com.example.FirstProject.Model.Enums.SessionStatus;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Sharing {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        @NotNull
        private String title;
        @Lob
        @Column(columnDefinition = "MEDIUMBLOB")
        private String image;
        private String content;
        private String shortContent;
        private String url;


}
