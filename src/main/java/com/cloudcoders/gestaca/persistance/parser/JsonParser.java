package com.cloudcoders.gestaca.persistance.parser;

import com.google.gson.Gson;

public class JsonParser {

  private final Gson gson;

  public JsonParser(Gson gson) {
    this.gson = gson;
  }

  public <T> String toJson(T object) {
    return gson.toJson(object);
  }


  public <T extends Object> T toObject(String json, Class<T> objectClass) {
    return gson.fromJson(json, objectClass);
  }

}
