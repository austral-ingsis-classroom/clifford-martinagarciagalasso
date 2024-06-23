package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.Node;
import edu.austral.ingsis.clifford.directories.Directory;

import java.util.List;

public class Rm implements Commands {
    private final FileSystem fileSystem;
    private final String name;
    private final boolean recursive;

    public Rm(FileSystem fileSystem, String name, boolean recursive) {
        this.name = name;
        this.recursive = recursive;
        this.fileSystem = fileSystem;
        
    }

    @Override
    public String execute() {
        Node Remove = findItemByName(fileSystem.getCurrentDirectory(), name);

        if (Remove != null) {
            if (Remove instanceof Directory && !recursive) {
                return "cannot remove '" + name + "', is a directory";
            } else {
                fileSystem.getCurrentDirectory().removeChild(Remove);
                return "'" + name + "' removed";
            }
        }

        return "Error: File or directory not found";
    }

    private Node findItemByName(Directory directory, String name) {
        for (Node item : directory.getChildren()) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }

}

