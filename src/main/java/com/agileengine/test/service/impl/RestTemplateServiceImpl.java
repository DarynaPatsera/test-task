package com.agileengine.test.service.impl;

import com.agileengine.test.Image;
import com.agileengine.test.service.AuthService;
import com.agileengine.test.service.RestTemplateService;
import com.agileengine.test.storage.TokenStorage;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RestTemplateServiceImpl implements RestTemplateService {

    TokenStorage tokenStorage;

    @Override
    public ResponseEntity<String> requestAuthData(String url, HttpEntity<?> httpEntity) {
        RestTemplate restTemplate = new RestTemplate();

        JSONObject body = new JSONObject();
        body.put("apiKey", "23567b218376f79d9415");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
    }

    @Override
    public ResponseEntity<String> requestData(String url) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(tokenStorage.getToken());

        HttpEntity<?> httpEntity = new HttpEntity<>(headers);

        return restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
    }
}
