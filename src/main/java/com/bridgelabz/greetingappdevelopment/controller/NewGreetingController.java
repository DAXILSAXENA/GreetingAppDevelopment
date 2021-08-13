/**
 * Ability for the Greeting App to delete a Greeting Messages in the Repository
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

    // Ability to return message using GET method
    @GetMapping(value = "/getMessage")
    public ResponseEntity<String> getMessage() {
        return new ResponseEntity<>(greetingService.getMessage(), HttpStatus.OK);
    }

    // Ability to return message using GET method
    @GetMapping(value = "/getGreetingMessage")
    public ResponseEntity<String> greeting(@RequestParam(value = "fname", defaultValue = "World") String fname,
                                           @RequestParam(value = "lname", defaultValue = "") String lname) {
        return new ResponseEntity<>(greetingService.getGreeting(fname, lname), HttpStatus.OK);
    }

    // Ability to display List using GET method
    @GetMapping(value = "/getGreetingDetails")
    public ResponseEntity<List<NewGreetingDTO>> getGreeting() {
        return new ResponseEntity<>(greetingService.getGreeting(), HttpStatus.OK);
    }

    // Ability to store multiple Greeting Message using POST method
    @PostMapping(value = "/addGreetingDetails")
    public ResponseEntity<NewGreetingDTO> addGreeting(@RequestBody NewGreetingDTO newGreetingDTO) {
        return new ResponseEntity<>(greetingService.addGreeting(newGreetingDTO), HttpStatus.OK);
    }

    // Ability to return message using GET method by passing ID
    @GetMapping(value = "/getGreetingByID")
    public ResponseEntity<String> getEmployeeByID(@RequestParam(name = "id") int id) {
        return new ResponseEntity<>(greetingService.getEmployeeByID(id), HttpStatus.OK);
    }

    // Ability to update message using POST method
    @PutMapping(value = "/updateGreeting")
    public ResponseEntity<NewGreetingDTO> updateGreeting(@RequestParam(name = "id") int id,
                                                      @RequestParam(name = "message") String message) {
        return new ResponseEntity<>(greetingService.updateGreeting(id, message), HttpStatus.OK);
    }

    // Ability to delete message using DELETE method
    @DeleteMapping(value = "/deleteGreeting")
    public ResponseEntity<String> deleteGreeting(@RequestParam(name = "id") int id) {
        return new ResponseEntity<>(greetingService.deleteGreeting(id), HttpStatus.OK);
    }
}