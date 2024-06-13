package edu.austral.ingsis.clifford.cli;

import edu.austral.ingsis.clifford.archive.Dir;
import edu.austral.ingsis.clifford.builder.CommandBuilder;

public class Handler {
  private static final Handler instance = new Handler();

  private final Dir root;
  private Dir cwd;
  private final CommandBuilder commandBuilder;

  private Handler() {
    this.root = new Dir("/", null);
    this.cwd = root;
    this.commandBuilder = new CommandBuilder();
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
    return commandBuilder.build(command);
  }
}
