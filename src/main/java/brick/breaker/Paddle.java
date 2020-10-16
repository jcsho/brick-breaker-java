package brick.breaker;

import processing.core.PApplet;
import processing.core.PVector;

public class Paddle extends Shape<Paddle> implements IMovement {

  private PVector velocity;
  private PVector acceleration;
  private float maxSpeed;

  /**
   * Default constructor for {@link Paddle}.
   */
  public Paddle() {
    super();
    subclass = this;
    velocity = new PVector(0, 0);
    acceleration = new PVector();
  }

  @Override
  public void setMaxSpeed(float limit) throws IllegalArgumentException {
    if (limit <= 0)
      throw new IllegalArgumentException("Limit must be greater than 0");

    maxSpeed = limit;
  }

  @Override
  public void update(PVector location) {
    acceleration = PVector.sub(location, this.position);
    acceleration.setMag(0.2f);

    velocity.add(acceleration);
    velocity.limit(maxSpeed);
    this.position.add(velocity);
  }

  @Override
  public void render(PApplet sketch) {
    sketch.rect(this.position.x, this.position.y, this.size.x, this.size.y);
  }
}
