package brick.breaker.entities;

import brick.breaker.interfaces.Movement;
import processing.core.PApplet;
import processing.core.PVector;

public class Paddle extends Box<Paddle> implements Movement {

  private float maxSpeed = 0.6f;
  private PVector targetPosition;

  /**
   * Default constructor for {@link Paddle}.
   */
  public Paddle() {
    super();
    subclass = this;
  }

  /**
   * Add default target position.
   *
   * @param newPosition {@link PVector} for x and y cartesian coordinates
   * @return this {@link Paddle} instance
   */
  @Override
  public Paddle setPosition(PVector newPosition) {
    super.setPosition(newPosition);
    this.targetPosition = new PVector(0f, newPosition.y);
    return this;
  }

  @Override
  public void setMaxSpeed(float limit) throws IllegalArgumentException {
    if (limit <= 0 || limit > 100) {
      throw new IllegalArgumentException("Limit must be between 1 and 100");
    }

    maxSpeed = limit / 100;
  }

  @Override
  public void setTargetPosition(PVector position) {
    this.targetPosition.set(position.x, this.position.y);
  }

  @Override
  public void update() {
    if (this.targetPosition.x != this.position.x) {
      this.position.lerp(this.targetPosition, maxSpeed);
    }
  }

  @Override
  public void render(PApplet sketch) {
    sketch.rect(this.position.x, this.position.y, this.size.x, this.size.y);
  }
}
