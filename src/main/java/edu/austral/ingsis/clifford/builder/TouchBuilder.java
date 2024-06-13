package edu.austral.ingsis.clifford.builder;

import edu.austral.ingsis.clifford.commands.TouchCommand;

public class TouchBuilder implements Builder {
  @Override
  public String build(String command) {
    if (command.split(" ").length == 2) {
      return new TouchCommand().execute(command.split(" ")[1]);
    }
    return "invalid parameters";
  }
}
