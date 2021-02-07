package com.agileengine.test.service.impl;

import com.agileengine.test.service.AuthService;
import com.agileengine.test.service.RestTemplateService;
import com.agileengine.test.storage.TokenStorage;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthServiceImpl implements AuthService {

    final TokenStorage tokenStorage;

    @Value("${auth.apiKey}")
    String apiKey;

    @Value("${auth.api}")
    String url;

    final RestTemplateService restTemplateService;

    @EventListener({ContextRefreshedEvent.class})
    @Override
    public void auth() {
        JSONObject body = new JSONObject();
        body.put("apiKey", apiKey);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<?> httpEntity = new HttpEntity<Object>(body.toString(), headers);

        ResponseEntity<String> authResult = restTemplateService.requestAuthData(url, httpEntity);
        final JSONObject obj = new JSONObject(Objects.requireNonNull(authResult.getBody()));
        Object token = obj.get("token");

        tokenStorage.setToken(token.toString());
    }

}
