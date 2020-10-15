package brick.breaker;

import processing.core.PApplet;
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

  /**
   * Setter for coordinates of {@link Ball}.
   *
   * @param newPosition {@link PVector} for x and y cartesian coordinates
   * @return this instance of {@link Ball}
   */
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

  /**
   * Getter for position of {@link Ball}.
   *
   * @return {@link PVector} 2d version
   */
  public PVector getLocation() {
    return this.position;
  }

  /**
   * Draws {@link Ball} to screen.
   * 
   * @param sketch main {@link PApplet} instance
   * @see a {@link Ball} object on screen
   */
  public void render(PApplet sketch) {
    sketch.ellipse(position.x, position.y, radius, radius);
  }
}
