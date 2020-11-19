package brick.breaker.unit;

import static org.mockito.ArgumentMatchers.anyFloat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import brick.breaker.components.movement.PaddleMovement;
import brick.breaker.interfaces.Movement;
import brick.breaker.interfaces.Vector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PaddleMovementTest {

  private Vector velocity;
  private Movement movement;

  @BeforeEach
  protected void setup() {
    velocity = mock(Vector.class);
    movement = new PaddleMovement(velocity);
  }

  @DisplayName("Test Paddle Movement Does Nothing On Change Direction")
  @Test
  protected void testMovementNoInteraction() {
    verifyNoMoreInteractions(velocity);
    movement.changeDirection(true, true);
  }

  @DisplayName("Test Paddle Movement Update Changes Position")
  @Test
  protected void testMovementUpdate() {
    Vector position = mock(Vector.class);
    movement.update(position);
    verify(position).lerp(eq(velocity), anyFloat());
  }
}
