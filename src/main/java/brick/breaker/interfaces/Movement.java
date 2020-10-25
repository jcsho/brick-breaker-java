package brick.breaker.interfaces;

import processing.core.PVector;

public interface Movement {

  /**
   * Limits maximum movement speed.
   *
   * @param limit magnitude between 0 and 100
   * @throws IllegalArgumentException limit is outside of accepted bounds (0 - 100)
   */
  void setMaxSpeed(float limit) throws IllegalArgumentException;

  /**
   * Restrict movement to a bounding box.
   *
   * @param minBoundary box origin coordinate
   * @param maxBoundary box corner coordinate
   */
  void setMovementBoundary(PVector minBoundary, PVector maxBoundary);

  /**
   * Abstract setter for object movement target.
   *
   * @param position the target object should move towards
   */
  void setTargetPosition(PVector position);

  /**
   * Physics movement update.
   */
  void update();

}
