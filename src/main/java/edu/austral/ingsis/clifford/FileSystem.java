package edu.austral.ingsis.clifford;

import edu.austral.ingsis.clifford.commands.*;
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

    //para ejecutar comandos
    public String executeMyCommand(String commandLine) {

        try {
            String[] tokens = commandLine.split(" ");
            if (tokens.length == 0) {
                return "Error: Empty command";
            }
        String commandName = tokens[0];
        Commands command = null;

        switch (commandName) {
            case "ls":
                String param = tokens.length > 1 ? tokens[1].split("=")[1] : null;
                command = new Ls(this, param);
                break;
            case "cd":
                String path = tokens[1];
                command = new Cd(path, this);
                break;
            case "touch":
                String fileName = tokens[1];
                command = new Touch(this, fileName);
                break;
            case "mkdir":
                String dirName = tokens[1];
                command = new Mkdir(this, dirName);
                break;
            case "rm":
                String name;
                boolean recursive = false;
                if (tokens.length > 2) {
                    name = tokens[2];
                    recursive = tokens[1].equals("--recursive");
                } else {
                    name = tokens[1];
                }
                command = new Rm(this, name, recursive);
                break;
            case "pwd":
                command = new Pwd(this);
                break;
            default:
                return "Error: Unknown command";
        }

        return command.execute();

    } catch (Exception e) {
        return "Error: " + e.getMessage();
    }
    }
}
