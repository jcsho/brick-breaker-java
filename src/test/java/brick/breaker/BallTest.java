package brick.breaker;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import processing.core.PVector;

public class BallTest {

  @Test
  public void testBallSetSize() {
    PVector size = new PVector(50, 50);
    Ball ball = new Ball().setSize(size);
    assertEquals(size, ball.getSize());
  }

  @Test
  public void testBallSetStartingLocation() {
    float x = 50;
    float y = 50;
    PVector location = new PVector(x, y);
    Ball ball = new Ball().setSize(new PVector(50, 50)).setPosition(location);
    assertEquals(location, ball.getPosition());
  }

}

