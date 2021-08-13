/**
 * Extend GreetingController to use Services Layer to get Simple Greeting message ”Hello World”
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

}