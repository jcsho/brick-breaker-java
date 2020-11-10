package brick.breaker.components.collisions;

import brick.breaker.entities.Shape;
import brick.breaker.interfaces.Collision;
import brick.breaker.interfaces.Vector;
import lombok.NonNull;
import lombok.ToString;

/**
 * Algorithmic strategy for collision between circle {@link Shape} and rectangular {@link Shape}.
 * TODO: enforce shape constraints with state pattern (look at alternatives?)
 */
@ToString
public class CircleAndRect implements Collision<Shape> {

  private final Vector closestEdge;
  private final Vector delta;

  public CircleAndRect(@NonNull Vector type) {
    closestEdge = type;
    delta = closestEdge.copy();
  }

  /**
   * Checks if circle and rect are overlapping.
   *
   * @param circle {@link Shape} that has a circular shape
   * @param rect {@link Shape} that has a rectangular shape
   * @return true if shapes overlap, false if not
   */
  @Override
  public boolean isColliding(@NonNull Shape circle, @NonNull Shape rect) {
    // set closest edges to the circle so function will return true
    // if they are already overlapping
    closestEdge.set(circle.getPosition());

    if (circle.getPosition().getX() < rect.getMinEdge().getX()) {
      closestEdge.set(rect.getMinEdge().getX(), closestEdge.getY());
    } else if (circle.getPosition().getX() > rect.getMaxEdge().getX()) {
      closestEdge.set(rect.getMaxEdge().getX(), closestEdge.getY());
    }

    if (circle.getPosition().getY() < rect.getMinEdge().getY()) {
      closestEdge.set(closestEdge.getX(), rect.getMinEdge().getY());
    } else if (circle.getPosition().getY() > rect.getMaxEdge().getY()) {
      closestEdge.set(closestEdge.getX(), rect.getMaxEdge().getY());
    }

    delta.set(circle.getPosition()).sub(closestEdge);
    return delta.mag() <= circle.getSize().getX() / 2;
  }

  @Override
  public Vector collisionDirection(@NonNull Shape object1, @NonNull Shape object2) {
    delta.set(object1.getPosition()).sub(object2.getPosition());
    return delta;
  }
}
