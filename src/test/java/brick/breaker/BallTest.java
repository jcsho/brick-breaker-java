package brick.breaker;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import processing.core.PVector;

public class BallTest {

  @Test
  public void testBallSetSize() {
    int size = 5;
    Ball ball = new Ball(size);
    assertEquals(size, ball.getSize());
  }

  @Test
  public void testBallSetStartingLocation() {
    float x = 50;
    float y = 50;
    PVector location = new PVector(x, y);
    Ball ball = new Ball(50);
    ball.setLocation(location);
    assertEquals(location, ball.getLocation());
  }

  @Test
  public void testBallSpeed() {
    float speedX = 1;
    float speedY = 1;
    PVector speed = new PVector(speedX, speedY);
    Ball ball = new Ball(50);
    ball.setSpeed(speed);
    assertEquals(speed, ball.getSpeed());
  }

}

