package brick.breaker.entities;

import brick.breaker.interfaces.Collision;
import brick.breaker.interfaces.Movement;
import brick.breaker.interfaces.Renderer;
import brick.breaker.interfaces.Vector;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The base class for all shapes in the game.
 */
@ToString
public class Shape {
  @Setter
  private Collision<Shape> collision;
  @Setter
  private Movement movement;
  @Setter
  private Renderer renderer;
  @Getter
  @Setter
  private Vector position;
  @Getter
  @Setter
  private Vector size;
  private final Vector minEdge;
  private final Vector maxEdge;

  /**
   * Default all args constructor for shape.
   *
   * @param collision hit detection logic component
   * @param movement  physics movement logic component
   * @param renderer  graphics rendering logic component
   * @param position  state for 2d coordinate
   * @param size      state for length and width of shape
   */
  @Builder
  public Shape(Collision<Shape> collision, Movement movement, Renderer renderer, Vector position,
               Vector size) {
    this.collision = collision;
    this.movement = movement;
    this.renderer = renderer;
    this.position = position;
    this.size = size;
    this.minEdge = this.position.copy();
    this.maxEdge = this.position.copy();
  }

  /**
   * Draw object to screen.
   */
  public void render() {
    this.renderer.render(this.position, this.size);
  }

  /**
   * Get minimum bounds (axis-aligned bounding box) of shape.
   *
   * @return coordinate of minimum edge
   */
  public Vector getMinEdge() {
    minEdge.set(position.getX() - size.getX(), position.getY() - size.getY());
    return minEdge;
  }

  /**
   * Get maximum bounds (axis-aligned bounding box) of shape.
   *
   * @return coordinate of maximum edge
   */
  public Vector getMaxEdge() {
    maxEdge.set(position.getX() + size.getX(), position.getY() + size.getY());
    return maxEdge;
  }

  /**
   * Collision detection between 2 shapes.
   * Delegated to {@link Collision#isColliding(Object, Object)}.
   *
   * @param other shape to detect
   * @return true if shapes are is overlapping
   */
  public boolean isColliding(Shape other) {
    return collision.isColliding(this, other);
  }

  /**
   * Check direction of collision.
   * Delegated to {@link Collision#collisionDirection(Object, Object)}.
   * @TODO combine this with isCollding.
   *
   * @param other shape to detect
   * @return {@link Vector} direction of the other shape
   */
  public Vector collisionDirection(Shape other) {
    return collision.collisionDirection(this, other);
  }
}
