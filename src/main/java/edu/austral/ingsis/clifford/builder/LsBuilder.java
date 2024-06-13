package edu.austral.ingsis.clifford.builder;

import edu.austral.ingsis.clifford.commands.LsCommand;

public class LsBuilder implements Builder {
  @Override
  public String build(String command) {
    if (command.split(" ").length == 2) {
      return new LsCommand().execute(command.split(" ")[1]);
    } else if (command.split(" ").length == 1) {
      return new LsCommand().execute("");
    }
    return "invalid parameters";
  }
}
