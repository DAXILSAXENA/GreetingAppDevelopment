package com.bridgelabz.greetingappdevelopment.service;

import com.bridgelabz.greetingappdevelopment.dto.NewGreetingDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

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

    // Ability to display the greetingList
    public List<NewGreetingDTO> getGreeting() {
        return greetingList;
    }

    public String getEmployeeByID(int id) {
        AtomicReference<String> greetings = new AtomicReference<>();
        greetingList.stream()
                .filter(greetingElement -> greetingElement.getId() == id)
                .forEach(greetingElement -> {
                    greetings.set(greetingElement.getMessage());
                });
        return String.valueOf(greetings);

    }

    public NewGreetingDTO updateGreeting(int id, String message) {
        NewGreetingDTO greetingDTO = findEmployeeById(id);
        greetingDTO.setMessage(message);
        return greetingDTO;
    }

    private NewGreetingDTO findEmployeeById(int id) {
        return greetingList.stream()
                .filter(greetingElement -> greetingElement.getId() == id).findFirst()
                .orElseThrow(() -> new RuntimeException("Unable to find any greeting"));
    }

    public String deleteGreeting(int id) {
        NewGreetingDTO greetingDTO = findEmployeeById(id);
        greetingList.remove(greetingDTO);
        return "Greeting deleted successfully";
    }
}
