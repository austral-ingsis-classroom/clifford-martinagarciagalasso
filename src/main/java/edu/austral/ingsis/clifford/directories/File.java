package edu.austral.ingsis.clifford.directories;

import edu.austral.ingsis.clifford.Node;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class File implements Node {
    private final String name;
    private final Directory parent;
    private final List<Node> children;
    public File(String name, Directory parent) {
        this.name = name;
        parent.addChild(this);
        this.parent = parent;
        this.children = new ArrayList<>();

    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public Directory getParent() {
        return parent;
    }

    @Override
    public List<Node> getChildren() {
        return children;
    }

    @Override
    public Date getCreationDate() {
        return null;
    }
}
