package brick.breaker.entities;

import brick.breaker.interfaces.Movement;
import processing.core.PApplet;
import processing.core.PVector;

public class Paddle extends Box<Paddle> implements Movement {

  private float maxSpeed = 0.6f;
  private PVector targetPosition;
  private PVector minGameSize;
  private PVector maxGameSize;

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
  public void setMovementBoundary(PVector minBoundary, PVector maxBoundary) {
    this.minGameSize = minBoundary;
    this.maxGameSize = maxBoundary;
  }

  @Override
  public void setTargetPosition(PVector position) {
    float xPosition = position.x;
    if (xPosition < this.minGameSize.x + this.halfSize.x) {
      xPosition = this.minGameSize.x + this.halfSize.x;
    } else if (xPosition > this.maxGameSize.x - this.halfSize.x) {
      xPosition = this.maxGameSize.x - this.halfSize.x;
    }
    this.targetPosition.set(xPosition, this.position.y);
  }

  @Override
  public void update() {
    this.position.lerp(this.targetPosition, maxSpeed);
  }

  @Override
  public void render(PApplet sketch) {
    sketch.rect(this.position.x, this.position.y, this.size.x, this.size.y);
  }
}
