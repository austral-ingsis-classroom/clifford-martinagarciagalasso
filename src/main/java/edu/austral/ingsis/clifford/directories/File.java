package edu.austral.ingsis.clifford.directories;

import edu.austral.ingsis.clifford.Node;

public class File implements Node {
  private final String name;
  private final Directory parent;

  public File(String name, Directory parent) {
    this.name = name;
    this.parent = parent;
    parent.addChild(this);
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public Directory getParent() {
    return parent;
  }
}
