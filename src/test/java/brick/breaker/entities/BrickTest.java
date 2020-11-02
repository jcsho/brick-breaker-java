package brick.breaker.entities;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BrickTest {

  private Brick brick;

  /**
   * Initialize object values.
   */
  @BeforeEach
  public void initialize() {
    brick = new Brick();
  }

  @Test
  public void testSetHealthError() {
    int illegalValue = -5;

    assertThrows(IllegalArgumentException.class, () -> brick.setMaxHealth(illegalValue));
  }

  /**
   * Check brick health can be damaged and never goes below 0.
   */
  @Test
  public void testBrickHealth() {
    int initialHealth = 10;

    brick.setMaxHealth(initialHealth);
    assertThat(String.format("Brick health has been set to %d", initialHealth),
        brick.getHealth(), is(equalTo(initialHealth)));

    int damageOne = 5;
    int expectedHealthAfterDamageOne = 5;
    brick.damage(damageOne);
    assertThat(
        String.format("Brick has been damaged by %d points, total health should be %d",
            damageOne, expectedHealthAfterDamageOne),
        brick.getHealth(), is(equalTo(initialHealth - damageOne)));

    int damageTwo = 20;
    brick.damage(damageTwo);
    assertThat("Brick health should not fall below 0", brick.getHealth(), is(equalTo(0)));
  }
}

