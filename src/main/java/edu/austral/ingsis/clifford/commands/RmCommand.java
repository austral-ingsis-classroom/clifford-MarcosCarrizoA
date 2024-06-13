package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.archive.Component;
import edu.austral.ingsis.clifford.archive.Dir;
import edu.austral.ingsis.clifford.cli.Handler;

public class RmCommand implements Command {
  @Override
  public String execute(String command) {
    Handler system = Handler.getInstance();
    Dir current = system.getCwd();
    String[] commandParts = command.split(" ");
    if (command.isEmpty()) {
      return removeFile(current, current.getFiles().getFirst().getName());
    } else if (commandParts.length == 1) {
      return removeFile(current, commandParts[0]);
    } else if (commandParts.length == 2 && commandParts[0].equals("--recursive")) {
      return removeDirectoryRecursively(current, commandParts[1]);
    } else {
      return "invalid command";
    }
  }

  private String removeFile(Dir current, String fileName) {
    for (Component dir : current.getFiles()) {
      if (dir.getName().equals(fileName)) {
        if (dir.isComposite()) {
          return "cannot remove '" + fileName + "', is a directory";
        }
        current.getFiles().remove(dir);
        return "'" + fileName + "' removed";
      }
    }
    return "no file found with that name";
  }

  private String removeDirectoryRecursively(Dir current, String dirName) {
    for (Component dir : current.getFiles()) {
      if (dir.getName().equals(dirName) && dir.isComposite()) {
        deleteRecursively((Dir) dir);
        current.getFiles().remove(dir);
        return "'" + dirName + "' removed";
      }
    }
    return "no directory found with that name";
  }

  private void deleteRecursively(Dir dir) {
    for (Component component : dir.getFiles()) {
      if (component.isComposite()) {
        deleteRecursively((Dir) component);
      }
    }
    dir.getFiles().clear();
  }
}
