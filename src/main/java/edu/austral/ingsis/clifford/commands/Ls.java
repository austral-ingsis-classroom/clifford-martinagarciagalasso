package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.Node;
import edu.austral.ingsis.clifford.directories.Directory;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Ls implements Commands {
  private final FileSystem fileSystem;
  private String params;

  public Ls(FileSystem fileSystem, String params) {
    this.fileSystem = fileSystem;
    this.params = params;
  }

  @Override
  public String execute() {
    return listFiles(fileSystem.getCurrentDirectory());
  }

  private String listFiles(Directory directory) {
    List<Node> child = fileSystem.getCurrentDirectory().getChildren();
    List<String> childrenNames = child.stream().map(Node::getName).collect(Collectors.toList());
    if (Objects.equals(params, "desc")) {
      Collections.sort(childrenNames, Collections.reverseOrder());
    } else if (Objects.equals(params, "asc")) {
      Collections.sort(childrenNames);
    }
    return String.join(" ", childrenNames);
  }

  private void sort(List<String> childrenNames) {
    if (params == null) {
      return;
    }
    switch (params) {
      case "--ord=asc":
        Collections.sort(childrenNames);
        break;
      case "--ord=desc":
        Collections.sort(childrenNames, Collections.reverseOrder());
        break;
    }
  }

  public void setParams(String params) {
    this.params = params;
  }
}
