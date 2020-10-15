package brick.breaker;

import processing.core.PApplet;
import processing.core.PVector;

public class Paddle extends Shape {

  private float smoothAmount;

  /**
   * Default constructor for {@link Paddle}.
   */
  public Paddle() {
  }

  /**
   * Set the amount of pixel smoothing for {@link Paddle} movement.
   *
   * @param amount value to slow down by
   * @throws IllegalArgumentException value must be a float between 0 and 1
   */
  public void setMovementSmoothing(float amount) throws IllegalArgumentException {
    if (amount < 0 || amount > 1) {
      throw new IllegalArgumentException("Amount must be between 0 and 1");
    }

    this.smoothAmount = amount;
  }

  /**
   * Move {@link Paddle} to new position in x-axis.
   *
   * @param position on the (inverted) cartesian coordinate system for {@link PApplet}
   */
  public void move(float position) {
    this.position.lerp(new PVector(position, 0), smoothAmount);
  }

  @Override
  public void render(PApplet sketch) {
    sketch.rect(this.position.x, this.position.y, this.size.x, this.size.y);
  }
}
