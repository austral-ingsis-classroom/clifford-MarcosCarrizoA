package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.archive.Component;
import edu.austral.ingsis.clifford.archive.Dir;
import edu.austral.ingsis.clifford.cli.Handler;
import java.util.Comparator;
import java.util.stream.Collectors;

public class LsCommand implements Command {
  @Override
  public String execute(String command) {
    Handler system = Handler.getInstance();
    Dir cwd = system.getCwd();
    if (command.equals("--ord=asc")) {
      return cwd.getFiles().stream()
              .map(Component::getName)
              .sorted(Comparator.naturalOrder())
              .collect(Collectors.joining(" "));
    } else if (command.equals("--ord=desc")) {
      return cwd.getFiles().stream()
              .map(Component::getName)
              .sorted(Comparator.reverseOrder())
              .collect(Collectors.joining(" "));
    } else if (command.isEmpty()) {
      return cwd.getFiles().stream()
              .map(Component::getName)
              .collect(Collectors.joining(" "));
    }
    return "Command not found";
  }
}
