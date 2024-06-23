package edu.austral.ingsis.clifford;

import edu.austral.ingsis.clifford.directories.Directory;

public class FileSystem {
    private final Directory root;
    private Directory currentDirectory;

    public FileSystem() {
        this.root = new Directory("");
        this.currentDirectory = root;
    }

    public FileSystem(Directory root) {
        this.root = root;
        this.currentDirectory = root;
    }
    public Directory getCurrentDirectory() {
        return currentDirectory;
    }

    public void setCurrentDirectory(Directory directory) {
        currentDirectory = directory;
    }
    public Directory getRoot() {
        return root;
    }
}
