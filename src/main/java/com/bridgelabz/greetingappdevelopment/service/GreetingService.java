package com.bridgelabz.greetingappdevelopment.service;

import com.bridgelabz.greetingappdevelopment.dto.NewGreetingDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GreetingService {

    private final List<NewGreetingDTO> greetingList = new ArrayList<>();
    private static final String template = "Hello, %s %s!";

    public String getMessage() {
        return "Hello World";
    }
    public String getGreeting(String fname, String lname) {
        return String.format(template, fname, lname);
    }

    public NewGreetingDTO addGreeting(NewGreetingDTO newGreetingDTO) {
        greetingList.add(newGreetingDTO);
        return newGreetingDTO;
    }

    public List<NewGreetingDTO> getGreeting() {
        return greetingList;
    }
}
