package edu.austral.ingsis.clifford;

import edu.austral.ingsis.clifford.directories.Directory;

public interface Node {
  public String getName();

  public Directory getParent();
}
