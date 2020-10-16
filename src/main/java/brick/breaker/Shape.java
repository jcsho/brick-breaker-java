package brick.breaker;

import processing.core.PApplet;
import processing.core.PVector;

/**
 * The base class for all shapes in the game.
 */
public abstract class Shape<T extends Shape<T>> {

  protected T subclass;
  protected PVector position;
  protected PVector size;
  protected PVector speed;

  public Shape() {
    position = new PVector();
    size = new PVector();
  }

  /**
   * Getter for position of {@link Shape}.
   *
   * @return {@link PVector} 2D
   */
  public PVector getPosition() {
    return this.position;
  }

  /**
   * Getter for size of {@link Shape}.
   *
   * @return {@link PVector} 2D
   */
  public PVector getSize() {
    return this.size;
  }

  /**
   * Getter for speed of {@link Shape}.
   *
   * @return {@link PVector} 2D
   */
  public PVector getSpeed() {
    return this.speed;
  }

  /**
   * Setter for coordinates of {@link Shape}.
   *
   * @param newPosition {@link PVector} for x and y cartesian coordinates
   * @return this instance of {@link Shape}
   */
  public T setPosition(PVector newPosition) {
    subclass.position = newPosition;
    return subclass;
  }

  /**
   * Setter for size of {@link Shape}.
   *
   * @param newSize {@link PVector} for shape
   * @return this instance of {@link Shape}
   */
  public T setSize(PVector newSize) {
    subclass.size = newSize;
    return subclass;
  }

  /**
   * Setter for speed of {@link Shape}.
   *
   * @param newSpeed {@link PVector} for speed in x and y axis
   * @return this instance of {@link Shape}
   */
  public T setSpeed(PVector newSpeed) {
    subclass.speed = newSpeed;
    return subclass;
  }

  public abstract void render(PApplet sketch);

}
