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
        if (name.isEmpty()) {
            return "Error: Directory name cannot be empty";
        }
        if (name.contains("/") || name.contains(" ")) {
            return "Error: Directory name cannot contain '/' or spaces";
        }

        try {
           Directory newDirectory = new Directory(name, fileSystem.getCurrentDirectory());
           fileSystem.getCurrentDirectory().addChild(newDirectory);
           return "'" + name + "' directory created";
        } catch (IllegalArgumentException e) {
            return "Error: " + e.getMessage();
        }
    }
}
