package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.archive.Component;
import edu.austral.ingsis.clifford.archive.Dir;
import edu.austral.ingsis.clifford.cli.Handler;
import java.util.List;

public class CdCommand implements Command {
  @Override
  public String execute(String path) {
    Handler system = Handler.getInstance();
    Component current = system.getCwd();
    if (path.charAt(0) == '/') {
      current = system.getRoot();
    }
    String[] pathParts = path.split("/");
    for (String part : pathParts) {
      if (part.equals("..")) {
        if (current.getParent() != null) {
          current = current.getParent();
        }
      } else {
        List<Component> files = ((Dir) current).getFiles();
        boolean found = false;
        for (Component file : files) {
          if (file.getName().equals(part) && file.isComposite()) {
            current = file;
            found = true;
            break;
          }
        }
        if (!found) {
          return "'" + part + "' directory does not exist";
        }
      }
    }
    system.setCwd((Dir) current);
    return "moved to directory '" + current.getName() + "'";
  }
}
