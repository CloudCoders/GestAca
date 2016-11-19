package com.cloudcoders.gestaca.persistance;


import org.json.JSONArray;
import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonParser {

  public JSONArray readFile(String s) throws IOException, URISyntaxException {
    JSONArray a = null;
    ClassLoader loader = getClass().getClassLoader();
    String content = new String(Files.readAllBytes(Paths.get(loader.getResource(s).toURI())));
    a = new JSONArray(content);
    return a;
  }

  public void writeFile(String s, JSONArray a) throws IOException, URISyntaxException {
    String file = a.toString();
    ClassLoader loader = getClass().getClassLoader();
    FileOutputStream fos = new FileOutputStream(Paths.get(loader.getResource(s).toURI()).toString());
    fos.write(file.getBytes());
    fos.close();
  }
}
