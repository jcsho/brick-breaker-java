package brick.breaker.entities;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertThrows;

import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNot;
import org.junit.Test;
import processing.core.PVector;

public class PaddleTest {
  private static final PVector initialPosition = new PVector(50, 450);
  private static final PVector minBoundary = new PVector(0, 0);
  private static final PVector maxBoundary = new PVector(500, 500);
  private static final PVector paddleSize = new PVector(100, 50);

  @Test
  public void testPaddleMovement() {
    PVector newPosition = new PVector(600, 0);
    float maxSpeed = 5;

    Paddle paddle = new Paddle();
    paddle.setMovementBoundary(minBoundary, maxBoundary);
    paddle.setSize(paddleSize);
    paddle.setPosition(initialPosition);
    paddle.setMaxSpeed(maxSpeed);
    paddle.setTargetPosition(newPosition);
    paddle.update();

    assertThat(paddle.getPosition().array(), IsNot.not(IsEqual.equalTo(initialPosition.array())));
  }

  @Test
  public void testSetSpeedThrowsError() {
    float incorrectArgument = -5;

    assertThrows(IllegalArgumentException.class, () -> {
      Paddle paddle = new Paddle();
      paddle.setMaxSpeed(incorrectArgument);
    });
  }

  @Test
  public void testSetTargetPositionOutOfBounds() {
    PVector newPosition = new PVector(-50, initialPosition.y);
    Paddle paddle = new Paddle();
    paddle.setMovementBoundary(minBoundary, maxBoundary);
    paddle.setPosition(initialPosition);
    paddle.setSize(paddleSize);
    paddle.setTargetPosition(newPosition);
    paddle.update();
    assertThat(paddle.getPosition().array(), IsEqual.equalTo(initialPosition.array()));
  }
}
