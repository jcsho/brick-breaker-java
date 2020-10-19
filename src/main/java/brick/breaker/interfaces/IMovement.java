package brick.breaker.interfaces;

import processing.core.PVector;

public interface IMovement {

  /**
   * Limits maximum movement speed.
   *
   * @param limit magnitiude of speed vector
   * @throws IllegalArgumentException limit must be greater than 0
   */
  void setMaxSpeed(float limit) throws IllegalArgumentException;

  /**
   * Movement for object.
   *
   * @param location new place to move towards
   */
  void update(PVector location);

}
