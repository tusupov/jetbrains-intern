package com.jetbrains.intern.controller;

import com.jetbrains.intern.model.Zodiac;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZodiacController {

    @RequestMapping("/zodiac/{month}/{day}")
    public ResponseEntity<?> getZodiac(@PathVariable("month") int month, @PathVariable("day") int day) {
        Zodiac zodiac = new Zodiac(month, day);
        return new ResponseEntity<>(zodiac, HttpStatus.OK);
    }

    @ExceptionHandler
    public ResponseEntity<String> getZodiacExceptionHandler(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
