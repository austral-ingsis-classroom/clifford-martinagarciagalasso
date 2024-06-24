package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.directories.Directory;

import java.util.Objects;

public class Pwd implements Commands{
    private final FileSystem fileSystem;

    public Pwd(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }

    @Override
    public String execute() {
       return getroute(fileSystem);
    }


    private String getroute(FileSystem fileSystem) {
        Directory currentDir = fileSystem.getCurrentDirectory();
        StringBuilder routeBuilder = new StringBuilder();


        while (currentDir != null) {
            routeBuilder.insert(0, "/" + currentDir.getName());
            currentDir = currentDir.getParent();
            if(currentDir.getName().equals("")){ // root directory
                break;
            }
        }

        return routeBuilder.toString();

    }


}
