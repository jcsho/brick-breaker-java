package brick.breaker;

import processing.core.PApplet;

public class Ball extends Shape<Ball> {

  /**
   * Default constructor to create a {@link Ball} object.
   */
  public Ball() {
    super();
    subclass = this;
  }

  /**
   * Draws {@link Ball} to screen.
   *
   * @param sketch main {@link PApplet} instance
   */
  public void render(PApplet sketch) {
    sketch.ellipse(this.position.x, this.position.y, this.size.x, this.size.y);
  }
}
