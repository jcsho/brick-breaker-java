/*
 * This Java source file was generated by the Gradle 'init' task.
 */

package brick.breaker;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import processing.core.PApplet;

public class AppTest {
  App app = new App();

  @Test
  public void testAppIsPApplet() {
    assertTrue(app instanceof PApplet);
  }
}
