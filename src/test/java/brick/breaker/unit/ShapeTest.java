package brick.breaker.unit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import brick.breaker.entities.Shape;
import brick.breaker.interfaces.Collision;
import brick.breaker.interfaces.Movement;
import brick.breaker.interfaces.Renderer;
import brick.breaker.interfaces.Vector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ShapeTest {

  private Shape shape;
  @Mock
  private Collision<Shape> collision;
  @Mock
  private Movement movement;
  @Mock
  private Renderer renderer;
  @Mock
  private Vector position;
  @Mock
  private Vector size;

  @BeforeEach
  protected void setup() {
    MockitoAnnotations.initMocks(this);
    when(position.copy()).thenReturn(mock(Vector.class));

    shape = Shape.builder()
        .collision(collision)
        .movement(movement)
        .renderer(renderer)
        .position(position)
        .size(size)
        .build();
  }

  @DisplayName("Test Collision Logic Is Delegated")
  @Test
  protected void testCollisionDelegation() {
    Shape other = mock(Shape.class);
    shape.isColliding(other);
    verify(collision, times(1)).isColliding(shape, other);

    shape.collisionDirection(other);
    verify(collision, times(1)).collisionDirection(shape, other);
  }

  @DisplayName("Test Movement Logic Is Delegated")
  @Test
  protected void testMovementDelegation() {
    Vector target = mock(Vector.class);
    shape.setTargetPosition(target);
    verify(movement, times(1)).setTargetPosition(position, target);

    shape.update();
    verify(movement, times(1)).update(position);
  }

  @DisplayName("Test Rendering Logic Is Delegated")
  @Test
  protected void testRendererDelegation() {
    shape.render();
    verify(renderer, times(1)).render(position, size);
  }

  @DisplayName("Test Shape Returns Axis-Aligned Bounding Box")
  @Test
  protected void testReturnContainingBox() {
    assertThat(shape.getMinEdge(), isA(Vector.class));
    assertThat(shape.getMaxEdge(), isA(Vector.class));
  }
}
