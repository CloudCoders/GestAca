package com.cloudcoders.gestaca.persistance;


import org.json.JSONArray;
import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonParser {

  public JSONArray readFile(String fileName) throws IOException, URISyntaxException {
    JSONArray a = null;
    ClassLoader loader = getClass().getClassLoader();
    byte[] bytes = Files.readAllBytes(Paths.get(loader.getResource(fileName).toURI()));
    String content = new String(bytes);
    a = new JSONArray(content);
    return a;
  }

  public void writeFile(String fileName, JSONArray a) throws IOException, URISyntaxException {
    String file = a.toString();
    ClassLoader loader = getClass().getClassLoader();
    FileOutputStream fos = new FileOutputStream(Paths.get(loader.getResource(fileName).toURI()).toString());
    fos.write(file.getBytes());
    fos.close();
  }
}
