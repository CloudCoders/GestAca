package com.cloudcoders.gestaca.persistance;


import org.json.JSONArray;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonParser {

  public JSONArray readFile(String s) throws IOException {
    JSONArray a = null;
    String content = new String(Files.readAllBytes(Paths.get(s)));
    a = new JSONArray(content);
    return a;
  }

  public void writeFile(String s, JSONArray a) throws IOException {
    String file = a.toString();
    FileOutputStream fos = new FileOutputStream(s);
    fos.write(file.getBytes());
    fos.close();
  }
}
