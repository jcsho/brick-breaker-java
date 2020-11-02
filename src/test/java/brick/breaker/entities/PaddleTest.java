package brick.breaker.entities;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import processing.core.PVector;

public class PaddleTest {
  private Paddle paddle;
  private PVector initialPosition;
  private PVector newPosition;

  /**
   * Initialize required properties of {@link Paddle}.
   */
  @BeforeEach
  public void initialize() {
    paddle = new Paddle();
    initialPosition = new PVector(50, 450);
    PVector minBoundary = new PVector(0, 0);
    PVector maxBoundary = new PVector(500, 500);
    PVector paddleSize = new PVector(100, 50);
    newPosition = new PVector(600, 0);
    paddle.setMovementBoundary(minBoundary, maxBoundary);
    paddle.setSize(paddleSize);
    paddle.setPosition(initialPosition);
    paddle.setTargetPosition(newPosition);
  }

  @Test
  public void testPaddleMovement() {
    float maxSpeed = 5;

    paddle.setMaxSpeed(maxSpeed);
    paddle.update();

    assertThat(paddle.getPosition().array(), is(not(initialPosition.array())));
  }

  @Test
  public void testSetSpeedThrowsError() {
    float incorrectArgument = -5;

    assertThrows(IllegalArgumentException.class, () -> paddle.setMaxSpeed(incorrectArgument));
  }

  @Test
  public void testSetTargetPositionOutOfBounds() {
    newPosition.set(-50, initialPosition.y);
    paddle.setTargetPosition(newPosition);
    paddle.update();
    assertThat(paddle.getPosition().array(), is(initialPosition.array()));
  }
}
