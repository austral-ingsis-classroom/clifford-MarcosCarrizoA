package edu.austral.ingsis.clifford.builder;

import edu.austral.ingsis.clifford.commands.MkDirCommand;

public class MkDirBuilder implements Builder {
  @Override
  public String build(String command) {
    if (command.split(" ").length == 2) {
      return new MkDirCommand().execute(command.split(" ")[1]);
    }
    return "invalid parameters";
  }
}
