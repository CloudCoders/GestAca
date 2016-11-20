package com.cloudcoders.gestaca.persistance.parser;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonParser {

  private final Gson gson;

  public JsonParser(Gson gson) {
    this.gson = gson;
  }

  public <T> String toJson(T object) {
    return gson.toJson(object);
  }

  public <T> T toObject(String json, Class<T> objectClass) {
    return gson.fromJson(json, objectClass);
  }

  public <T> List<T> toObjectList(String json, Class<T[]> objectClass) {
    T[] array = gson.fromJson(json, objectClass);
    return new ArrayList<T>(Arrays.asList(array));
  }
}
