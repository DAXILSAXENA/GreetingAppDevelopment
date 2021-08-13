/**
 * Ability for the Greeting App to give Greeting message with
 * 1. User First Name and Last Name
 * 2. With just First Name or Last Name based on User attributes provided
 * 3. Just Hello World.
 *
 * @author DAXIL SAXENA
 * @since 08.08.2021
 */

package com.bridgelabz.greetingappdevelopment.controller;

import com.bridgelabz.greetingappdevelopment.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class NewGreetingController {

    // Creating object for GreetingService class
    @Autowired
    private GreetingService greetingService;

    @GetMapping(value = "/getMessage")
    public ResponseEntity<String> getMessage() {
        return new ResponseEntity<>(greetingService.getMessage(), HttpStatus.OK);
    }

    @GetMapping(value = "/getGreetingMessage")
    public ResponseEntity<String> greeting(@RequestParam(value = "fname", defaultValue = "World") String fname,
                                           @RequestParam(value = "lname", defaultValue = "") String lname) {
        return new ResponseEntity<>(greetingService.getGreeting(fname, lname), HttpStatus.OK);
    }
}