package com.agileengine.test.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

public interface RestTemplateService {

    ResponseEntity<String> requestAuthData(String url, HttpEntity<?> httpEntity);

    ResponseEntity<String> requestData(String url);
}
