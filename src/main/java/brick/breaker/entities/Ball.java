package brick.breaker.entities;

import brick.breaker.interfaces.Collision;
import brick.breaker.interfaces.Movement;
import processing.core.PApplet;
import processing.core.PVector;

public class Ball extends Shape<Ball> implements Collision, Movement {

  private float maxSpeed = 0.6f;
  private float radius;
  private PVector direction;
  private PVector minGameSize;
  private PVector maxGameSize;

  /**
   * Default constructor to create a {@link Ball} object.
   */
  public Ball() {
    super();
    subclass = this;
  }

  @Override
  public Ball setSize(PVector newSize) throws IllegalArgumentException {
    if (newSize.x != newSize.y) {
      throw new IllegalArgumentException("Ball must have equal width and height");
    }

    super.setSize(newSize);
    this.radius = newSize.x / 2;
    return this;
  }

  /**
   * Draws {@link Ball} to screen.
   *
   * @param sketch main {@link PApplet} instance
   */
  public void render(PApplet sketch) {
    sketch.ellipse(this.position.x, this.position.y, this.size.x, this.size.y);
  }

  @Override
  public <T extends Box<T>> boolean isColliding(T object) {
    PVector closestEdge = new PVector();
    closestEdge = this.position.copy();

    if (this.position.x < object.getMin().x) {
      closestEdge.x = object.getMin().x;
    } else if (this.position.x > object.getMax().x) {
      closestEdge.x = object.getMax().x;
    }

    if (this.position.y < object.getMin().y) {
      closestEdge.y = object.getMin().y;
    } else if (this.position.y > object.getMax().y) {
      closestEdge.y = object.getMax().y;
    }

    PVector delta = PVector.sub(this.position, closestEdge);
    float distance = (float) Math.sqrt((delta.x * delta.x) + (delta.y * delta.y));

    return distance <= this.radius;
  }

  @Override
  public <T extends Box<T>> void onCollision(T object) {
    // TODO Auto-generated method stub

  }

  @Override
  public void setMaxSpeed(float limit) throws IllegalArgumentException {
    if (limit <= 0 || limit > 100) {
      throw new IllegalArgumentException("Limit must be between 0 and 100");
    }

    this.maxSpeed = limit / 100;
  }

  @Override
  public void setMovementBoundary(PVector minBoundary, PVector maxBoundary) {
    this.minGameSize = minBoundary;
    this.maxGameSize = maxBoundary;
  }

  @Override
  public void setTargetPosition(PVector position) {
    this.direction = PVector.sub(position, this.position);
    this.direction.normalize();
    this.direction.mult(1f + this.maxSpeed);
  }

  @Override
  public void update() {
    if (this.position.x - this.radius < minGameSize.x
      || this.position.x + this.radius > maxGameSize.x) {
      this.direction.x *= -1;
    }

    if (this.position.y - this.radius < minGameSize.y
      || this.position.y + this.radius > maxGameSize.y) {
      this.direction.y *= -1;
    }

    this.position.add(this.direction);
  }
}
