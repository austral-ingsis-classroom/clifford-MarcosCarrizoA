package edu.austral.ingsis.clifford.archive;

public interface Component {
  String getName();

  Component getParent();

  boolean isComposite();
}
