package brick.breaker.entities;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertThrows;

import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNot;
import org.junit.Test;
import processing.core.PVector;

public class PaddleTest {

  @Test
  public void testPaddleMovement() {
    PVector initialPosition = new PVector(500, 800);
    PVector newPosition = new PVector(600, 0);
    float maxSpeed = 5;

    Paddle paddle = new Paddle();
    paddle.setPosition(initialPosition);
    paddle.setMaxSpeed(maxSpeed);
    paddle.update(newPosition);

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
}
