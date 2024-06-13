package edu.austral.ingsis.clifford.builder;

import edu.austral.ingsis.clifford.commands.CdCommand;

public class CdBuilder implements Builder {
  @Override
  public String build(String command) {
    if (command.split(" ").length == 2) {
      return new CdCommand().execute(command.split(" ")[1]);
    }
    return "invalid parameters";
  }
}
