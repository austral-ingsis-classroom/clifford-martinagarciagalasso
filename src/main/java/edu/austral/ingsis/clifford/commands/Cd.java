package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.Node;
import edu.austral.ingsis.clifford.directories.Directory;


import java.util.List;
import java.util.Optional;

public class Cd implements Commands {
    private final String params;
    private final FileSystem fileSystem;

    public Cd(String params, FileSystem fileSystem) {
        this.params = params;
        this.fileSystem = fileSystem;
    }

    @Override
    public String execute() {
        return changeDirectory(params, fileSystem);
    }

    private String changeDirectory(String params, FileSystem fileSystem) {
        switch (params) {
            case ".." -> {
                return moveToParentDirectory(fileSystem);
            }

            case "." -> {
                return stayInCurrentDirectory(fileSystem);
            }

            case "/" -> {
                return moveToRootDirectory(fileSystem);
            }
            default -> {
                return navigateToSpecifiedDirectory(params, fileSystem);
            }
        }
    }

    private String stayInCurrentDirectory(FileSystem fileSystem) {
        Directory currentDirectory = fileSystem.getCurrentDirectory();
        return "Stayed in the current directory: '" + currentDirectory.getName() + "'";
    }

    private String moveToParentDirectory(FileSystem fileSystem) {
        Directory currentDirectory = fileSystem.getCurrentDirectory();
        Directory parentDirectory = currentDirectory.getParent();

        if (parentDirectory == null) {
            fileSystem.setCurrentDirectory(fileSystem.getRoot());
            return "Moved to root directory '/'";
        } else {
            fileSystem.setCurrentDirectory(parentDirectory);
            if (parentDirectory == fileSystem.getRoot()) {
                return "Moved to root directory '/'";
            }
            return "Moved to directory: '" + parentDirectory.getName() + "'";
        }
    }

    private String moveToRootDirectory(FileSystem fileSystem) {
        fileSystem.setCurrentDirectory(fileSystem.getRoot());
        return "Moved to root directory '/'";
    }

    private String navigateToSpecifiedDirectory(String params, FileSystem fileSystem) {
        Directory currentDirectory = fileSystem.getCurrentDirectory();
        String[] pathSegments = params.split("/");

        Directory targetDirectory = findDirectory(currentDirectory, pathSegments);
        if (targetDirectory != null) {
            fileSystem.setCurrentDirectory(targetDirectory);
            if (targetDirectory == fileSystem.getRoot()) {
                return "Moved to root directory '/'";
            }
            return "Moved to directory: '" + targetDirectory.getName() + "'";
        } else {
            return "Directory '" + params + "' does not exist";
        }
    }

    //navegar a un directorio especifico dado x una ruta
    private Directory findDirectory(Directory startDir, String[] pathSegments) {
        Directory currentDir = startDir;
        for (String segment : pathSegments) {
            boolean found = false;
            List<Node> children = currentDir.getChildren();
            if (children.isEmpty()) {
                return null;
            }
            for (Node child : children) {
                if (child.getName().equals(segment) && child instanceof Directory) {
                    currentDir = (Directory) child;
                    found = true;
                    break;
                }
            }
            if (!found) {
                return null;
            }
        }
        return currentDir;
    }
}
