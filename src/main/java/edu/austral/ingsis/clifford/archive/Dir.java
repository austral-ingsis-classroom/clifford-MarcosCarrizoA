package edu.austral.ingsis.clifford.archive;

import java.util.ArrayList;
import java.util.List;

public class Dir implements Component {
  private final String name;
  private final Dir parent;
  private final List<Component> files;

  public Dir(String name, Dir parent) {
    this.name = name;
    this.parent = parent;
    this.files = new ArrayList<>();
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public Component getParent() {
    return parent;
  }

  @Override
  public boolean isComposite() {
    return true;
  }

  public void addFile(Component component) {
    files.add(component);
  }

  public void removeFile(String name) {
    for (Component file : files) {
      if (file.getName().equals(name)) {
        files.remove(file);
        break;
      }
    }
  }

  public Component getFile(String name) {
    for (Component file : files) {
      if (file.getName().equals(name)) {
        return file;
      }
    }
    return null;
  }

  public List<Component> getFiles() {
    return files;
  }
}
