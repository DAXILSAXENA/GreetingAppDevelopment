/**
 * Ability for the Greeting App to find a Greeting Message by Id in the Repository
 *
 * @author DAXIL SAXENA
 * @since 08.08.2021
 */

package com.bridgelabz.greetingappdevelopment.controller;

import com.bridgelabz.greetingappdevelopment.dto.NewGreetingDTO;
import com.bridgelabz.greetingappdevelopment.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    @GetMapping(value = "/getGreetingDetails")
    public ResponseEntity<List<NewGreetingDTO>> getGreeting() {
        return new ResponseEntity<>(greetingService.getGreeting(), HttpStatus.OK);
    }

    @PostMapping(value = "/addGreetingDetails")
    public ResponseEntity<NewGreetingDTO> addGreeting(@RequestBody NewGreetingDTO newGreetingDTO) {
        return new ResponseEntity<>(greetingService.addGreeting(newGreetingDTO), HttpStatus.OK);
    }

    @GetMapping(value = "/getGreetingByID")
    public ResponseEntity<String> getEmployeeByID(@RequestParam(name = "id") int id) {
        return new ResponseEntity<>(greetingService.getEmployeeByID(id), HttpStatus.OK);
    }
}