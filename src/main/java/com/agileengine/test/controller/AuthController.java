package com.agileengine.test.controller;

import com.agileengine.test.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static lombok.AccessLevel.PRIVATE;

@RestController
@RequestMapping(value = "/api/v1/auth")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class AuthController {

    AuthService authService;

    @GetMapping
    public ResponseEntity<Void> find() {
        authService.auth();
        return ResponseEntity.noContent().build();
    }
}
