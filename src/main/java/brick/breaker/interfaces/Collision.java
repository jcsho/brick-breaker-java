package brick.breaker.interfaces;

/**
 * Collision detection logic.
 */
public interface Collision<T> {

  /**
   * Check for collision between 2 objects.
   *
   * @param object1 first object to check
   * @param object2 second object to check
   * @return true if objects' boundaries overlap
   */
  boolean isColliding(T object1, T object2);

  /**
   * Check for direction of object 2 relative to object 1.
   *
   * @param object1 base object
   * @param object2 relative object
   * @return 2d coordinate of collision from base object's perspective
   */
  Vector collisionDirection(T object1, T object2);

}
