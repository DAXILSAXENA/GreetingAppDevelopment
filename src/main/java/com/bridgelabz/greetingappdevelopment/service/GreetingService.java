package com.bridgelabz.greetingappdevelopment.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    private static final String template = "Hello, %s %s!";

    public String getMessage() {
        return "Hello World";
    }
    public String getGreeting(String fname, String lname) {
        return String.format(template, fname, lname);
    }

}
