package com.geektext.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/credit-cards")
public class CreditCardController {
    @Autowired
    private CreditCardService creditCardService;

    @PostMapping
    public ResponseEntity<String> createCreditCard(
        @RequestParam String username,
        @RequestBody CreditCard creditCard
    ) {
        boolean isCardCreated = creditCardService.createCreditCard(username, creditCard);

        if (isCardCreated) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Credit card created successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with username: " + username);
        }
    }
}

