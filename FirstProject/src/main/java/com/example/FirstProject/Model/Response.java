package com.example.FirstProject.Model;

import lombok.Data;

@Data
public class Response {

    public Response(boolean isSuccess, String message) {
        this.isSuccess = isSuccess;
        this.message = message;
    }

    private boolean isSuccess;
    private String message;
}