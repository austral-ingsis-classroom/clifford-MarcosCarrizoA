package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.archive.Component;
import edu.austral.ingsis.clifford.archive.Dir;
import edu.austral.ingsis.clifford.archive.File;
import edu.austral.ingsis.clifford.cli.Handler;

public class TouchCommand implements Command {
  @Override
  public String execute(String command) {
    Handler system = Handler.getInstance();
    Dir current = system.getCwd();
    current.getFiles().removeIf(file -> file.getName().equals(command) && !file.isComposite());
    current.addFile(new File(command, current));
    return "'" + command + "' file created";
  }
}
