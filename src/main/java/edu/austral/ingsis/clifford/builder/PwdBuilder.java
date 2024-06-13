package edu.austral.ingsis.clifford.builder;

import edu.austral.ingsis.clifford.commands.PwdCommand;

public class PwdBuilder implements Builder {
  @Override
  public String build(String command) {
    if (command.equals("pwd")) {
      return new PwdCommand().execute("");
    }
    return "invalid parameters";
  }
}
