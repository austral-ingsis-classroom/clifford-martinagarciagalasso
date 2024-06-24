package edu.austral.ingsis.clifford.directories;

import edu.austral.ingsis.clifford.Node;
import java.util.ArrayList;
import java.util.List;

public class Directory implements Node {
  private final String name;
  private final List<Node> children;
  private final Directory parent;

  public Directory(String name, Directory parent) {
    this.name = name;
    this.parent = parent;
    this.children = new ArrayList<>();
    parent.addChild(this);
  }

  public Directory(String name) {
    this.name = name;
    this.parent = null;
    this.children = new ArrayList<>();
  }

  public void addChild(Node node) {
    children.add(node);
  }

  public void removeChild(Node node) {
    children.remove(node);
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public Directory getParent() {
    return parent;
  }

  public List<Node> getChildren() {
    return children;
  }
}
