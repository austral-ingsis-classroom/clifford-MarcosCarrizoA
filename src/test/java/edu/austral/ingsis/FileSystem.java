package edu.austral.ingsis;

import edu.austral.ingsis.clifford.cli.Handler;
import java.util.ArrayList;
import java.util.List;

public class FileSystem implements FileSystemRunner {
  @Override
  public List<String> executeCommands(List<String> commands) {
    Handler system = Handler.getInstance();
    system.clean();
    List<String> result = new ArrayList<>();
    for (String command : commands) {
      result.add(system.runCommand(command));
    }
    return result;
  }
}
