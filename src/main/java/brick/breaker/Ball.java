package brick.breaker;

import processing.core.PVector;

public class Ball {
  private PVector position;
  private int radius;

  /**
   * Default constructor to create a {@link Ball} object.
   *
   * @param size radius of the {@link Ball}
   */
  public Ball(int size) {
    this.radius = size;
    this.position = new PVector();
  }

  public Ball setLocation(PVector newPosition) {
    this.position = newPosition;
    return this;
  }

  /**
   * Getter for radius of {@link Ball}.
   *
   * @return radius of circle
   */
  public int getSize() {
    return this.radius;
  }

  public PVector getLocation() {
    return this.position;
  }
}
