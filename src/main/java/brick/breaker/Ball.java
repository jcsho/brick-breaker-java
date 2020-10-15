package brick.breaker;

public class Ball {
  private int radius;

  /**
   * Default constructor to create a {@link Ball} object.
   *
   * @param size radius of the {@link Ball}
   */
  public Ball(int size) {
    this.radius = size;
  }

  /**
   * Getter for radius of {@link Ball}.
   *
   * @return radius of circle
   */
  public int getSize() {
    return this.radius;
  }
}
