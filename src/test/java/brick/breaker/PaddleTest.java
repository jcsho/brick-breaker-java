
package brick.breaker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;
import processing.core.PVector;

public class PaddleTest {

  @Test
  public void testPaddleMovement() {
    float newPosition = 50;
    PVector initialPosition = new PVector(500, 800);

    Paddle paddle = new Paddle();
    paddle.setPosition(initialPosition);
    paddle.move(newPosition);

    PVector finalPosition = paddle.getPosition().lerp(newPosition, 0f, 0f, 0.6f);

    assertEquals(finalPosition, paddle.getPosition());
  }

  @Test
  public void testSmoothingThrowsError() {
    float incorrectArgument = -5;

    Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
      Paddle paddle = new Paddle();
      paddle.setMovementSmoothing(incorrectArgument);
    });

    assertEquals("Amount must be between 0 and 1", exception.getMessage());
  }
}
