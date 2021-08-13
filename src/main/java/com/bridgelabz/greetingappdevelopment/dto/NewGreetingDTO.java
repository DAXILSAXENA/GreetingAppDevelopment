package com.bridgelabz.greetingappdevelopment.dto;

import lombok.Data;

// @Data Annotation to avoid creation of getters and setters
@Data
public class NewGreetingDTO {

    private int id;
    private String message;

}
