package com.cloudcoders.gestaca.persistance.dal;


import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDAL {

  public String readFile(String fileName) throws ReadFileException {
    ClassLoader loader = getClass().getClassLoader();
    byte[] bytes = new byte[0];
    try {
      bytes = Files.readAllBytes(Paths.get(loader.getResource(fileName).toURI()));
    } catch (IOException | URISyntaxException e) {
      e.printStackTrace();
      throw new ReadFileException(e);
    }
    return new String(bytes);
  }

  public void writeFile(String fileName, String body) throws WriteFileException {
    ClassLoader loader = getClass().getClassLoader();
    FileOutputStream fos = null;
    try {
      fos = new FileOutputStream(Paths.get(loader.getResource(fileName).toURI()).toString());
      fos.write(body.getBytes());
      fos.close();
    } catch (URISyntaxException | IOException e) {
      e.printStackTrace();
      throw new WriteFileException(e);
    }
  }
}
