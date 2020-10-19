package brick.breaker.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import processing.core.PVector;

public class BallTest {

  private static Ball ball = new Ball();
  private static PVector ballPosition = new PVector(100, 100);
  private static PVector ballSize = new PVector(50, 50);

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
    PVector brickPosition = new PVector(160, 140);
    Brick brick = new Brick().setPosition(brickPosition).setSize(brickSize);

    boolean isCollidingWithBrick = ball.isColliding(brick);
    assertTrue(isCollidingWithBrick);
  }

}

