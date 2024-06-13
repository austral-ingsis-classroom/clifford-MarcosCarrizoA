package edu.austral.ingsis.clifford.builder;

import edu.austral.ingsis.clifford.commands.CdCommand;
import edu.austral.ingsis.clifford.commands.LsCommand;
import edu.austral.ingsis.clifford.commands.MkDirCommand;
import edu.austral.ingsis.clifford.commands.PwdCommand;

public class CommandBuilder {
  public String build(String command) {
    String commandId = command.split(" ")[0];
    return switch (commandId) {
      case "cd" -> new CdCommand().execute(command.split(" ")[1]);
      case "ls" ->
          new LsCommand().execute(command.split(" ").length > 1 ? command.split(" ")[1] : "");
      case "mkdir" -> new MkDirCommand().execute(command.split(" ")[1]);
      case "pwd" -> new PwdCommand().execute(command);
      default -> "Command not found";
    };
  }
}
