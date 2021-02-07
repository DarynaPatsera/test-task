package com.agileengine.test.service.impl;

import com.agileengine.test.service.ParserService;
import com.google.gson.Gson;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ParserServiceImpl<T> implements ParserService<T> {

    Gson gson;

    @Override
    public List<T> parseCollection(String text, String valueToFind, Class<T> clazz) {
        List<T> feedDataList = new ArrayList<>();


        JSONArray array = new JSONObject(text).getJSONArray(valueToFind);
        array.forEach(arr -> feedDataList.add(convertToFeedData((JSONObject) arr, clazz)));

        return feedDataList;
    }


    private T convertToFeedData(JSONObject node, Class<T> clazz) {
        return gson.fromJson(String.valueOf(node), clazz);
    }

}
