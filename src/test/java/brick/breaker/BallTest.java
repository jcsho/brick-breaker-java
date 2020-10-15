package brick.breaker;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import processing.core.PVector;

public class BallTest {

  @Test
  public void testBallSetSize() {
    PVector size = new PVector(50, 50);
    Shape ball = new Ball().setSize(size);
    assertEquals(size, ball.getSize());
  }

  @Test
  public void testBallSetStartingLocation() {
    float x = 50;
    float y = 50;
    PVector location = new PVector(x, y);
    Shape ball = new Ball().setSize(new PVector(50, 50)).setPosition(location);
    assertEquals(location, ball.getPosition());
  }

  @Test
  public void testBallSpeed() {
    float speedX = 1;
    float speedY = 1;
    PVector speed = new PVector(speedX, speedY);
    Shape ball = new Ball().setSize(new PVector(50, 50)).setPosition(new PVector(20, 20));
    ball.setSpeed(speed);
    assertEquals(speed, ball.getSpeed());
  }

}

