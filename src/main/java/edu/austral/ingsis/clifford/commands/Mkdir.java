package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.directories.Directory;

public class Mkdir implements Commands {
  private final FileSystem fileSystem;
  private final String name;

  public Mkdir(FileSystem fileSystem, String name) {
    this.fileSystem = fileSystem;
    this.name = name;
  }

  @Override
  public String execute() {
    try {
      if (name.isEmpty()) {
        return "Error: Directory name cannot be empty";
      }
      new Directory(name, fileSystem.getCurrentDirectory());
      return "'" + name + "' directory created";

    } catch (IllegalArgumentException e) {
      return "Error: " + e.getMessage();
    }
  }
}
