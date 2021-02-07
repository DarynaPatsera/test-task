package com.agileengine.test.controller;

import com.agileengine.test.Image;
import com.agileengine.test.service.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@RestController
@RequestMapping(value = "/api/v1/images")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class ImageController {

    ImageService imageService;

    @GetMapping
    public ResponseEntity<List<Image>> findAll() {

        return ResponseEntity.ok(imageService.findAll());
    }

}
