package com.cloudcoders.gestaca.persistance;


import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDAL {

  public String readFile(String fileName) throws IOException, URISyntaxException {
    ClassLoader loader = getClass().getClassLoader();
    byte[] bytes = Files.readAllBytes(Paths.get(loader.getResource(fileName).toURI()));
    return new String(bytes);
  }

  public void writeFile(String fileName, String file) throws IOException, URISyntaxException {
    ClassLoader loader = getClass().getClassLoader();
    FileOutputStream fos = new FileOutputStream(Paths.get(loader.getResource(fileName).toURI()).toString());
    fos.write(file.getBytes());
    fos.close();
  }
}
