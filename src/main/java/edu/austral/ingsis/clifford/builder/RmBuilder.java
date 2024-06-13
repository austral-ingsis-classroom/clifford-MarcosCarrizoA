package edu.austral.ingsis.clifford.builder;

import edu.austral.ingsis.clifford.cli.Handler;
import edu.austral.ingsis.clifford.commands.RmCommand;

public class RmBuilder implements Builder {
  @Override
  public String build(String command) {
    Handler system = Handler.getInstance();
    if (command.split(" ").length == 2) {
      return new RmCommand().execute(command.split(" ")[1]);
    } else if (command.split(" ").length == 3) {
      return new RmCommand().execute(command.split(" ")[1] + " " + command.split(" ")[2]);
    } else if (command.split(" ").length == 1) {
      return new RmCommand().execute("");
    }
    return "invalid parameters";
  }
}
