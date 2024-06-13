package edu.austral.ingsis.clifford.builder;

import edu.austral.ingsis.clifford.cli.Handler;
import edu.austral.ingsis.clifford.commands.CdCommand;

public class CommandBuilder {
  public String build(String command) {
    String commandId = command.split(" ")[0];
    switch (commandId) {
        case "cd":
            return new CdCommand().execute(command.split(" ")[1]);
        default:
            return "Command not found";
    }
  }
}
