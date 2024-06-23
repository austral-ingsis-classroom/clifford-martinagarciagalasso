package edu.austral.ingsis.clifford;

import java.util.Date;
import java.util.List;

public interface Node {
    public String getName();
    public Node getParent();
    public List<Node> getChildren();
    Date getCreationDate();
}
