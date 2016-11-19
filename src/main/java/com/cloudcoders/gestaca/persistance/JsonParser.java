package com.cloudcoders.gestaca.persistance;


import org.json.JSONArray;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonParser {

  public JSONArray readFile(ModelsEnum m) throws IOException {
    JSONArray a = null;
    switch(m) {
      case ABSENCE:
        String content = new String(Files.readAllBytes(Paths.get("Absence.json")));
        a = new JSONArray(content);
    }

    return a;
  }

}
