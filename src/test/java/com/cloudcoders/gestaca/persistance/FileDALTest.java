package com.cloudcoders.gestaca.persistance;

import com.cloudcoders.gestaca.model.Course;
import com.cloudcoders.gestaca.persistance.dal.FileDAL;
import com.cloudcoders.gestaca.persistance.dal.ReadFileException;
import com.cloudcoders.gestaca.persistance.dal.WriteFileException;
import com.cloudcoders.gestaca.persistance.parser.JsonParser;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class FileDALTest {

  private FileDAL fileDAL;
  private JsonParser jsonParser;

  @Before
  public void setup() {
    this.fileDAL = new FileDAL();
    this.jsonParser = new JsonParser(new Gson());
  }

  @Test
  public void should_write_and_read_file() {
    String body = jsonParser.toJson(new Course("Prueba", "Prueba", 0));

    try {
      fileDAL.writeFile("Course.json", body);
    } catch (WriteFileException e) {
      e.printStackTrace();
    }

    String result = null;
    try {
      result = fileDAL.readFile("Course.json");
    } catch (ReadFileException e) {
      e.printStackTrace();
    }

    assertThat(body, is(result));
  }

}