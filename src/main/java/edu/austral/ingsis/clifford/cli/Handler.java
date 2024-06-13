package edu.austral.ingsis.clifford.cli;

import edu.austral.ingsis.clifford.archive.Dir;
import edu.austral.ingsis.clifford.builder.Builder;
import edu.austral.ingsis.clifford.builder.CdBuilder;
import edu.austral.ingsis.clifford.builder.LsBuilder;
import edu.austral.ingsis.clifford.builder.MkDirBuilder;
import edu.austral.ingsis.clifford.builder.PwdBuilder;
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

  private Map<String, Builder> getCommandBuilderMap() {
    return Map.of(
            "cd", new CdBuilder(),
            "ls", new LsBuilder(),
            "mkdir", new MkDirBuilder(),
            "pwd", new PwdBuilder());
  }

  public static Handler getInstance() {
    return instance;
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

  public String runCommand(String command) {
    if (commandBuilder.get(command.split(" ")[0]) == null) { return "Command not found"; }
    return commandBuilder.get(command.split(" ")[0]).build(command);
  }
}
