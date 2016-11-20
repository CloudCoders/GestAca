package com.cloudcoders.gestaca.persistance;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.Assert.*;

public class FileDALTest {

  @Test
  public void shouldReadFile() {
    FileDAL parser = new FileDAL();
    JSONArray resArr = null;
    JSONObject res = null;

    JSONObject aux = new JSONObject();
    aux.put("description", "Prueba1");
    aux.put("name", "Prueba1");
    aux.put("id", 1);

    try {
      resArr = parser.readFile("Course.json");
      res = resArr.getJSONObject(0);
    } catch (IOException e) {
      e.printStackTrace();
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }

    assertEquals(res.get("description"), aux.get("description"));
    assertEquals(res.get("name"), aux.get("name"));
    assertEquals(res.get("id"), aux.get("id"));


  }

  @Test
  public void shouldWriteFile() {
    FileDAL parser = new FileDAL();

    JSONArray arr = new JSONArray();
    JSONObject aux = new JSONObject();
    aux.put("description", "Prueba1");
    aux.put("name", "Prueba1");
    aux.put("id", 1);
    arr.put(aux);


    try {
      parser.writeFile("Course.json", arr);
    } catch (IOException e) {
      e.printStackTrace();
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }

    JSONArray res = null;
    try {
      res = parser.readFile("Course.json");
    } catch (IOException e) {
      e.printStackTrace();
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }

    JSONObject actual = res.getJSONObject(res.length()-1);
    assertEquals(actual.get("description"), aux.get("description"));
    assertEquals(actual.get("name"), aux.get("name"));
    assertEquals(actual.get("id"), aux.get("id"));

  }

}