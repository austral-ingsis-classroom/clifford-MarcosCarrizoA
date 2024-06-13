package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.archive.Component;
import edu.austral.ingsis.clifford.archive.Dir;
import edu.austral.ingsis.clifford.cli.Handler;

public class MkDirCommand implements Command {
  @Override
  public String execute(String command) {
    Handler system = Handler.getInstance();
    Dir current = system.getCwd();
    for (Component elements : current.getFiles()) {
      if (elements.getName().equals(command) && elements.isComposite()) {
        return "directory already exists";
      }
    }
    current.addFile(new Dir(command, current));
    return "'" + command + "' directory created";
  }
}
