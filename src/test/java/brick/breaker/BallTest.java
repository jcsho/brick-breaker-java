package brick.breaker;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BallTest {

  @Test
  public void testBallSetSize() {
    int size = 5;
    Ball ball = new Ball(size);
    assertEquals(size, ball.getSize());
  }

}

