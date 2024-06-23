package edu.austral.ingsis.clifford;

import edu.austral.ingsis.clifford.directories.Directory;

import java.util.Date;
import java.util.List;

public interface Node {
    public String getName();
    public Directory getParent();
    public List<Node> getChildren();

}
