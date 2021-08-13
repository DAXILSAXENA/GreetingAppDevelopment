/**
 * Using GreetingController return JSON for different HTTP Methods.
 *
 * @author DAXIL SAXENA
 * @since 08.08.2021
 */

package com.bridgelabz.greetingappdevelopment.controller;

import java.util.concurrent.atomic.AtomicLong;

import com.bridgelabz.greetingappdevelopment.dto.GreetingDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    // Ability to return JSON data using GET method
    @GetMapping("/getGreeting")
    public GreetingDTO greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new GreetingDTO(counter.incrementAndGet(), String.format(template, name));
    }

    // Purpose : Ability to return JSON data using POST method
    @PostMapping("/postGreeting")
    public GreetingDTO sayHello(@RequestBody GreetingDTO greetingDTO) {
        return new GreetingDTO(counter.incrementAndGet(), String.format(template, greetingDTO.getContent()));
    }

    // Purpose : Ability to return JSON data using PUT method
    @PutMapping("/putGreeting/{counter}")
    public GreetingDTO sayHello(@PathVariable int counter, @RequestParam(value = "content") String contentName) {
        return new GreetingDTO(counter, String.format(template, contentName));
    }

}