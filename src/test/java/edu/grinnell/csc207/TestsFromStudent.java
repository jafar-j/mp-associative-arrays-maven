package edu.grinnell.csc207;

import edu.grinnell.csc207.util.AssociativeArray;
import edu.grinnell.csc207.util.NullKeyException;
import edu.grinnell.csc207.util.KeyNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

/**
 * A place for you to put your own tests (beyond the shared repo).
 *
 * @author Your Name Here
 */
public class TestsFromStudent {
  
  /**
   * Tests whether setting keys to multiple values replaces the values.
   */
  @Test
  public void jafarJarrarTest1() throws Exception {
    AssociativeArray<String, String> aa = new AssociativeArray<String, String>();
    // Sets multiple keys to different values.
    aa.set("one", "one");
    aa.set("two", "two");
    aa.set("two", "2");
    aa.set("three", "three");
    aa.set("three", "3");
    aa.set("three", "3.0");
    aa.set("four", "four");
    aa.set("four", "4");
    aa.set("four", "4.0");
    aa.set("four", "4.00");
    try {
      assertEquals("one", aa.get("one"));
      assertEquals("2", aa.get("two"));
      assertEquals("3.0", aa.get("three"));
      assertEquals("4.00", aa.get("four"));
    } catch (Exception e) {
      fail("Value does not match updated key.");
    } // try/catch

    // Sets key to same value.
    aa.set("one", "one");
    try {
      assertEquals("one", aa.get("one"));
    } catch (Exception e) {
      fail("Value does not match updated key.");
    } // try/catch
  } // jafarJarrarTest01()

  /**
   * Tests cloning an array.
   */
  @Test
  public void jafarJarrarTest2() throws Exception {
    AssociativeArray<String, String> aa = new AssociativeArray<String, String>();
    // Sets multiple keys and values.
    aa.set("one", "one");
    aa.set("two", "two");
    aa.set("three", "three");
    aa.set("four", "four");

    // Clones the array.
    AssociativeArray<String, String> aaClone = aa.clone();
    try {
      assertEquals("one", aaClone.get("one"));
      assertEquals("two", aaClone.get("two"));
      assertEquals("three", aaClone.get("three"));
      assertEquals("four", aaClone.get("four"));
      assertEquals(aa.size(), aaClone.size());
    } catch (Exception e) {
      fail("Associative array was not cloned correctly.");
    } // try/catch
  } // jafarJarrarTest2()

   /**
   * Tests cloning an empty array after adding and removing a value.
   */
  @Test
  public void jafarJarrarEdge1() throws Exception {
    AssociativeArray<String, String> aa = new AssociativeArray<String, String>();
    // Adding a value.
    aa.set("one", "one");
    try {
      assertEquals("one", aa.get("one"));
    } catch (Exception e) {
      fail("Value was not set correctly.");
    } // try/catch

    // Removing the value.
    aa.remove("one");
    try {
      assertEquals(0, aa.size());
    } catch (Exception e) {
      fail("Value was not removed correctly.");
    } // try/catch

    // Clones the array.
    AssociativeArray<String, String> aaClone = aa.clone();
    try {
      assertEquals(0, aaClone.size());
      assertEquals("one", aaClone.get("one"));
      fail("There should be no keys so getting should throw an exception.");
    } catch (Exception e) {
      // This statement should be reached.
    } // try/catch
  } // jafarJarrarTest2()


} // class TestsFromStudent
