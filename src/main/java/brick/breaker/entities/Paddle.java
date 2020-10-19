package brick.breaker.entities;

import brick.breaker.IMovement;
import processing.core.PApplet;
import processing.core.PVector;

public class Paddle extends Shape<Paddle> implements IMovement {

  private float maxSpeed = 0.6f;

  /**
   * Default constructor for {@link Paddle}.
   */
  public Paddle() {
    super();
    subclass = this;
  }

  @Override
  public void setMaxSpeed(float limit) throws IllegalArgumentException {
    if (limit <= 0 || limit > 100) {
      throw new IllegalArgumentException("Limit must be between 1 and 100");
    }

    maxSpeed = limit / 100;
  }

  @Override
  public void update(PVector location) {
    PVector newLocation = new PVector(location.x, this.position.y);
    this.position.lerp(newLocation, maxSpeed);
  }

  @Override
  public void render(PApplet sketch) {
    sketch.rect(this.position.x, this.position.y, this.size.x, this.size.y);
  }
}
