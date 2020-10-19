package brick.breaker.entities;

import brick.breaker.interfaces.Collision;
import processing.core.PApplet;
import processing.core.PVector;

public class Ball extends Shape<Ball> implements Collision {

  private float radius;

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
}
