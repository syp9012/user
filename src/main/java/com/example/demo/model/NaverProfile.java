package com.example.demo.model;

import lombok.Data;
@Data
public class NaverProfile {
    private String resultcode;
    private String message;
    private Response response;

    @Data
    public static class Response {
        private String email;
        private String nickname;
        private String profile_image;
        private String age;
        private String gender;
        private String id;
        private String name;
        private String birthday;
        private String birthyear;
        private String mobile;
    }

}