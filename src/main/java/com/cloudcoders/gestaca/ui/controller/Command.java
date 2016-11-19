package com.cloudcoders.gestaca.ui.controller;

public interface Command {

  boolean matches(String cmd);
  void execute();
}
