package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.directories.File;



public class Touch implements Commands {
    private final FileSystem fileSystem;
    private final String name;

    public Touch(FileSystem fileSystem, String name) {
        this.fileSystem = fileSystem;
        this.name = name;
    }

    @Override
    public String execute() {
        if (name.contains("/")) {
            return "File names cannot contain '/'";
        }
        if (name.contains(" ")) {
            return "File names cannot contain spaces";
        }
        new File(name, fileSystem.getCurrentDirectory());
        return "'" + name + "' file created";

    }

}
