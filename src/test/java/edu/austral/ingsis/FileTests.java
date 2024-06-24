package edu.austral.ingsis;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.austral.ingsis.clifford.directories.Directory;
import edu.austral.ingsis.clifford.directories.File;
import java.util.List;
import org.junit.jupiter.api.Test;

public class FileTests {
  @Test
  public void testDirectory() {
    Directory root = new Directory("");
    Directory directory = new Directory("directory", root);

    assertEquals(directory.getName(), "directory");
    assertEquals(root.getChildren(), List.of(directory));
  }

  @Test
  public void testGetChildrenList() {
    Directory root = new Directory("");
    Directory directory = new Directory("directory", root);
    Directory directory1 = new Directory("directory1", root);

    assertEquals(root.getChildren(), List.of(directory, directory1));
  }

  @Test
  public void testMultiLevel() {
    Directory root = new Directory("");
    Directory directory = new Directory("directory", root);
    Directory directory1 = new Directory("directory1", directory);

    assertEquals(root.getChildren(), List.of(directory));
    assertEquals(directory.getChildren(), List.of(directory1));
  }

  @Test
  public void testRemoveChild() {
    Directory root = new Directory("");
    Directory directory = new Directory("directory", root);
    Directory directory1 = new Directory("directory1", root);

    root.removeChild(directory);
    assertEquals(root.getChildren(), List.of(directory1));
  }

  @Test
  public void testDirectoryWithFiles() {
    Directory root = new Directory("");
    File file = new File("file", root);
    Directory file1 = new Directory("file1", root);

    assertEquals(root.getChildren(), List.of(file, file1));
  }
}
