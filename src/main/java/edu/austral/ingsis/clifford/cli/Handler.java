package edu.austral.ingsis.clifford.cli;

import edu.austral.ingsis.clifford.archive.Dir;
import edu.austral.ingsis.clifford.builder.*;
import java.util.Map;

public class Handler {
  private static final Handler instance = new Handler();

  private final Dir root;
  private Dir cwd;
  private final Map<String, Builder> commandBuilder;

  private Handler() {
    this.root = new Dir("/", null);
    this.cwd = root;
    this.commandBuilder = getCommandBuilderMap();
  }

  public static Handler getInstance() {
    return instance;
  }

  private Map<String, Builder> getCommandBuilderMap() {
    return Map.of(
        "cd",
        new CdBuilder(),
        "ls",
        new LsBuilder(),
        "mkdir",
        new MkDirBuilder(),
        "pwd",
        new PwdBuilder(),
        "touch",
        new TouchBuilder(),
        "rm",
        new RmBuilder());
  }

  public Dir getRoot() {
    return root;
  }

  public Dir getCwd() {
    return cwd;
  }

  public void setCwd(Dir cwd) {
    this.cwd = cwd;
  }

  public void clean() {
    root.getFiles().clear();
    cwd = root;
  }

  public String runCommand(String command) {
    if (commandBuilder.get(command.split(" ")[0]) == null) {
      return "Command not found";
    }
    return commandBuilder.get(command.split(" ")[0]).build(command);
  }
}
