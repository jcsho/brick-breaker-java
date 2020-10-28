package brick.breaker.entities;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import processing.core.PVector;

public class BallTest {

  private static Ball ball = new Ball();
  private static PVector ballPosition = new PVector(26, 26);
  private static PVector ballSize = new PVector(50, 50);
  private static PVector minBoundary = new PVector(0, 0);
  private static PVector maxBoundary = new PVector(500, 500);

  @Test
  public void testBallSetSize() {
    ball.setSize(ballSize);
    assertEquals(ballSize.x, ball.getSize().x, 0.1);
    assertEquals(ballSize.y, ball.getSize().y, 0.1);
  }

  @Test
  public void testBallSetStartingLocation() {
    ball.setPosition(ballPosition);
    assertEquals(ballPosition.x, ball.getPosition().x, 0.1);
    assertEquals(ballPosition.y, ball.getPosition().y, 0.1);
  }

  @Test
  public void testBallDetectCollisionTrue() {
    ball.setPosition(ballPosition).setSize(ballSize);

    // collision should happen at brick's bottom left corner
    // and balls' top right vertex (approx (113, 121))
    PVector brickSize = new PVector(100, 50);
    PVector brickPosition = new PVector(
        ball.getPosition().x + (ball.getSize().x / 2) + (brickSize.x / 4),
        ball.getPosition().y + (ball.getSize().y / 2) + (brickSize.y / 4));
    Brick brick = new Brick().setPosition(brickPosition).setSize(brickSize);

    boolean isCollidingWithBrick = ball.isColliding(brick);
    assertTrue(isCollidingWithBrick);
  }

  @Test
  public void testBallMovement() {
    PVector newPosition = new PVector(0, 0);
    float speed = 60;
    ball.setMovementBoundary(minBoundary, maxBoundary);
    ball.setMaxSpeed(speed);
    ball.setTargetPosition(newPosition);
    ball.update();
    assertThat(ball.getPosition().array(), not(is(newPosition.array())));
  }

  @Test
  public void testBallOutOfBounds() {
    PVector newPosition = new PVector(0, 0);
    ball.setMovementBoundary(minBoundary, maxBoundary);
    ball.setTargetPosition(newPosition);
    for (int i = 0; i < 5; i++) {
      ball.update();
    }
    assertTrue(ball.getPosition().x > minBoundary.x,
        "Ball X position should be greater than min bounds x");
    assertTrue(ball.getPosition().x < maxBoundary.x,
        "Ball X position should be less than max bounds x");
    assertTrue(ball.getPosition().x > minBoundary.y,
        "Ball Y position should be greater than min bounds y");
    assertTrue(ball.getPosition().x < maxBoundary.y,
        "Ball Y position should be less than max bounds y");
  }
}

