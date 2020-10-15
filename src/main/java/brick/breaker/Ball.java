package brick.breaker;

import processing.core.PApplet;
import processing.core.PVector;

public class Ball extends Shape<Ball> {

  /**
   * Default constructor to create a {@link Ball} object.
   */
  public Ball() {
    subclass = this;
    this.size = new PVector();
    this.position = new PVector();
    this.speed = new PVector();
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
