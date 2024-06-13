package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.archive.Dir;
import edu.austral.ingsis.clifford.cli.Handler;

public class PwdCommand implements Command {
  @Override
  public String execute(String command) {
    Handler system = Handler.getInstance();
    Dir current = system.getCwd();
    if (current.getName().equals("/")) {
      return "/";
    } else {
      StringBuilder result = new StringBuilder();
      while (!current.getName().equals("/")) {
        result.insert(0, "/" + current.getName());
        current = (Dir) current.getParent();
      }
      return result.toString();
    }
  }
}
