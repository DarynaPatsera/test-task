package com.agileengine.test.service.impl;

import com.agileengine.test.Image;
import com.agileengine.test.service.ImageService;
import com.agileengine.test.service.ParserService;
import com.agileengine.test.service.RestTemplateService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ImageServiceImpl implements ImageService {

    @Value("${image.api}")
    String imageApi;

    final ParserService<Image> parserService;

    final RestTemplateService restTemplateService;

    @Override
    public List<Image> findAll() {
        return parserService.parseCollection(
                restTemplateService.requestData(imageApi).getBody(), "pictures", Image.class
        );
    }
}
