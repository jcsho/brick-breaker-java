package brick.breaker.unit;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import brick.breaker.components.movement.BallMovement;
import brick.breaker.interfaces.Movement;
import brick.breaker.interfaces.Vector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallMovementTest {

  private float mockXValue1;
  private float mockYValue1;
  private float moveSpeed;
  private Vector velocity;
  private Movement movement;

  @BeforeEach
  protected void setup() {
    mockXValue1 = (float) Math.random();
    mockYValue1 = (float) Math.random();
    velocity = mock(Vector.class);
    when(velocity.getX()).thenReturn(mockXValue1);
    when(velocity.getY()).thenReturn(mockYValue1);

    movement = new BallMovement(velocity);
  }

  @DisplayName("Test Ball Movement Changes Directions")
  @Test
  protected void testMovementChangeDirection() {
    movement.changeDirection(true, true);
    // inverting values should be done separately based on arguments
    verify(velocity).set(-mockXValue1, mockYValue1);
    verify(velocity).set(mockXValue1, -mockYValue1);
  }

  @DisplayName("Test Ball Movement Throws Error On Out of Bounds Move Speed")
  @Test
  protected void testMovementThrowsError() {
    moveSpeed = -1;
    assertThrows(IllegalArgumentException.class, () -> movement.setMoveSpeed(moveSpeed));
  }

  @DisplayName("Test Ball Movement Update Changes Position")
  @Test
  protected void testMovementUpdate() {
    Vector position = mock(Vector.class);
    movement.update(position);
    verify(position).add(velocity);
  }
}
