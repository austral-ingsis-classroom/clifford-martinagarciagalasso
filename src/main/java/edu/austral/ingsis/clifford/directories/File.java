package edu.austral.ingsis.clifford.directories;

import edu.austral.ingsis.clifford.Node;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class File implements Node {
    private final String name;
    private final Directory parent;

    public File(String name, Directory parent) {
        this.name = name;
        this.parent = parent;
        parent.addChild(this);
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public Directory getParent() {
        return parent;
    }



}
