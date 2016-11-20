package com.cloudcoders.gestaca.persistance;

import com.cloudcoders.gestaca.persistance.dal.FileDAL;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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

//    resArr = parser.readFile("Course.json");

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


//    parser.writeFile("Course.json", arr);

    JSONArray res = null;
//    res = parser.readFile("Course.json");

    JSONObject actual = res.getJSONObject(res.length()-1);
    assertEquals(actual.get("description"), aux.get("description"));
    assertEquals(actual.get("name"), aux.get("name"));
    assertEquals(actual.get("id"), aux.get("id"));

  }

}