package brick.breaker.interfaces;

import processing.core.PVector;

public interface BoundingBox {

  /**
   * Get 2d cartesian coordinate closest to origin.
   *
   * @return {@link PVector} (x, y) coordinate
   */
  public PVector getMin();

  /**
   * Get 2d cartesian coordinate furthest from origin.
   *
   * @return {@link PVector} (x, y) coordinate
   */
  public PVector getMax();

}
