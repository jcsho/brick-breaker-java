package brick.breaker.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class BrickTest {

  @Test
  public void testSetHealthError() {
    int illegalValue = -5;

    assertThrows(IllegalArgumentException.class, () -> {
      Brick brick = new Brick();
      brick.setMaxHealth(illegalValue);
    });
  }

  /**
   * Check brick health can be damaged and never goes below 0.
   */
  @Test
  public void testBrickHealth() {
    int initialHealth = 10;

    Brick brick = new Brick();
    brick.setMaxHealth(initialHealth);
    assertEquals(initialHealth, brick.getHealth());

    int damageOne = 5;
    brick.damage(damageOne);
    assertEquals(initialHealth - damageOne, brick.getHealth());

    int damageTwo = 20;
    brick.damage(damageTwo);
    assertEquals(0, brick.getHealth());
  }
}

