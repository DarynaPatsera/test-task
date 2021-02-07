package com.agileengine.test.service;

import java.util.List;

public interface ParserService<T> {

    List<T> parseCollection(String text, String valueToFind, Class<T> clazz);
}
